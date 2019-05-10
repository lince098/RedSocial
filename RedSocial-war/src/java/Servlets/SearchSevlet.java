/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import RedSocialEntities.Groups;
import RedSocialEntities.Users;
import RedSocialFacades.GroupsFacade;
import RedSocialFacades.UsersFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafa
 */
@WebServlet(name = "SearchSevlet", urlPatterns = {"/SearchSevlet"})
public class SearchSevlet extends HttpServlet {

    @EJB
    private GroupsFacade groupsFacade;

    @EJB
    private UsersFacade usersFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer filter;
        try {
            filter = Integer.parseInt(request.getParameter("filter"));//0 is all, 1 is only people and 2 only groups
        }catch(NumberFormatException e){
            filter = 0;
        }

        List<Users> listUsers = new ArrayList<>();
        List<Groups> listGroups = new ArrayList<>();
        String searchText = request.getParameter("search");

        switch (filter) {
            case 1:
                //1 == only people
                listUsers.addAll(usersFacade.findBySearchText(searchText));
                break;
            case 2:
                //2 == only groups
                listGroups.addAll(groupsFacade.findBySearchText(searchText));
                break;
            default:
                //0 == all
                listUsers.addAll(usersFacade.findBySearchText(searchText));
                listGroups.addAll(groupsFacade.findBySearchText(searchText));
        }

        request.setAttribute("listUsers", listUsers);
        request.setAttribute("listGroups", listGroups);
        request.setAttribute("filter", filter);
        RequestDispatcher rd = request.getRequestDispatcher("/SearchPage.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

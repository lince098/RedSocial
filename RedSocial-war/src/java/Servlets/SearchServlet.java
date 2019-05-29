/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import RedSocialEntities.Grupos;
import RedSocialEntities.Users;
import RedSocialFacades.GruposFacade;
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
public class SearchServlet extends HttpServlet {

    @EJB
    private GruposFacade gruposFacade;

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
        } catch (NumberFormatException e) {
            filter = 0;
        }

        List<Users> listUsers = new ArrayList<>();
        List<Grupos> listGroups = new ArrayList<>();
        String searchText = request.getParameter("search");
        if (searchText != null) {
            listUsers.addAll(usersFacade.findBySearchText(searchText));
            listGroups.addAll(gruposFacade.findBySearchText(searchText));
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

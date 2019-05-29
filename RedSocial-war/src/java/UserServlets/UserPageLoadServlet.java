/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserServlets;

import RedSocialEntities.Users;
import RedSocialFacades.ProfilepostsFacade;
import RedSocialFacades.UsersFacade;
import Services.UserService;
import java.io.IOException;
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
@WebServlet(name = "UserPageLoadServlet", urlPatterns = {"/UserPageLoadServlet"})
public class UserPageLoadServlet extends HttpServlet {

    @EJB
    private ProfilepostsFacade profilepostsFacade;

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
        Integer id = Integer.parseInt(request.getParameter("userID"));
        Users u = usersFacade.find(id);
        Users currUser = (Users) request.getAttribute("currentSession");
        if(u == null){
            RequestDispatcher rd = request.getRequestDispatcher("/MainPage.jsp");
            rd.forward(request, response);
        }else{
            if(UserService.getFriends(u).contains(currUser)){
                request.setAttribute("postList", u.getProfilepostsList());
            }else{
                request.setAttribute("postList", profilepostsFacade.getPublicPosts(u));
            }
            request.setAttribute("user", u);
            RequestDispatcher rd = request.getRequestDispatcher("/UserPage.jsp");
            rd.forward(request, response);
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserServlets;

import RedSocialEntities.Users;
import RedSocialFacades.UsersFacade;
import Services.UserService;
import java.io.IOException;
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
@WebServlet(name = "AddFriendServlet", urlPatterns = {"/AddFriendServlet"})
public class AddFriendServlet extends HttpServlet {

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
        Integer id = Integer.parseInt(request.getParameter("id"));
        Users newFriend = usersFacade.find(id);
        Users currentSession = (Users) request.getSession().getAttribute("currentSession");
        
        newFriend.getUsersList2().remove(currentSession);
        newFriend.getUsersList3().remove(currentSession);
        currentSession.getUsersList2().remove(newFriend);
        currentSession.getUsersList3().remove(newFriend);
        
        newFriend.getUsersList().add(currentSession);
        currentSession.getUsersList1().add(newFriend);
        
        usersFacade.edit(currentSession);
        usersFacade.edit(newFriend);
        
        request.getSession().setAttribute("currentSession", currentSession);
        
        RequestDispatcher rd = request.getRequestDispatcher("/FriendlistPage.jsp");
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

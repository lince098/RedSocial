/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserServlets;

import RedSocialEntities.Users;
import RedSocialFacades.UsersFacade;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alae Akalay
 */
@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUserServlet"})
public class EditUserServlet extends HttpServlet {
    
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
        
        String email, password, name, surname, birthday, profile_picture;
        
        email = request.getParameter("email");
        password = request.getParameter("password");
        name = request.getParameter("name");
        surname = request.getParameter("surname");
        birthday = request.getParameter("birthday");
        profile_picture = request.getParameter("profilePicture");
        
        if (email == null || password == null || name == null || surname == null || birthday == null || profile_picture == null) {

            request.setAttribute("Error", "There are some null/wrong parameters.");

            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/EditUser.jsp");
            rd.forward(request, response);
        }
        
        
        Users u = (Users)request.getSession().getAttribute("currentSession");
        
        u.setEmail(email);
        u.setPassword(password);
        u.setName(name);
        u.setSurname(surname);
        
        String[] split = birthday.split("-");
        Date birthDate = new java.util.Date(new Integer(split[0]) - 1900, new Integer(split[1]) - 1, new Integer(split[2]) + 1);
        u.setBirthday(birthDate);
     
        u.setProfilePicture(profile_picture);
        
        request.setAttribute("Success", "The modification proccess was succesfully.");
        usersFacade.edit(u);

        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/EditUser.jsp");
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

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
 * @author PabloGL
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    @EJB
    UsersFacade usersFacade;

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

        String email, password, name, surname, birthday, sex;

        email = request.getParameter("email");
        password = request.getParameter("password");
        name = request.getParameter("name");
        surname = request.getParameter("surname");
        birthday = request.getParameter("birthday");
        sex = request.getParameter("sex");

        if (email == null || password == null || name == null || surname == null || birthday == null || sex == null) {

            request.setAttribute("error", "There are some null parameters.");

            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/UserPages/Register.jsp");
            rd.forward(request, response);
        }

        Users u = new Users();
        u.setEmail(email);

        String[] split = birthday.split("-");
        Date birthDate = new java.util.Date(new Integer(split[0]) - 1900, new Integer(split[1]) - 1, new Integer(split[2]) + 1);
        u.setBirthday(birthDate);

        u.setGender(sex.charAt(0));
        u.setName(name);
        u.setPassword(password);
        u.setSurname(surname);

        request.setAttribute("success", "The registration proccess was succesfully.");
        usersFacade.create(u);

        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/UserPages/Register.jsp");
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

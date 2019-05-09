/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import RedSocialEntities.Grupos;
import RedSocialEntities.Users;
import RedSocialFacades.GruposFacade;
import Services.GrupoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PabloGL
 */
@WebServlet(name = "LeaveGroup", urlPatterns = {"/LeaveGroup"})
public class LeaveGroup extends HttpServlet {

    @EJB
    GruposFacade gf;

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
        Users u = (Users) request.getSession().getAttribute("currentSession");
        Integer id = Integer.parseInt(request.getParameter("groupId"));
        Grupos g = gf.find(id);
        gf.edit(g);
        List<Users> admins = GrupoService.getAdmins(g);
        List<Users> members = GrupoService.getMembers(g);
        if (admins.contains(u)) {
            if (admins.size() - 1 == 0) {
                if (members.size() > 1) {//Name new admin
                    int i = 0;
                    while (u.equals(members.get(i))) {
                        i++;
                    }

                    admins.add(members.get(i));
                    admins.remove(u);
                } else { //Elimina el grupo
                    gf.remove(g);

                    request.getRequestDispatcher("pagina principal").forward(request, response);
                    return;
                }

            } else {
                admins.remove(u);
                members.remove(u);
            }
        } else {
            members.remove(u);
        }
        
        gf.edit(g);

        request.setAttribute("group", g);
        request.setAttribute("isAdmin", false);
        request.setAttribute("isMember", false);

        request.getRequestDispatcher("/GroupPage.jsp").forward(request, response);
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

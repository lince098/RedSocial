/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PostServlets;

import RedSocialEntities.Grupos;
import RedSocialEntities.Post;
import RedSocialEntities.Users;
import RedSocialFacades.GruposFacade;
import RedSocialFacades.PostFacade;
import RedSocialFacades.UsersFacade;
import Services.PostService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EliminatePost", urlPatterns = {"/EliminatePost"})
public class EliminatePost extends HttpServlet {

    @EJB
    PostFacade pf;
    @EJB
    GruposFacade gf;
    @EJB
    UsersFacade uf;

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
        response.setContentType("text/html;charset=UTF-8");
        boolean isGroupPost = Boolean.parseBoolean(request.getParameter("isGroupPost"));
        Users currentSession = (Users) request.getSession().getAttribute("currentSession");
        Integer postId = Integer.parseInt(request.getParameter("postId"));

        Post post = pf.find(postId);

        boolean esAutor = post.getAuthor().equals(currentSession);

        pf.remove(post);

        /*
            Si existe algún método en el que un usuario ve todos sus post y se sacan de la sesión habría que actualizarlo.
        
        if (esAutor) {
            request.setAttribute("currentSession",uf.find(currentSession.getId()));
        }
        
        */
        

        if (isGroupPost) {
            Integer groupId = Integer.parseInt(request.getParameter("groupId"));
            Grupos group = gf.find(groupId);
            request.setAttribute("group", group);

            request.getRequestDispatcher("/GroupPageServlet").forward(request, response);

        } else {

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

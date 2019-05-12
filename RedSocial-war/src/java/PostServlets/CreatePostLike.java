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
@WebServlet(name = "CreatePostLike", urlPatterns = {"/CreatePostLike"})
public class CreatePostLike extends HttpServlet {

    @EJB
    private UsersFacade usersFacade;

    @EJB
    PostFacade pf;
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
        boolean isGroupPost = Boolean.parseBoolean(request.getParameter("isGroupPost"));
        Users user = (Users) request.getSession().getAttribute("currentSession");
        Integer postId = Integer.parseInt(request.getParameter("postId"));

        Post post = pf.find(postId);

        PostService.getLikeList(post).add(user);

        pf.edit(post);

        if (isGroupPost) {
            Integer groupId = Integer.parseInt(request.getParameter("groupId"));
            Grupos group = gf.find(groupId);
            request.setAttribute("group", group);

            request.getRequestDispatcher("/GroupPageServlet").forward(request, response);

        } else {
            boolean isMainPage = Boolean.parseBoolean(request.getParameter("isMainPage"));
            if (isMainPage) {
                request.getRequestDispatcher("/MainPage.jsp").forward(request, response);
            } else {
                Integer userID = Integer.parseInt(request.getParameter("userID"));
                Users u = usersFacade.find(userID);
                request.setAttribute("user", u);
                request.getRequestDispatcher("/UserPage.jsp").forward(request, response);
            }
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

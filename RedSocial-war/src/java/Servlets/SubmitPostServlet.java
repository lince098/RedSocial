/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import RedSocialEntities.Post;
import RedSocialEntities.Profileposts;
import RedSocialEntities.Users;
import RedSocialFacades.PostFacade;
import RedSocialFacades.ProfilepostsFacade;
import RedSocialFacades.UsersFacade;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name = "SubmitPostServlet", urlPatterns = {"/SubmitPostServlet"})
public class SubmitPostServlet extends HttpServlet {

    @EJB
    private UsersFacade usersFacade;

    @EJB
    private ProfilepostsFacade profilepostsFacade;

    @EJB
    private PostFacade postFacade;

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
        String title = request.getParameter("title");
        String message = request.getParameter("postMessage");
        String vision = request.getParameter("vision");
        Users author = (Users) request.getSession().getAttribute("currentSession");
        
        Post p = new Post();
        p.setAuthor(author);
        p.setText(message);
        p.setTitle(title);
        p.setDate(new Date());
        postFacade.create(p);
        
        List<Post> listPostAuthor = author.getPostList();
        listPostAuthor.add(p);
        author.setPostList(listPostAuthor);
        
        usersFacade.edit(author);
        
        Profileposts profilePost = new Profileposts();
        //profilePost.setId(profilepostsFacade.getNextID());
        profilePost.setPost(p);
        profilePost.setReceiver(author);
        profilepostsFacade.create(profilePost);
        
        List<Profileposts> listProfilePostAuthor = author.getProfilepostsList();
        listProfilePostAuthor.add(profilePost);
        
        author.setProfilepostsList(listProfilePostAuthor);
        usersFacade.edit(author);
        
        
        request.getSession().setAttribute("currentSession", author);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MainPage.jsp");
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

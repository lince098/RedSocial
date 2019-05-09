/*  
        Recive:
        
        receiverGroup (id)
        author  Usa currentSession
        postText
        visibilidad

        Devuelve hacia : 

        
 */
package Servlets;

import RedSocialEntities.Groupposts;
import RedSocialEntities.Grupos;
import RedSocialEntities.Post;
import RedSocialEntities.Users;
import RedSocialFacades.GrouppostsFacade;
import RedSocialFacades.GruposFacade;
import RedSocialFacades.PostFacade;
import RedSocialFacades.UsersFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "NewPost", urlPatterns = {"/NewPost"})
public class NewPost extends HttpServlet {

    @EJB
    GruposFacade gf;
    @EJB
    UsersFacade uf;
    @EJB
    GrouppostsFacade gpf;
    @EJB
    PostFacade pf;

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

        /*
        groupReceiver (id)
        postText
        visibilidad
         */
        Users currentSession = (Users) request.getSession().getAttribute("currentSession");

        Grupos grupo = gf.find(Integer.parseInt(request.getParameter("receiverGroup")));

        String text = request.getParameter("postText");
        String visibilidad = request.getParameter("visibilidad");

        Post post = new Post();
        post.setAuthor(currentSession);
        post.setDate(new Date());
        post.setText(text);
        post.setTitle("titulo");

        pf.create(post);
        
        Groupposts gp = new Groupposts();
        gp.setPost(post);
        gp.setGrupo(grupo);
        gp.setVision(visibilidad);
        gp.setId(post.getId());

        //relación autor
        currentSession.getPostList().add(post);
        uf.edit(currentSession);

        post.setGroupposts(gp);
        
        gpf.create(gp);

        pf.edit(post);

        grupo.getGrouppostsList().add(gp);

        gf.edit(grupo);

        request.setAttribute("groupId", grupo.getId());

        request.getRequestDispatcher("/GroupPageServlet").forward(request, response);

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

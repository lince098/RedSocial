/**
 *
 * @author PabloGL
 */
package GroupServlets;

import RedSocialEntities.Grupos;
import RedSocialEntities.Users;
import RedSocialFacades.GruposFacade;
import RedSocialFacades.UsersFacade;
import Services.GrupoService;
import Services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CreateGroup", urlPatterns = {"/CreateGroup"})
public class CreateGroup extends HttpServlet {

    @EJB GruposFacade gf;
    @EJB UsersFacade uf;
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

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        
        if (name == null || description == null) {
            request.setAttribute("error", "Se ha dejado un parámetro nulo.");
            request.getRequestDispatcher("CreateGroup.jsp").forward(request, response);
        }
       
        Users currentSession = (Users) request.getSession().getAttribute("currentSession");
        
        Grupos group = new Grupos();
        group.setCreationDate(new Date());
        group.setDescription(description);
        group.setName(name);     
       
        gf.create(group);
        
        GrupoService.getAdmins(group).add(currentSession);
        GrupoService.getMembers(group).add(currentSession);
        UserService.getGrupos(currentSession).add(group);
        UserService.getAdministratedGroups(currentSession).add(group);
        
        gf.edit(group);
        uf.edit(currentSession);
        
        request.setAttribute("group", group);
        
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

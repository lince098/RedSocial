/**
 * @author Pablo Gamarro Lozano
 */

package GroupServlets;

import RedSocialEntities.Grupos;
import RedSocialEntities.Users;
import RedSocialFacades.GruposFacade;
import RedSocialFacades.UsersFacade;
import Services.GrupoService;
import Services.UserService;
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
@WebServlet(name = "GroupJoinPetition", urlPatterns = {"/GroupJoinPetition"})
public class GroupJoinPetition extends HttpServlet {

    @EJB UsersFacade uf;
    @EJB GruposFacade gf;
    
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
        GrupoService.getGroupJoinPetitions(g).add(u);
        UserService.getGroupJoinPetitions(u).add(g);
        
        uf.edit(u);
        gf.edit(g);
        
        request.setAttribute("group", g);
        
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

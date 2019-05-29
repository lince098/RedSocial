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
        Users currentSession = (Users) request.getSession().getAttribute("currentSession");
        Integer id = Integer.parseInt(request.getParameter("groupId"));
        Grupos group = gf.find(id);
        gf.edit(group);
        List<Users> admins = GrupoService.getAdmins(group);
        List<Users> members = GrupoService.getMembers(group);
        List<Grupos> administeredGroups = UserService.getAdministratedGroups(currentSession);
        List<Grupos> groupMembership = UserService.getGrupos(currentSession);

        if (admins.contains(currentSession)) {
            if (admins.size() - 1 == 0) {
                if (members.size() > 1) {//Name new admin
                    int i = 0;
                    while (currentSession.equals(members.get(i))) {
                        i++;
                    }

                    admins.add(members.get(i));
                    admins.remove(currentSession);
                    members.remove(currentSession);
                    administeredGroups.remove(group);
                    groupMembership.remove(group);
                } else { //Elimina el grupo
                    administeredGroups.remove(group);
                    groupMembership.remove(group);
                    gf.remove(group);
                    
                    //Recargo la session para que se actualice la lista de grupos.
                    
                   uf.edit(currentSession);
                   
                    request.getRequestDispatcher("/MainPage.jsp").forward(request, response);
                    return;
                }

            } else {
                admins.remove(currentSession);
                members.remove(currentSession);
                groupMembership.remove(group);
                administeredGroups.remove(group);
            }
        } else {
            members.remove(currentSession);
            groupMembership.remove(group);
        }

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
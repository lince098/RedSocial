/**
 * @author Pablo Gamarro Lozano
 */

package GroupServlets;

/*
        Receives: 
        parametro :"groupId"
        session "currentSession"
        Returns : "group" "groupAdmin" "groupMember"           
        forwardTo-to : Group Page
 */
import RedSocialEntities.Grupos;
import RedSocialEntities.Users;
import RedSocialFacades.GrouppostsFacade;
import RedSocialFacades.GruposFacade;
import Services.GrupoService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PabloGL
 */
@WebServlet(name = "GroupPageServlet", urlPatterns = {"/GroupPageServlet"})
public class GroupPageServlet extends HttpServlet {

    @EJB
    GruposFacade gf;
    @EJB
    GrouppostsFacade gpf;

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

        HttpSession session = request.getSession();

        String groupIdS = request.getParameter("groupId");
        Grupos groupToShow;

        //Por si lo paso como atributo
        if (groupIdS == null) {
            groupToShow = (Grupos) request.getAttribute("group");
            
        } else {
            groupToShow = gf.find(Integer.parseInt(groupIdS));
        }

        request.setAttribute("group", groupToShow);

        // Comprobar si pertenece al grupo y añadirlo al request
        List<Users> members = GrupoService.getMembers(groupToShow);
        Users currentSession = (Users) session.getAttribute("currentSession");

        if (members.contains(currentSession)) {

            //Comprobar si es admin y añadirlo al request
            List<Users> adminList = GrupoService.getAdmins(groupToShow);
            boolean esAdmin = adminList.contains(currentSession);
            request.setAttribute("isAdmin", esAdmin);
            request.setAttribute("isMember", true);
            request.setAttribute("postList", gpf.everyNGroupPosts(20, groupToShow));

        } else {
            request.setAttribute("isAdmin", false);
            request.setAttribute("isMember", false);
            request.setAttribute("postList", gpf.onlyNPublicGroupPosts(20, groupToShow));
        }

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

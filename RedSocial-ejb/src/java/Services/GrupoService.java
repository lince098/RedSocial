/**
 * @author Pablo Gamarro Lozano
 *
 * Hecho sólo para no tener que estar lidiando con cambiar nombres a las 
 * funciones cada vez que se le hace un refactor a la BD
 */
package Services;

import RedSocialEntities.Grupos;
import RedSocialEntities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author PabloGL
 */
@Stateless
@LocalBean
public class GrupoService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public static List<Users> getGroupJoinPetitions(Grupos grupo){
        return grupo.getUsersList();
    }
    
    public static List<Users> getAdmins(Grupos grupo){
        return grupo.getUsersList1();
    }
    
    public static List<Users> getMembers(Grupos grupo){
        return grupo.getUsersList2();
    }
    
    
}

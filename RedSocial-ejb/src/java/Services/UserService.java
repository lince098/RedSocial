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
public class UserService {

    public static List<Grupos> getGrupos(Users user) {
        return user.getGruposList2();
    }

    public static List<Grupos> getAdministratedGroups(Users user) {
        return user.getGruposList1();
    }

    public static List<Grupos> getGroupJoinPetitions(Users user) {
        return user.getGruposList();
    }
}

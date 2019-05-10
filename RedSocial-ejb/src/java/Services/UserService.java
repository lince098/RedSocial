/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public static List<Grupos> getGrupos(Users user){
        return user.getGruposList2();
    }
    
    public static List<Grupos> getAdministratedGroups(Users user){
        return user.getGruposList1();
    }
    
    public static List<Grupos> getGroupJoinPetitions(Users user){
        return user.getGruposList();
    }
}

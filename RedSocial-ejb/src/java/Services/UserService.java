/**
 * @author Pablo Gamarro Lozano
 *
 * Hecho sólo para no tener que estar lidiando con cambiar nombres a las 
 * funciones cada vez que se le hace un refactor a la BD
 */
package Services;

import RedSocialEntities.Grupos;
import RedSocialEntities.Post;
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
    
    public static List<Post> getLikeList(Users user){
        return  user.getPostList();
    }
    public static List<Post> getUserPosts(Users user){
        return  user.getPostList1();
    }
    
    public static List<Users> getFriendshipPetitionApplicant(Users user){
        List<Users> friendPetitionList = user.getUsersList2();
        if(friendPetitionList != null){
            while(friendPetitionList.contains(user)){
                friendPetitionList.remove(user);
            }
        }
        return friendPetitionList;
    }
    
    public static List<Users> getFriendshipPetitionRequested(Users user){
        List<Users> friendPetitionList = user.getUsersList3();
        if(friendPetitionList != null){
            while(friendPetitionList.contains(user)){
                friendPetitionList.remove(user);
            }
        }
        return friendPetitionList;
    }
    
    public static List<Users> getFriends(Users user){
        List<Users> friendList = user.getUsersList1();
        if(friendList != null){
            while(friendList.contains(user)){
                friendList.remove(user);
            }
        }
        return friendList;
    }
}

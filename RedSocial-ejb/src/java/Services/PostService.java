/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
public class PostService {

    public static List<Users> getLikeList(Post post) {
        return post.getUsersList();
    }
}

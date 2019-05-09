package RedSocialEntities;

import RedSocialEntities.Grupos;
import RedSocialEntities.Messages;
import RedSocialEntities.Post;
import RedSocialEntities.Profileposts;
import RedSocialEntities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-10T00:11:59")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Date> birthday;
    public static volatile ListAttribute<Users, Users> usersList;
    public static volatile ListAttribute<Users, Users> usersList1;
    public static volatile SingularAttribute<Users, Character> gender;
    public static volatile ListAttribute<Users, Grupos> gruposList;
    public static volatile ListAttribute<Users, Users> usersList3;
    public static volatile ListAttribute<Users, Users> usersList2;
    public static volatile ListAttribute<Users, Post> postList;
    public static volatile ListAttribute<Users, Profileposts> profilepostsList;
    public static volatile SingularAttribute<Users, Short> isAdmin;
    public static volatile SingularAttribute<Users, String> profilePicture;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile ListAttribute<Users, Messages> messagesList1;
    public static volatile ListAttribute<Users, Messages> messagesList;
    public static volatile SingularAttribute<Users, String> surname;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile ListAttribute<Users, Grupos> gruposList1;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile ListAttribute<Users, Grupos> gruposList2;

}
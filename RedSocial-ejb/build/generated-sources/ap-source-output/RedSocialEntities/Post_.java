package RedSocialEntities;

import RedSocialEntities.Groupposts;
import RedSocialEntities.Profileposts;
import RedSocialEntities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-10T11:14:24")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, Date> date;
    public static volatile SingularAttribute<Post, Users> author;
    public static volatile SingularAttribute<Post, Groupposts> groupposts;
    public static volatile SingularAttribute<Post, Profileposts> profileposts;
    public static volatile SingularAttribute<Post, Integer> id;
    public static volatile SingularAttribute<Post, String> text;
    public static volatile SingularAttribute<Post, String> title;

}
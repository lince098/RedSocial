package RedSocialEntities;

import RedSocialEntities.Post;
import RedSocialEntities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-08T09:10:03")
@StaticMetamodel(Profileposts.class)
public class Profileposts_ { 

    public static volatile SingularAttribute<Profileposts, Post> post;
    public static volatile SingularAttribute<Profileposts, Users> receiver;
    public static volatile SingularAttribute<Profileposts, Integer> id;

}
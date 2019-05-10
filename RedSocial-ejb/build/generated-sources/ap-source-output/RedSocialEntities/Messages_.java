package RedSocialEntities;

import RedSocialEntities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-10T11:14:24")
@StaticMetamodel(Messages.class)
public class Messages_ { 

    public static volatile SingularAttribute<Messages, Date> date;
    public static volatile SingularAttribute<Messages, Users> receiver;
    public static volatile SingularAttribute<Messages, Users> sender;
    public static volatile SingularAttribute<Messages, Integer> id;
    public static volatile SingularAttribute<Messages, String> text;
    public static volatile SingularAttribute<Messages, String> title;

}
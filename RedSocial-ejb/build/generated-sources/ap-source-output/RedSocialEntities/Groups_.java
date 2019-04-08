package RedSocialEntities;

import RedSocialEntities.Groupposts;
import RedSocialEntities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-08T09:10:03")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile ListAttribute<Groups, Users> usersList;
    public static volatile ListAttribute<Groups, Users> usersList1;
    public static volatile SingularAttribute<Groups, String> name;
    public static volatile SingularAttribute<Groups, Integer> numberLimit;
    public static volatile SingularAttribute<Groups, String> description;
    public static volatile SingularAttribute<Groups, Integer> id;
    public static volatile SingularAttribute<Groups, Date> creationDate;
    public static volatile ListAttribute<Groups, Groupposts> grouppostsList;

}
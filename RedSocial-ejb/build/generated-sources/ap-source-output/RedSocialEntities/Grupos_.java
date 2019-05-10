package RedSocialEntities;

import RedSocialEntities.Groupposts;
import RedSocialEntities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-10T11:14:24")
@StaticMetamodel(Grupos.class)
public class Grupos_ { 

    public static volatile ListAttribute<Grupos, Users> usersList;
    public static volatile ListAttribute<Grupos, Users> usersList1;
    public static volatile ListAttribute<Grupos, Users> usersList2;
    public static volatile SingularAttribute<Grupos, String> imagePath;
    public static volatile SingularAttribute<Grupos, String> name;
    public static volatile SingularAttribute<Grupos, Integer> numberLimit;
    public static volatile SingularAttribute<Grupos, String> description;
    public static volatile SingularAttribute<Grupos, Integer> id;
    public static volatile SingularAttribute<Grupos, Date> creationDate;
    public static volatile ListAttribute<Grupos, Groupposts> grouppostsList;

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocialFacades;

import RedSocialEntities.Profileposts;
import RedSocialEntities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PabloGL
 */
@Stateless
public class ProfilepostsFacade extends AbstractFacade<Profileposts> {

    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfilepostsFacade() {
        super(Profileposts.class);
    }
    
    public List<Profileposts> getPublicPosts(Users user){
        Query q = em.createNamedQuery("Profileposts.findByUser").setParameter("userID", user.getId());
        return (List<Profileposts>) q.getResultList();
    }
}

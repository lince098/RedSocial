/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocialFacades;

import RedSocialEntities.Groupposts;
import RedSocialEntities.Grupos;
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
public class GrouppostsFacade extends AbstractFacade<Groupposts> {

    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrouppostsFacade() {
        super(Groupposts.class);
    }
    
    
    public List<Groupposts> onlyNPublicGroupPosts(int n, Grupos group) {
        Query q;
        q = this.getEntityManager().createQuery("SELECT gp FROM Groupposts gp JOIN gp.post p  WHERE  gp.grupo = :grupo AND gp.vision = 'Public'  ORDER BY p.date DESC");

        q.setMaxResults(n);
        q.setParameter("grupo", group);

        return q.getResultList();
    }

    public List<Groupposts> everyNGroupPosts(int n, Grupos group) {
       Query q = this.getEntityManager().createQuery("SELECT gp FROM Groupposts gp JOIN gp.post p  WHERE  gp.grupo = :grupo ORDER BY p.date DESC");

        q.setMaxResults(n);
        q.setParameter("grupo", group);

        return q.getResultList();
    }
}

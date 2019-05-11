/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocialFacades;

import RedSocialEntities.Grupos;
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
public class GruposFacade extends AbstractFacade<Grupos> {

    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GruposFacade() {
        super(Grupos.class);
    }

    public List<Grupos> findBySearchText(String searchText) {
        Query q = em.createNamedQuery("Groups.findBySearchText").setParameter("searchText", searchText);
        return (List<Grupos>) q.getResultList();
    }
}

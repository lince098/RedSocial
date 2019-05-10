/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocialFacades;

import RedSocialEntities.Grupos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
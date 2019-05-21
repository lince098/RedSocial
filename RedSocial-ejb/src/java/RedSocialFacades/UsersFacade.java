/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocialFacades;

import RedSocialEntities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    /**
     * @author Pablo Gamarro Lozano
     * @param email
     * @param password
     * @return
     */
    public List<Users> checkCredentials(String email, String password) {
        Query q = em.createQuery("SELECT u FROM Users u WHERE u.email = :email and u.password = :password");
        q.setParameter("email", email);
        q.setParameter("password", password);

        return (List<Users>) q.getResultList();
    }
    
    public List<Users> findBySearchText(String searchText) {
        Query q = em.createNamedQuery("Users.findBySearchText").setParameter("searchText", searchText);
        return (List<Users>) q.getResultList();
    }
    
    public List<Users> findFriends(Users user){
        Query q = em.createNamedQuery("Users.findFriends").setParameter("id", user.getId());
        return (List<Users>) q.getResultList();
    }
    /* public List<Users> findFriendsv2(Users user){
        Query q = em.createQuery("SELECT l FROM Users u JOIN u.usersList l ");
        return (List<Users>) q.getResultList();
    }*/
}

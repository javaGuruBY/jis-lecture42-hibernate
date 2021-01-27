package by.jrr.dao.userdao;

import by.jrr.bean.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import java.util.List;

import static by.jrr.dao.HibernateEmUtil.getEntityManager;

public class UserDaoEm {
//    https://www.baeldung.com/jpa-entity-manager-get-reference

    public User saveUser(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    public List<User> findAll() {
        EntityManager em = getEntityManager();
        List<User> users = em.createQuery("from User", User.class).getResultList();
        return users;
    }

    public User findById(Long id) {
        EntityManager em = getEntityManager();
        User user = getEntityManager().find(User.class, id);
        return user;

    }

    public User update(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        User mergedUser = em.merge(user);
        em.getTransaction().commit();
        return mergedUser;
    }

    /** demonstrates deleting from context, but not from database
     * to avoid such cases, global flush of commit could be used.
     */
    public void delete_badDemo(User user) {
        EntityManager em = getEntityManager();
        em.remove(user);
    }

    public void delete(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(user);
        em.flush(); //set brakepoint here to demonstrate flush result
        em.getTransaction().commit();
    }
}


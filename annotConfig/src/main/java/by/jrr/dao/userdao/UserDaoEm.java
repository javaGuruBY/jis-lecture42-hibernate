package by.jrr.dao.userdao;

import by.jrr.bean.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class UserDaoEm {

    @PersistenceContext
    EntityManager entityManager;

    EntityManagerFactory ef = Persistence.createEntityManagerFactory("item-manager-pu");

    public EntityManager getEntityManager() {
        return ef.createEntityManager();
    }

    public void saveUser(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
}


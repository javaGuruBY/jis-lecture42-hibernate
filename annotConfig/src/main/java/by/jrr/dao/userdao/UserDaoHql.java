package by.jrr.dao.userdao;

import by.jrr.bean.Human;
import by.jrr.bean.User;
import by.jrr.dao.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class UserDaoHql {

    public void saveUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("update User set userName = :userName where id = :id");
        query.setParameter("id", user.getId());
        query.setParameter("userName", user.getUserName());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> humans = session.createQuery("from User").getResultList();
        session.close();
        return humans;
    }

    public User findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User where id = :id");
        query.setParameter("id", id);
        User users = (User) query.getSingleResult();
        session.close();
        return users;
    }

    public void deleteUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from User where id = :id and userName = :userName");
        query.setParameter("id", user.getId());
        query.setParameter("userName", user.getUserName());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(long userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from User where id = :id");
        query.setParameter("id", userId);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}

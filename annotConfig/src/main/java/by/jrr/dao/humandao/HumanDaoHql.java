package by.jrr.dao.humandao;

import by.jrr.bean.Human;
import by.jrr.bean.User;
import by.jrr.dao.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class HumanDaoHql {

    public void saveHuman(Human human) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        human.getAlumnusList().forEach(session::save);
        human.getStudentList().forEach(session::save);
        session.save(human);
        session.getTransaction().commit();
    }

    public void updateHuman(Human human) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("update User set name = :name where id = :id");
        query.setParameter("id", human.getId());
        query.setParameter("name", human.getName());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public List<Human> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Human> humans = session.createQuery("from Human").getResultList();
        session.close();
        return humans;
    }

    public Human findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Human where id = :id");
        query.setParameter("id", id);
        Human human = (Human) query.getSingleResult();
        session.close();
        return human;
    }

    public void deleteHuman(Human human) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Human where id = :id and name = :name");
        query.setParameter("id", human.getId());
        query.setParameter("name", human.getName());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void deleteHuman(long humanId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Human where id = :id");
        query.setParameter("id", humanId);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}

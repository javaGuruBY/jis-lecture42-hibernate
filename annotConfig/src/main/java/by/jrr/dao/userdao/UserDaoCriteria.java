package by.jrr.dao.userdao;

import by.jrr.bean.User;
import by.jrr.dao.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDaoCriteria {

    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        List result = criteria.list();

        return result;
    }

    public User findById(long id) {
        //Alias
        //Restrictions
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id", id));
        User result = (User) criteria.uniqueResult();

        return result;
    }

    public User updateUser(User user) {
        // not implemented in hibernate
        return null;
    }
}

package by.jrr.dao.humandao;

import by.jrr.bean.Human;
import by.jrr.bean.User;
import by.jrr.dao.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class HumanDaoCriteria {

    public Human findByStudentId(long id) {
        //Alias
        //Restrictions
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Human.class);
        criteria.createCriteria("studentList").add(Restrictions.eq("id", id));
        Human result = (Human) criteria.uniqueResult();

        return result;
    }

    public Human findByAlumniNickName(String nickName) {
        //Alias
        //Restrictions
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Human.class);
        criteria.createCriteria("alumnusList").add(Restrictions.eq("nickName", nickName));
        Human result = (Human) criteria.uniqueResult();

        return result;
    }
}

package by.jrr;

import by.jrr.bean.Mentor;
import by.jrr.dao.HibernateUtil;
import by.jrr.service.HumanService;
import org.hibernate.Session;

import java.util.List;

public class App {


    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");

        Session session = HibernateUtil.getSessionFactory().openSession();

        HumanService humanService = new HumanService();
        List<Mentor> humanList = humanService.getCachedMentors();
        System.out.println(humanList);

        List<Mentor> humanList2 = humanService.getCachedMentors();
        System.out.println(humanList2);

        session.close();
        HibernateUtil.shutdown();
    }
}


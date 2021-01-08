package by.jrr;


import by.jrr.bean.Boy;
import by.jrr.dao.HibernateUtil;
import org.hibernate.Session;

public class App {


    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Boy boy = new Boy();
        boy.setBoy("DDDDD");
        session.save(boy);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}


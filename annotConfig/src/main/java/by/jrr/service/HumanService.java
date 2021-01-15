package by.jrr.service;

import by.jrr.bean.Alumnus;
import by.jrr.bean.Human;
import by.jrr.bean.Mentor;
import by.jrr.bean.Student;
import by.jrr.dao.HibernateUtil;
import net.sf.ehcache.CacheManager;
import org.hibernate.Session;

import java.util.List;

public class HumanService {

    public void saveSomeHumans() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(new Human(null, "Max"));
        session.save(new Student("http://stud.github.com"));
        session.save(new Alumnus(true));
        session.save(new Mentor(32.00));

        Human human = new Human();
        human.setName("Mikas");

        Student student = new Student();
        student.setGitHub("http://mikas.github.com");
        student.setName("Vladimir");

        Alumnus alumnus = new Alumnus();
        alumnus.setGitHub("http://dmitro.github.com");
        alumnus.setName("Dzmitro");
        alumnus.setHired(true);

        Mentor mentor = new Mentor();
        mentor.setName("Anton");
        mentor.setSalary(64.00);

        session.save(human);
        session.save(student);
        session.save(alumnus);
        session.save(mentor);

        session.getTransaction().commit();
    }

    public List<Human>  getAllHumans() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Human> humans = session.createQuery("from Human").getResultList();
        session.close();
        return humans;
    }

    public List<Student>  getAllStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = session.createQuery("from Student").getResultList();
        session.close();
        return students;
    }

    public List<Mentor>  getAllMentors() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Mentor> mentors = session.createQuery("from Mentor").getResultList();
        session.close();
        return mentors;
    }

    public List<Alumnus>  getAllAlumnus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Alumnus> alumnus = session.createQuery("from Alumnus").getResultList();
        session.close();
        return alumnus;
    }

    public List<Mentor> getCachedMentors() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Mentor> humans = session.createQuery("from Mentor").getResultList();
        humans.forEach(System.out::println);

        List<CacheManager> cacheManagers = CacheManager.ALL_CACHE_MANAGERS;
        try {
            int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
                    .getCache("by.jrr.bean.Mentor").getSize();
            System.out.println("[CACHE SIZE ] "+ size);
            System.out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return humans;
    }
}

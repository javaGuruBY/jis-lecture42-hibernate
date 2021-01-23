package by.jrr.service;

import by.jrr.bean.*;
import by.jrr.dao.HibernateUtil;
import net.sf.ehcache.CacheManager;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.stat.SessionStatistics;
import org.hibernate.stat.Statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HumanService {

    public void saveSomeHumans() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        session.save(new Human(null, "Max"));
////        session.save(new Student("http://stud.github.com"));
//        AlumnusPIIData transientPii = new AlumnusPIIData();
//        session.save(new Alumnus(true, transientPii));
//        session.save(transientPii);
//
//        Student piiStudent = new Student("http://stud.github.com", null);
//        StudentPIIData piiData = new StudentPIIData();
//        piiData.setStudent(piiStudent);
//        session.save(piiData);
//        session.save(piiStudent);
//
//
//        Student student1 = new Student();
//        Student student2 = new Student();
//        session.save(student1);
//        session.save(student2);
//        List<Student> students = new ArrayList<>();
//        students.add(student1);
//        students.add(student2);
//
//        Student student3 = new Student();
//        Student student4 = new Student();
//        session.save(student3);
//        session.save(student4);
//        List<Student> students2 = new ArrayList<>();
//        students.add(student3);
//        students.add(student4);
//
//        Alumnus alumnus1 = new Alumnus();
//        Alumnus alumnus2 = new Alumnus();
//        session.save(alumnus1);
//        session.save(alumnus2);
//        List<Alumnus> alumni = new ArrayList<>();
//        alumni.add(alumnus1);
//        alumni.add(alumnus2);
//
//        MentorPIIData mentorPIIData = new MentorPIIData();
//        mentorPIIData.setData("my Mentor Pii data");
//
//
//        session.save(mentorPIIData);
//        session.save(new Mentor(32.00, students, alumni, mentorPIIData));
//        session.save(new Mentor(99.00, students2, alumni, mentorPIIData));
//
//        Human human = new Human();
//        human.setName("Mikas");
//
//        Student student = new Student();
//        student.setGitHub("http://mikas.github.com");
//        student.setName("Vladimir");
//
//        AlumnusPIIData alumnusPIIData = new AlumnusPIIData();
//        alumnusPIIData.setData("second sensitive data");
//        session.save(alumnusPIIData);
//
//        Alumnus alumnus = new Alumnus();
//        alumnus.setGitHub("http://dmitro.github.com");
//        alumnus.setName("Dzmitro");
//        alumnus.setHired(true);
//        alumnus.setPiiData(alumnusPIIData);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Anton");
//        mentor.setSalary(64.00);
//
//        session.save(human);
//        session.save(student);
//        session.save(alumnus);
//        session.save(mentor);

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

    public List<AlumnusPIIData> getAlumnusPiiData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<AlumnusPIIData> humans = session.createQuery("from AlumnusPIIData").getResultList();
        return humans;
    }

    public List<StudentPIIData> getStudentPiiData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<StudentPIIData> studentPIIData = session.createQuery("from StudentPIIData").getResultList();
        return studentPIIData;
    }

    public List<Mentor> getCachedMentors() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Mentor");
        query.setCacheable(true);
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

        Statistics factoryStatistics = HibernateUtil.getSessionFactory().getStatistics();
        SessionStatistics sessionStatistics = session.getStatistics();
        Cache cache = HibernateUtil.getSessionFactory().getCache();

        session.close();
        return humans;
    }

    public Mentor findOneCahedMentor() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Mentor where id = 55");
        Object mentor = query.getSingleResult();

        try {
            String[] cacheNames = CacheManager.ALL_CACHE_MANAGERS.get(0).getCacheNames();
            System.out.println("[CACHE SIZE ] "+ cacheNames);
            System.out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (Mentor) mentor;
    }
}

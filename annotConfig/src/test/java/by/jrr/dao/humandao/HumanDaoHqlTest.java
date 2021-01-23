package by.jrr.dao.humandao;

import by.jrr.bean.Alumnus;
import by.jrr.bean.Human;
import by.jrr.bean.Student;
import by.jrr.dao.HibernateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HumanDaoHqlTest {

    HumanDaoHql humanDao;

    @BeforeEach
    public void setUp() {
        humanDao = new HumanDaoHql();
    }

    @Test
    void saveHuman() {
        Human human = new Human();
        human.setName("not a human");
        human.setAlumnusList(getAlumni());
        human.setStudentList(getStudents());
        humanDao.saveHuman(human);
    }

    @Test
    void updateHuman() {
    }

    @Test
    void findAll() {
        List<Human> humans = humanDao.findAll();
        assertTrue(humans.size() >0);
        //todo: failed to lazily initialize a collection of role:
        //  by.jrr.bean.Human.studentList, could not initialize proxy - no Session
        assertTrue(humans.get(0).getStudentList().size() >0);
        assertTrue(humans.get(0).getAlumnusList().size() >0);
    }

    @Test
    void findById() {
        Human human = humanDao.findById(24L);
        //todo: failed to lazily initialize a collection of role:
        //  by.jrr.bean.Human.studentList, could not initialize proxy - no Session
        assertTrue(human.getStudentList().size() >0);
        assertTrue(human.getAlumnusList().size() >0);
    }

    @Test
    void deleteHuman() {
        humanDao.deleteHuman(24L);
        //todo: orphants still persist
    }

    @Test
    void deleteHuman1() {
    }

    private List<Alumnus> getAlumni() {
        List<Alumnus> alumni = new ArrayList<>();
        Alumnus alumnus1 = new Alumnus("git.3", "lumni.3");
        Alumnus alumnus2 = new Alumnus("git.4", "lumni.4");
        alumni.add(alumnus1);
        alumni.add(alumnus2);
        return alumni;
    }

    private List<Student> getStudents() {
        Student student3 = new Student("git.3");
        Student student4 = new Student("git.4");
        List<Student> students2 = new ArrayList<>();
        students2.add(student3);
        students2.add(student4);
        return students2;
    }
}

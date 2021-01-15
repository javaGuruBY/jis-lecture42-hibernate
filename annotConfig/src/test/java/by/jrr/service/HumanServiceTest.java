package by.jrr.service;

import by.jrr.bean.Alumnus;
import by.jrr.bean.Human;
import by.jrr.bean.Mentor;
import by.jrr.bean.Student;
import by.jrr.service.HumanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class HumanServiceTest {

    HumanService humanService;

    @BeforeEach
    public void setUp() {
        this.humanService = new HumanService();
    }

    @Test
    void saveSomeHumans() {
        humanService.saveSomeHumans();
    }

    @Test
    void getAllHumans() {
        List<Human> humanList = humanService.getAllHumans();
        System.out.println(humanList);
    }

    @Test
    void getAllStudents() {
        List<Student> humanList = humanService.getAllStudents();
        System.out.println(humanList);
    }

    @Test
    void getAllMentors() {
        List<Mentor> humanList = humanService.getAllMentors();
        System.out.println(humanList);
    }

    @Test
    void getAllAlumnus() {
        List<Alumnus> humanList = humanService.getAllAlumnus();
        System.out.println(humanList);
    }

    @Test
    void getCachedMentors() {
        List<Mentor> humanList = humanService.getCachedMentors();
        System.out.println(humanList);
    }

    @Test
    void findOneCahedMentor() {
        Mentor mentor = humanService.findOneCahedMentor();
        System.out.println(mentor);
    }
}

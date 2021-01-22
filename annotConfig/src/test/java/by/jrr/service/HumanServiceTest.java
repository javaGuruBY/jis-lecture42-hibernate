package by.jrr.service;

import by.jrr.bean.*;
import by.jrr.service.HumanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Alumnus> filteredHumanList = humanList.stream()
                .filter(a -> a.getPiiData() != null)
                .collect(Collectors.toList());
        AlumnusPIIData alumnusPIIData = filteredHumanList.get(0).getPiiData();
        System.out.println(humanList);
    }

    @Test
    void getAlumnusPiiData() {
        List<AlumnusPIIData> alumnusPIIDataList = humanService.getAlumnusPiiData();
        System.out.println(alumnusPIIDataList);
    }

    @Test
    void getStudentPiiData() {
        List<StudentPIIData> studentPIIData = humanService.getStudentPiiData();
        System.out.println(studentPIIData);
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

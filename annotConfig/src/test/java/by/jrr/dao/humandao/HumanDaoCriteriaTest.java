package by.jrr.dao.humandao;

import by.jrr.bean.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanDaoCriteriaTest {

    HumanDaoCriteria humanDao;

    @BeforeEach
    public void setUp() {
        humanDao = new HumanDaoCriteria();
    }

    @Test
    void findByStudentId() {
        humanDao.findByStudentId(40L);
    }

    @Test
    void findByAlumniNickName() {
        Human human = humanDao.findByAlumniNickName("lumni.3");
        assertNull(human);
    }
}

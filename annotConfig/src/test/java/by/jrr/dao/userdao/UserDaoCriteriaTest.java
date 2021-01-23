package by.jrr.dao.userdao;

import by.jrr.bean.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoCriteriaTest {

    UserDaoCriteria userDao;

    @BeforeEach
    public void setUp() {
        userDao = new UserDaoCriteria();
    }
    @Test
    void findAll() {
        List<User> users = userDao.findAll();
        assertTrue(users.size() > 0);
    }

    @Test
    void findById() {
        User user = userDao.findById(70L);
        assertEquals(70L, user.getId());
    }
}

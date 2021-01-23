package by.jrr.dao.userdao;

import by.jrr.bean.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoHqlTest {

    UserDaoHql userDao;

    @BeforeEach
    public void setUp() {
        userDao = new UserDaoHql();
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setUserName("another User Name");

        userDao.saveUser(user);
    }

    @Test
    void updateUser() {
        User user = new User(70L, "Updated");

        userDao.updateUser(user);
        User persistUser = userDao.findById(70L);
        assertEquals(user, persistUser);
    }

    @Test
    void findAll() {
        List<User> userList = userDao.findAll();
        assertTrue(userList.size() > 0);
    }

    @Test
    void findById() {
        Long id = 70L;
        User user = new User(70L, "some User Name");

        User persistUser = userDao.findById(id);
        assertEquals(user, persistUser);
    }

    @Test
    void deleteById() {
        Long id = 170L;
        userDao.deleteUser(id);
    }
}

package by.jrr.dao.userdao;

import by.jrr.bean.User;
import by.jrr.dao.HibernateEmUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoEmTest {

    /**Dao has been written with no closing sessions*/
    UserDaoEm userDaoEm;

    /** In before-after all queries exists in the same context, witch acquire connection resources,
     * but gives shared context advantages, like reusing em.persist() method
     */


    @BeforeAll
    public static void init() {
        HibernateEmUtil.getEntityManager();
    }

    @AfterAll
    public static void tearDown() {
        HibernateEmUtil.closeManager();
        HibernateEmUtil.closeFactory();
    }
    @BeforeEach
    public void setUp() {
        userDaoEm = new UserDaoEm();
    }

    @Test
    void saveUser() {
        User user = userDaoEm.saveUser(new User(null, "maxim"));
        assertTrue(user.getId() != null);
    }

    @Test //javax.persistence.PersistenceException:
        // org.hibernate.PersistentObjectException: detached entity passed to persist: by.jrr.bean.User
    void updateUser_save() {
        User user = userDaoEm.findById(69L);
        user.setUserName("updated33");
        userDaoEm.saveUser(user);
    }

    @Test
    void updateUser_merge() {
        User user = userDaoEm.findById(69L);
        user.setUserName("updated");
        userDaoEm.update(user);
    }

    @Test
    void findAll() {
        List<User> userList = userDaoEm.findAll();
        assertTrue(userList.size()>0);
    }

    @Test
    void findById() {
        User expectedUser = new User(120L, "maxim");
        User persistedUser = userDaoEm.findById(120L);
        assertEquals(expectedUser, persistedUser);
    }

    @Test
    void delete_badDemo() {
        User persistedUser = userDaoEm.findById(120L);
        assertNotNull(persistedUser);
        userDaoEm.delete_badDemo(persistedUser);
        assertNull(userDaoEm.findById(120L));
    }

    @Test
    void delete() {
        User persistedUser = userDaoEm.findById(120L);
        userDaoEm.delete(persistedUser);
        assertNull(userDaoEm.findById(120L));
    }
}

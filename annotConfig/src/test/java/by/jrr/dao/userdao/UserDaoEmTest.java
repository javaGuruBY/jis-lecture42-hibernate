package by.jrr.dao.userdao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoEmTest {

    UserDaoEm userDaoEm;

    @BeforeEach
    public void setUp() {
        userDaoEm = new UserDaoEm();
    }

    @Test
    void getEntityManager() {
        userDaoEm.getEntityManager();
    }
}

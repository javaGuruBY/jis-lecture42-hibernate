package by.jrr.dao;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class HibernateEmUtilTest {

    @Test
    void getEntityManager() {
        HibernateEmUtil.getEntityManager();
    }
}

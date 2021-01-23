package by.jrr.dao;

import by.jrr.bean.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.Oracle12cDialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class HibernateEmUtil {
//todo: tbd
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
//        if (entityManagerFactory == null) {
//            try {
//                entityManagerFactory =new HibernatePersistenceProvider()
//                        .createContainerEntityManagerFactory(archiverPersistenceUnitInfo(),ImmutableMap.
//
//                        <String, Object> builder() .
//
//                        put(JPA_JDBC_DRIVER, JDBC_DRIVER) .
//
//                        put(JPA_JDBC_URL, JDBC_URL) .
//
//                        put(DIALECT, Oracle12cDialect .class) .
//
//                        put(HBM2DDL_AUTO, CREATE) .
//
//                        put(SHOW_SQL, false) .
//
//                        put(QUERY_STARTUP_CHECKING, false) .
//
//                        put(GENERATE_STATISTICS, false) .
//
//                        put(USE_REFLECTION_OPTIMIZER, false) .
//
//                        put(USE_SECOND_LEVEL_CACHE, false) .
//
//                        put(USE_QUERY_CACHE, false) .
//
//                        put(USE_STRUCTURED_CACHE, false) .
//
//                        put(STATEMENT_BATCH_SIZE, 20) .
//
//                        build());entityManager =entityManagerFactory.createEntityManager();
//
//                Properties settings = loadProperties();
//
//                settings.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
//                settings.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//                settings.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
////                settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);
////                settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
////                settings.put(Environment.USE_QUERY_CACHE, true);
//
//                Configuration configuration = new Configuration();
//                configuration.setProperties(settings);
//
//                configuration.addAnnotatedClass(Human.class);
//                configuration.addAnnotatedClass(Student.class);
//                configuration.addAnnotatedClass(StudentPIIData.class);
//                configuration.addAnnotatedClass(Alumnus.class);
//                configuration.addAnnotatedClass(AlumnusPIIData.class);
//                configuration.addAnnotatedClass(Mentor.class);
//                configuration.addAnnotatedClass(MentorPIIData.class);
//                configuration.addAnnotatedClass(User.class);
//
//
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                        .applySettings(configuration.getProperties()).build();
//
//                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            } catch (Throwable ex) {
//                // Make sure you log the exception, as it might be swallowed
//                System.err.println("Initial SessionFactory creation failed." + ex);
//                throw new ExceptionInInitializerError(ex);
//            }
//        }
        return entityManagerFactory;
    }
}



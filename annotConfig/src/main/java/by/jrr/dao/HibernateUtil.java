package by.jrr.dao;

import by.jrr.bean.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Properties settings = loadProperties();

                settings.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);
                settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
                settings.put(Environment.USE_QUERY_CACHE, true);

                Configuration configuration = new Configuration();
                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Human.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Alumnus.class);
                configuration.addAnnotatedClass(Mentor.class);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }

            catch (Throwable ex) {
                // Make sure you log the exception, as it might be swallowed
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try(InputStream in = new FileInputStream("src/main/resources/jis4.properties")) {
            properties.load(in);
        } catch (Exception ex) {
            System.out.println("Cannot find properties");
            return null;
        }
        return properties;
    }
}

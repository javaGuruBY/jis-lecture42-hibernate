package by.jrr.dao;

import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.*;

import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;


public class HibernateEmUtil {
    //    https://stackoverflow.com/questions/1989672/create-jpa-entitymanager-without-persistence-xml-configuration-file
//todo: tbd
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void createEntityManagerFactory() {
        if (entityManagerFactory == null) {
            Map<String, Object> settings = new HashMap(loadProperties());
//            additional settings
            settings.put(SHOW_SQL, true);
//            settings.put(QUERY_STARTUP_CHECKING, false);
//            settings.put(GENERATE_STATISTICS, false);
//            settings.put(USE_REFLECTION_OPTIMIZER, false);
//            settings.put(USE_SECOND_LEVEL_CACHE, false);
//            settings.put(USE_QUERY_CACHE, false);
//            settings.put(USE_STRUCTURED_CACHE, false);
//            settings.put(STATEMENT_BATCH_SIZE, 20);

            entityManagerFactory = new HibernatePersistenceProvider()
                    .createContainerEntityManagerFactory(archiverPersistenceUnitInfo(), settings);
        }
    }

    public static EntityManager getEntityManager() {
        if(entityManagerFactory == null) {
            createEntityManagerFactory();
        }

        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public static void closeFactory() {
        entityManagerFactory.close();
    }

    public static void closeManager() {
        if (entityManager != null || entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public static void openManagerSession() {
        getEntityManager();
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream in = new FileInputStream("src/main/resources/jis4.properties")) {
            properties.load(in);
        } catch (Exception ex) {
            System.out.println("Cannot find properties");
            return null;
        }
        return properties;
    }

    private static PersistenceUnitInfo archiverPersistenceUnitInfo() {
        return new PersistenceUnitInfo() {
            @Override
            public String getPersistenceUnitName() {
                return "ApplicationPersistenceUnit";
            }

            @Override
            public String getPersistenceProviderClassName() {
                return "org.hibernate.jpa.HibernatePersistenceProvider";
            }

            @Override
            public PersistenceUnitTransactionType getTransactionType() {
                return PersistenceUnitTransactionType.RESOURCE_LOCAL;
            }

            @Override
            public DataSource getJtaDataSource() {
                return null;
            }

            @Override
            public DataSource getNonJtaDataSource() {
                return null;
            }

            @Override
            public List<String> getMappingFileNames() {
                return Collections.emptyList();
            }

            @Override
            public List<URL> getJarFileUrls() {
                try {
                    return Collections.list(this.getClass()
                            .getClassLoader()
                            .getResources(""));
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }

            @Override
            public URL getPersistenceUnitRootUrl() {
                return null;
            }

            @Override
            public List<String> getManagedClassNames() {
                return Collections.emptyList();
            }

            @Override
            public boolean excludeUnlistedClasses() {
                return false;
            }

            @Override
            public SharedCacheMode getSharedCacheMode() {
                return null;
            }

            @Override
            public ValidationMode getValidationMode() {
                return null;
            }

            @Override
            public Properties getProperties() {
                return new Properties();
            }

            @Override
            public String getPersistenceXMLSchemaVersion() {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }

            @Override
            public void addTransformer(ClassTransformer transformer) {

            }

            @Override
            public ClassLoader getNewTempClassLoader() {
                return null;
            }
        };
    }
}

//        persist – Make an instance managed and persistent.
//        merge – Merge the state of the given entity into the current persistence context.
//        remove – Remove the entity instance.
//        find – Find by primary key. Search for an entity of the specified class and primary key. If the entity instance is contained in the persistence context, it is returned from there.
//        getReference – returns and instance which is lazily fetched and will throw EntityNotFoundException when the instance is accessed for the first time.
//        flush – Synchronizes the persistence context with the database.
//        setFlushMode – set the flush mode for all the objects of the persistence context.
//        getFlushMode – get the flush mode for all the objects of the persistence context.
//        lock – Lock an entity instance that is contained in the persistence context with the specified lock mode type.
//        refresh – it refreshes the state of the instance from the database also it will overwrite the changes to the entity.
//        clear – Clear the persistence context, causing all managed entities to become detached. Changes made to entities that have not been flushed to the database will not be persisted.
//        detach – this is similar to the clear method, only addition is the entity which previously referenced the detached object will continue to do so.
//        contains – it checks if the managed entity belongs to the current persistence context.
//        getLockMode – get the current lock mode for entity instance.
//        setProperty – set an entity manager property or hint.
//        getProperties – get the properties and hints associated with the entity manager.
//        createQuery – Create an instance of Query for executing a Java Persistence query language statement.
//        createNamedQuery – Create an instance of Query for executing a Java Persistence named query language statement.
//        createNativeQuery – Create an instance of Query for executing a native sql statement.
//        createNamedStoredProcedureQuery – Create an instance of StoredProcedureQuery for executing a stored procedure in the database.
//        createStoredProcedureQuery – Create an instance of StoredProcedureQuery for executing a stored procedure in the database.
//        joinTransaction – Indicate to the entity manager that a JTA transaction is active. This method should be called on a JTA application managed entity manager that was created outside the scope of the active transaction to associate it with the current JTA transaction.
//        isJoinedToTransaction – it determines if the entityManager is linked to the current transaction.
//        unwrap – Return an object of the specified type to allow access to the provider-specific API
//        getDelegate – return the provider object for the entityManager.
//        close – close an application-managed entityManager.
//        isOpen – determine if the entityManager is open.
//        getTransaction – Return the resource-level EntityTransaction object.
//        getEntityManagerFactory – provides the entity manager factory for the entity manager.
//        getCriteriaBuilder – Return an instance of CriteriaBuilder for the creation of CriteriaQuery objects.
//        getMetamodel – Return an instance of Metamodel interface for access to the metamodel of the persistence unit.
//        createEntityGraph – Return a mutable EntityGraph that can be used to dynamically create an EntityGraph.
//        getEntityGraph – returns a named entityGraph

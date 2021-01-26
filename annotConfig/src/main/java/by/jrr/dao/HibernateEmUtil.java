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
                    .createContainerEntityManagerFactory(archiverPersistenceUnitInfo(),settings);
        }
    }

    public static EntityManager getEntityManager() {
         if(entityManagerFactory == null) {
            createEntityManagerFactory();
        }
        return entityManagerFactory.createEntityManager();
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


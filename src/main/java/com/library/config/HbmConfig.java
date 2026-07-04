package com.library.config;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Member;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HbmConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){

            Configuration configuration = getConfiguration();

            //Step 1: Add Entity Class
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Member.class);
            configuration.addAnnotatedClass(Author.class);

            //Step 2 : Create ServiceRegistry
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            // Step 3: Create SessionFactory
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();

        // Database Configuration
        properties.setProperty(AvailableSettings.JAKARTA_JDBC_URL,"jdbc:mysql://localhost:3306/library_db");
        properties.setProperty(AvailableSettings.JAKARTA_JDBC_USER,"root");
        properties.setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD,"meyyappan7");
        properties.setProperty(AvailableSettings.JAKARTA_JDBC_DRIVER,"com.mysql.cj.jdbc.Driver");

        properties.setProperty(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQLDialect");

        properties.setProperty(AvailableSettings.HBM2DDL_AUTO,"update");

        configuration.setProperties(properties);
        return configuration;
    }

    public static void closeSessionFactory() {
        if(sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

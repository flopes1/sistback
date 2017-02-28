package com.ssl.dao.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages =
    { "com.ssl.dao.imp" })
public class DataBaseConfiguration
{
    private static final Log log = LogFactory.getLog(DataBaseConfiguration.class);
    // private static DataBaseConfiguration instance = null;
    // private static String configURL = "";

    // XML based configuration
    private SessionFactory sessionFactory;

    // // Annotation based configuration
    // private static SessionFactory sessionAnnotationFactory;
    //
    // // Property based configuration
    // private static SessionFactory sessionJavaConfigFactory;

    // private DataBaseConfiguration()
    // {
    // this.loadConfigFile();
    // }

    // public static DataBaseConfiguration getInstance()
    // {
    // if(instance == null)
    // {
    // instance = new DataBaseConfiguration();
    // }
    // return instance;
    // }
    @Autowired
    @Bean(name = "sessionFactory")
    private SessionFactory getSessionFactory()
    {
        try
        {
            // Create the SessionFactory from hibernate.cfg.xml
            log.debug("Trying to read hibernate.ctg file");

            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

            String configURL = this.getClass().getClassLoader().getResource("hibernate.cfg.xml").toString();
            configuration.configure(configURL);
            // System.out.println("Hibernate Configuration loaded");

            log.debug("Hibernate Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            // System.out.println("Hibernate serviceRegistry created");
            log.debug("Hibernate serviceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch (Throwable ex)
        {
            // Make sure you log the exception, as it might be swallowed
            log.debug("Initial SessionFactory creation failed." + ex.getMessage());
            // System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager()
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(getSessionFactory());

        return transactionManager;
    }

    // private void loadConfigFile()
    // {
    // configURL = this.getClass().getClassLoader().getResource("hibernate.cfg.xml").toString();
    // }

    // public SessionFactory getSessionFactory()
    // {
    // if (sessionFactory == null)
    // {
    // sessionFactory = buildSessionFactory();
    // }
    // return sessionFactory;
    // }\

    // private static SessionFactory buildSessionAnnotationFactory()
    // {
    // try
    // {
    // // Create the SessionFactory from hibernate.cfg.xml
    // Configuration configuration = new Configuration();
    // configuration.configure("hibernate-annotation.cfg.xml");
    // System.out.println("Hibernate Annotation Configuration loaded");
    //
    // ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
    // .applySettings(configuration.getProperties()).build();
    // System.out.println("Hibernate Annotation serviceRegistry created");
    //
    // SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    //
    // return sessionFactory;
    // }
    // catch (Throwable ex)
    // {
    // // Make sure you log the exception, as it might be swallowed
    // System.err.println("Initial SessionFactory creation failed." + ex);
    // throw new ExceptionInInitializerError(ex);
    // }
    // }
    //
    // private static SessionFactory buildSessionJavaConfigFactory()
    // {
    // try
    // {
    // Configuration configuration = new Configuration();
    //
    // // Create Properties, can be read from property files too
    // Properties props = new Properties();
    // props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
    // props.put("hibernate.connection.url", "jdbc:mysql://localhost/TestDB");
    // props.put("hibernate.connection.username", "pankaj");
    // props.put("hibernate.connection.password", "pankaj123");
    // props.put("hibernate.current_session_context_class", "thread");
    //
    // configuration.setProperties(props);
    //
    // // we can set mapping file or class with annotation
    // // addClass(Employee1.class) will look for resource
    // // com/journaldev/hibernate/model/Employee1.hbm.xml (not good)
    // configuration.addAnnotatedClass(Employee1.class);
    //
    // ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
    // .applySettings(configuration.getProperties()).build();
    // System.out.println("Hibernate Java Config serviceRegistry created");
    //
    // SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    //
    // return sessionFactory;
    // }
    // catch (Throwable ex)
    // {
    // System.err.println("Initial SessionFactory creation failed." + ex);
    // throw new ExceptionInInitializerError(ex);
    // }
    // }

    // public static SessionFactory getSessionAnnotationFactory()
    // {
    // if (sessionAnnotationFactory == null)
    // sessionAnnotationFactory = buildSessionAnnotationFactory();
    // return sessionAnnotationFactory;
    // }
    //
    // public static SessionFactory getSessionJavaConfigFactory()
    // {
    // if (sessionJavaConfigFactory == null)
    // sessionJavaConfigFactory = buildSessionJavaConfigFactory();
    // return sessionJavaConfigFactory;
    // }
}

package com.ssl.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sist.ssl.loader.SslPropertiesLoader;
import com.sist.ssl.loader.SslSetupConstants;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages =
    { "com.ssl.database", "com.ssl.entities"})
public class HibernateConfig
{

    private static SslPropertiesLoader propertiesLoader = SslPropertiesLoader.getInstance();

    /**
     * Initialize dataSource
     * 
     * @return DataSource
     */
    @Bean
    public DataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(propertiesLoader.getPropertyByName(SslSetupConstants.DATA_BASE_DRIVER));
        dataSource.setUrl(propertiesLoader.getPropertyByName(SslSetupConstants.DATA_BASE_URL));
        dataSource.setUsername(propertiesLoader.getPropertyByName(SslSetupConstants.DATA_BASE_USERNAME));
        dataSource.setPassword(propertiesLoader.getPropertyByName(SslSetupConstants.DATA_BASE_PASSWORD));
        dataSource.setSchema(propertiesLoader.getPropertyByName(SslSetupConstants.DATA_BASE_SCHEMA));
        return dataSource;
    }

    /**
     * Initialize hibernate properties
     * 
     * @return Properties
     */
    private Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put(AvailableSettings.DIALECT,
                propertiesLoader.getPropertyByName(SslSetupConstants.HIBERNATE_DIALECT));
        properties.put(AvailableSettings.SHOW_SQL,
                propertiesLoader.getPropertyByName(SslSetupConstants.HIBERNATE_SHOW_SQL));
        properties.put(AvailableSettings.FORMAT_SQL,
                propertiesLoader.getPropertyByName(SslSetupConstants.HIBERNATE_FORMAT_SQL));
        properties.put(AvailableSettings.STATEMENT_BATCH_SIZE,
                propertiesLoader.getPropertyByName(SslSetupConstants.HIBERNATE_BATCH_SIZE));
        properties.put(AvailableSettings.HBM2DDL_AUTO,
                propertiesLoader.getPropertyByName(SslSetupConstants.HIBERNATE_HBM2DDL_VALIDATE));
        properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS,
                propertiesLoader.getPropertyByName(SslSetupConstants.HIBERNATE_CURRENT_SESSION_CONTEXT_CLASS));
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory()
    {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(new String[]
            { "com.ssl.database.impl", "com.ssl.entities" });
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    /**
     * Initialize Transaction Manager
     * 
     * @param sessionFactory
     * @return HibernateTransactionManager
     */
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}
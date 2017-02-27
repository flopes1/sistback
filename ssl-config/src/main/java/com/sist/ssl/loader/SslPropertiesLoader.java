package com.sist.ssl.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SslPropertiesLoader
{

    private Properties sslProperties;
    private static SslPropertiesLoader instance;
    private static Logger log = LoggerFactory.getLogger(SslPropertiesLoader.class);

    private SslPropertiesLoader()
    {
        this.loadSslProperties();
    }

    public static SslPropertiesLoader getInstance()
    {
        if (instance == null)
        {
            instance = new SslPropertiesLoader();
        }
        return instance;
    }

    public Properties loadSslProperties()
    {
        try
        {
            InputStream globalPropertiesStream = this.getClass().getClassLoader().getResourceAsStream("ssl.properties");
            sslProperties = new Properties();
            sslProperties.load(globalPropertiesStream);

            return sslProperties;
        }
        catch (IOException e)
        {
            log.debug("Failed to load ssl.properties file", e.getMessage());
            throw new RuntimeException("Failed to load ssl.properties file", e);
        }
    }

    public String getPropertyByName(String name)
    {
        return this.sslProperties.getProperty(name);
    }

}

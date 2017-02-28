package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ssl.entities.PhoneNumberCondominium;

/**
 * Home object for domain model class PhoneNumberCondominium.
 * @see com.ssl.dao.imp.PhoneNumberCondominium
 * @author Hibernate Tools
 */
public class PhoneNumberCondominiumHome
{

    private static final Log log = LogFactory.getLog(PhoneNumberCondominiumHome.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory()
    {
        try
        {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e)
        {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(PhoneNumberCondominium transientInstance)
    {
        log.debug("persisting PhoneNumberCondominium instance");
        try
        {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re)
        {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(PhoneNumberCondominium instance)
    {
        log.debug("attaching dirty PhoneNumberCondominium instance");
        try
        {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re)
        {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(PhoneNumberCondominium instance)
    {
        log.debug("attaching clean PhoneNumberCondominium instance");
        try
        {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re)
        {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(PhoneNumberCondominium persistentInstance)
    {
        log.debug("deleting PhoneNumberCondominium instance");
        try
        {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re)
        {
            log.error("delete failed", re);
            throw re;
        }
    }

    public PhoneNumberCondominium merge(PhoneNumberCondominium detachedInstance)
    {
        log.debug("merging PhoneNumberCondominium instance");
        try
        {
            PhoneNumberCondominium result = (PhoneNumberCondominium) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public PhoneNumberCondominium findById(int id)
    {
        log.debug("getting PhoneNumberCondominium instance with id: " + id);
        try
        {
            PhoneNumberCondominium instance = (PhoneNumberCondominium) sessionFactory.getCurrentSession()
                    .get("com.ssl.dao.imp.PhoneNumberCondominium", id);
            if (instance == null)
            {
                log.debug("get successful, no instance found");
            }
            else
            {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re)
        {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<PhoneNumberCondominium> findByExample(PhoneNumberCondominium instance)
    {
        log.debug("finding PhoneNumberCondominium instance by example");
        try
        {
            List<PhoneNumberCondominium> results = (List<PhoneNumberCondominium>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.PhoneNumberCondominium").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re)
        {
            log.error("find by example failed", re);
            throw re;
        }
    }
}

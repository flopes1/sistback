package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ssl.entities.PhoneNumberUserr;

/**
 * Home object for domain model class PhoneNumberUserr.
 * @see com.ssl.dao.imp.PhoneNumberUserr
 * @author Hibernate Tools
 */
public class PhoneNumberUserrHome
{

    private static final Log log = LogFactory.getLog(PhoneNumberUserrHome.class);

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

    public void persist(PhoneNumberUserr transientInstance)
    {
        log.debug("persisting PhoneNumberUserr instance");
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

    public void attachDirty(PhoneNumberUserr instance)
    {
        log.debug("attaching dirty PhoneNumberUserr instance");
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

    public void attachClean(PhoneNumberUserr instance)
    {
        log.debug("attaching clean PhoneNumberUserr instance");
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

    public void delete(PhoneNumberUserr persistentInstance)
    {
        log.debug("deleting PhoneNumberUserr instance");
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

    public PhoneNumberUserr merge(PhoneNumberUserr detachedInstance)
    {
        log.debug("merging PhoneNumberUserr instance");
        try
        {
            PhoneNumberUserr result = (PhoneNumberUserr) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public PhoneNumberUserr findById(int id)
    {
        log.debug("getting PhoneNumberUserr instance with id: " + id);
        try
        {
            PhoneNumberUserr instance = (PhoneNumberUserr) sessionFactory.getCurrentSession()
                    .get("com.ssl.dao.imp.PhoneNumberUserr", id);
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

    public List<PhoneNumberUserr> findByExample(PhoneNumberUserr instance)
    {
        log.debug("finding PhoneNumberUserr instance by example");
        try
        {
            List<PhoneNumberUserr> results = (List<PhoneNumberUserr>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.PhoneNumberUserr").add(create(instance)).list();
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

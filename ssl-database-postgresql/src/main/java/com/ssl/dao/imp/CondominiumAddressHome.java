package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ssl.entities.CondominiumAddress;

/**
 * Home object for domain model class CondominiumAddress.
 * @see com.ssl.dao.imp.CondominiumAddress
 * @author Hibernate Tools
 */
public class CondominiumAddressHome
{

    private static final Log log = LogFactory.getLog(CondominiumAddressHome.class);

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

    public void persist(CondominiumAddress transientInstance)
    {
        log.debug("persisting CondominiumAddress instance");
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

    public void attachDirty(CondominiumAddress instance)
    {
        log.debug("attaching dirty CondominiumAddress instance");
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

    public void attachClean(CondominiumAddress instance)
    {
        log.debug("attaching clean CondominiumAddress instance");
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

    public void delete(CondominiumAddress persistentInstance)
    {
        log.debug("deleting CondominiumAddress instance");
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

    public CondominiumAddress merge(CondominiumAddress detachedInstance)
    {
        log.debug("merging CondominiumAddress instance");
        try
        {
            CondominiumAddress result = (CondominiumAddress) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public CondominiumAddress findById(int id)
    {
        log.debug("getting CondominiumAddress instance with id: " + id);
        try
        {
            CondominiumAddress instance = (CondominiumAddress) sessionFactory.getCurrentSession()
                    .get("com.ssl.dao.imp.CondominiumAddress", id);
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

    public List<CondominiumAddress> findByExample(CondominiumAddress instance)
    {
        log.debug("finding CondominiumAddress instance by example");
        try
        {
            List<CondominiumAddress> results = (List<CondominiumAddress>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.CondominiumAddress").add(create(instance)).list();
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

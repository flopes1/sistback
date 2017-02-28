package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ssl.entities.ScheduledVisit;

/**
 * Home object for domain model class ScheduledVisit.
 * @see com.ssl.dao.imp.ScheduledVisit
 * @author Hibernate Tools
 */
public class ScheduledVisitHome
{

    private static final Log log = LogFactory.getLog(ScheduledVisitHome.class);

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

    public void persist(ScheduledVisit transientInstance)
    {
        log.debug("persisting ScheduledVisit instance");
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

    public void attachDirty(ScheduledVisit instance)
    {
        log.debug("attaching dirty ScheduledVisit instance");
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

    public void attachClean(ScheduledVisit instance)
    {
        log.debug("attaching clean ScheduledVisit instance");
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

    public void delete(ScheduledVisit persistentInstance)
    {
        log.debug("deleting ScheduledVisit instance");
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

    public ScheduledVisit merge(ScheduledVisit detachedInstance)
    {
        log.debug("merging ScheduledVisit instance");
        try
        {
            ScheduledVisit result = (ScheduledVisit) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public ScheduledVisit findById(int id)
    {
        log.debug("getting ScheduledVisit instance with id: " + id);
        try
        {
            ScheduledVisit instance = (ScheduledVisit) sessionFactory.getCurrentSession()
                    .get("com.ssl.dao.imp.ScheduledVisit", id);
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

    public List<ScheduledVisit> findByExample(ScheduledVisit instance)
    {
        log.debug("finding ScheduledVisit instance by example");
        try
        {
            List<ScheduledVisit> results = (List<ScheduledVisit>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.ScheduledVisit").add(create(instance)).list();
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

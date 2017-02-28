package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ssl.entities.AutenticationHistory;

/**
 * Home object for domain model class AutenticationHistory.
 * @see com.ssl.dao.imp.AutenticationHistory
 * @author Hibernate Tools
 */
public class AutenticationHistoryHome
{

    private static final Log log = LogFactory.getLog(AutenticationHistoryHome.class);

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

    public void persist(AutenticationHistory transientInstance)
    {
        log.debug("persisting AutenticationHistory instance");
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

    public void attachDirty(AutenticationHistory instance)
    {
        log.debug("attaching dirty AutenticationHistory instance");
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

    public void attachClean(AutenticationHistory instance)
    {
        log.debug("attaching clean AutenticationHistory instance");
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

    public void delete(AutenticationHistory persistentInstance)
    {
        log.debug("deleting AutenticationHistory instance");
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

    public AutenticationHistory merge(AutenticationHistory detachedInstance)
    {
        log.debug("merging AutenticationHistory instance");
        try
        {
            AutenticationHistory result = (AutenticationHistory) sessionFactory.getCurrentSession()
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

    public AutenticationHistory findById(int id)
    {
        log.debug("getting AutenticationHistory instance with id: " + id);
        try
        {
            AutenticationHistory instance = (AutenticationHistory) sessionFactory.getCurrentSession()
                    .get("com.ssl.dao.imp.AutenticationHistory", id);
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

    public List<AutenticationHistory> findByExample(AutenticationHistory instance)
    {
        log.debug("finding AutenticationHistory instance by example");
        try
        {
            List<AutenticationHistory> results = (List<AutenticationHistory>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.AutenticationHistory").add(create(instance)).list();
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

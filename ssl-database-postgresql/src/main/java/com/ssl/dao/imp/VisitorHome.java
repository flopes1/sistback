package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ssl.entities.Visitor;

/**
 * Home object for domain model class Visitor.
 * @see com.ssl.dao.imp.Visitor
 * @author Hibernate Tools
 */
public class VisitorHome
{

    private static final Log log = LogFactory.getLog(VisitorHome.class);

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

    public void persist(Visitor transientInstance)
    {
        log.debug("persisting Visitor instance");
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

    public void attachDirty(Visitor instance)
    {
        log.debug("attaching dirty Visitor instance");
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

    public void attachClean(Visitor instance)
    {
        log.debug("attaching clean Visitor instance");
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

    public void delete(Visitor persistentInstance)
    {
        log.debug("deleting Visitor instance");
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

    public Visitor merge(Visitor detachedInstance)
    {
        log.debug("merging Visitor instance");
        try
        {
            Visitor result = (Visitor) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public Visitor findById(int id)
    {
        log.debug("getting Visitor instance with id: " + id);
        try
        {
            Visitor instance = (Visitor) sessionFactory.getCurrentSession().get("com.ssl.dao.imp.Visitor", id);
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

    public List<Visitor> findByExample(Visitor instance)
    {
        log.debug("finding Visitor instance by example");
        try
        {
            List<Visitor> results = (List<Visitor>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.Visitor").add(create(instance)).list();
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

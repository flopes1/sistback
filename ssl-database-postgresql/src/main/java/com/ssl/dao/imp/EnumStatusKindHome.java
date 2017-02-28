package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ssl.entities.EnumStatusKind;

/**
 * Home object for domain model class EnumStatusKind.
 * @see com.ssl.dao.imp.EnumStatusKind
 * @author Hibernate Tools
 */
public class EnumStatusKindHome
{

    private static final Log log = LogFactory.getLog(EnumStatusKindHome.class);

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

    public void persist(EnumStatusKind transientInstance)
    {
        log.debug("persisting EnumStatusKind instance");
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

    public void attachDirty(EnumStatusKind instance)
    {
        log.debug("attaching dirty EnumStatusKind instance");
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

    public void attachClean(EnumStatusKind instance)
    {
        log.debug("attaching clean EnumStatusKind instance");
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

    public void delete(EnumStatusKind persistentInstance)
    {
        log.debug("deleting EnumStatusKind instance");
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

    public EnumStatusKind merge(EnumStatusKind detachedInstance)
    {
        log.debug("merging EnumStatusKind instance");
        try
        {
            EnumStatusKind result = (EnumStatusKind) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public EnumStatusKind findById(int id)
    {
        log.debug("getting EnumStatusKind instance with id: " + id);
        try
        {
            EnumStatusKind instance = (EnumStatusKind) sessionFactory.getCurrentSession()
                    .get("com.ssl.dao.imp.EnumStatusKind", id);
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

    public List<EnumStatusKind> findByExample(EnumStatusKind instance)
    {
        log.debug("finding EnumStatusKind instance by example");
        try
        {
            List<EnumStatusKind> results = (List<EnumStatusKind>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.EnumStatusKind").add(create(instance)).list();
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

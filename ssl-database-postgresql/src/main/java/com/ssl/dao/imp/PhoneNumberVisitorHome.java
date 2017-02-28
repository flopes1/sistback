package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ssl.entities.PhoneNumberVisitor;

/**
 * Home object for domain model class PhoneNumberVisitor.
 * @see com.ssl.dao.imp.PhoneNumberVisitor
 * @author Hibernate Tools
 */
public class PhoneNumberVisitorHome
{

    private static final Log log = LogFactory.getLog(PhoneNumberVisitorHome.class);

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

    public void persist(PhoneNumberVisitor transientInstance)
    {
        log.debug("persisting PhoneNumberVisitor instance");
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

    public void attachDirty(PhoneNumberVisitor instance)
    {
        log.debug("attaching dirty PhoneNumberVisitor instance");
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

    public void attachClean(PhoneNumberVisitor instance)
    {
        log.debug("attaching clean PhoneNumberVisitor instance");
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

    public void delete(PhoneNumberVisitor persistentInstance)
    {
        log.debug("deleting PhoneNumberVisitor instance");
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

    public PhoneNumberVisitor merge(PhoneNumberVisitor detachedInstance)
    {
        log.debug("merging PhoneNumberVisitor instance");
        try
        {
            PhoneNumberVisitor result = (PhoneNumberVisitor) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public PhoneNumberVisitor findById(int id)
    {
        log.debug("getting PhoneNumberVisitor instance with id: " + id);
        try
        {
            PhoneNumberVisitor instance = (PhoneNumberVisitor) sessionFactory.getCurrentSession()
                    .get("com.ssl.dao.imp.PhoneNumberVisitor", id);
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

    public List<PhoneNumberVisitor> findByExample(PhoneNumberVisitor instance)
    {
        log.debug("finding PhoneNumberVisitor instance by example");
        try
        {
            List<PhoneNumberVisitor> results = (List<PhoneNumberVisitor>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.PhoneNumberVisitor").add(create(instance)).list();
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

package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ssl.entities.PhoneNumberEmployee;

/**
 * Home object for domain model class PhoneNumberEmployee.
 * @see com.ssl.dao.imp.PhoneNumberEmployee
 * @author Hibernate Tools
 */
public class PhoneNumberEmployeeHome
{

    private static final Log log = LogFactory.getLog(PhoneNumberEmployeeHome.class);

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

    public void persist(PhoneNumberEmployee transientInstance)
    {
        log.debug("persisting PhoneNumberEmployee instance");
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

    public void attachDirty(PhoneNumberEmployee instance)
    {
        log.debug("attaching dirty PhoneNumberEmployee instance");
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

    public void attachClean(PhoneNumberEmployee instance)
    {
        log.debug("attaching clean PhoneNumberEmployee instance");
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

    public void delete(PhoneNumberEmployee persistentInstance)
    {
        log.debug("deleting PhoneNumberEmployee instance");
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

    public PhoneNumberEmployee merge(PhoneNumberEmployee detachedInstance)
    {
        log.debug("merging PhoneNumberEmployee instance");
        try
        {
            PhoneNumberEmployee result = (PhoneNumberEmployee) sessionFactory.getCurrentSession()
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

    public PhoneNumberEmployee findById(int id)
    {
        log.debug("getting PhoneNumberEmployee instance with id: " + id);
        try
        {
            PhoneNumberEmployee instance = (PhoneNumberEmployee) sessionFactory.getCurrentSession()
                    .get("com.ssl.dao.imp.PhoneNumberEmployee", id);
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

    public List<PhoneNumberEmployee> findByExample(PhoneNumberEmployee instance)
    {
        log.debug("finding PhoneNumberEmployee instance by example");
        try
        {
            List<PhoneNumberEmployee> results = (List<PhoneNumberEmployee>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.PhoneNumberEmployee").add(create(instance)).list();
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

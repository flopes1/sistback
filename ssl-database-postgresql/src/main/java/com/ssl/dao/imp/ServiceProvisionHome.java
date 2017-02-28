package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ssl.entities.ServiceProvision;

/**
 * Home object for domain model class ServiceProvision.
 * @see com.ssl.dao.imp.ServiceProvision
 * @author Hibernate Tools
 */
public class ServiceProvisionHome
{

    private static final Log log = LogFactory.getLog(ServiceProvisionHome.class);

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

    public void persist(ServiceProvision transientInstance)
    {
        log.debug("persisting ServiceProvision instance");
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

    public void attachDirty(ServiceProvision instance)
    {
        log.debug("attaching dirty ServiceProvision instance");
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

    public void attachClean(ServiceProvision instance)
    {
        log.debug("attaching clean ServiceProvision instance");
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

    public void delete(ServiceProvision persistentInstance)
    {
        log.debug("deleting ServiceProvision instance");
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

    public ServiceProvision merge(ServiceProvision detachedInstance)
    {
        log.debug("merging ServiceProvision instance");
        try
        {
            ServiceProvision result = (ServiceProvision) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public ServiceProvision findById(int id)
    {
        log.debug("getting ServiceProvision instance with id: " + id);
        try
        {
            ServiceProvision instance = (ServiceProvision) sessionFactory.getCurrentSession()
                    .get("com.ssl.dao.imp.ServiceProvision", id);
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

    public List<ServiceProvision> findByExample(ServiceProvision instance)
    {
        log.debug("finding ServiceProvision instance by example");
        try
        {
            List<ServiceProvision> results = (List<ServiceProvision>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.ServiceProvision").add(create(instance)).list();
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

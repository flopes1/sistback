package com.ssl.dao.imp;
// Generated 28/02/2017 11:14:07 by Hibernate Tools 5.2.1.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.ssl.entities.Condominium;

/**
 * Home object for domain model class Condominium.
 * 
 * @see com.ssl.dao.imp.Condominium
 * @author Hibernate Tools
 */
@Component
@Transactional(propagation = Propagation.MANDATORY)
public class CondominiumHome
{

    private static final Log log = LogFactory.getLog(CondominiumHome.class);

    // private final SessionFactory sessionFactory = getSessionFactory();
    @Autowired
    private SessionFactory sessionFactory;

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

    @Transactional
    public void persist(Condominium transientInstance)
    {
        log.debug("persisting Condominium instance");
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

    public void attachDirty(Condominium instance)
    {
        log.debug("attaching dirty Condominium instance");
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

    public void attachClean(Condominium instance)
    {
        log.debug("attaching clean Condominium instance");
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

    public void delete(Condominium persistentInstance)
    {
        log.debug("deleting Condominium instance");
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

    public Condominium merge(Condominium detachedInstance)
    {
        log.debug("merging Condominium instance");
        try
        {
            Condominium result = (Condominium) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re)
        {
            log.error("merge failed", re);
            throw re;
        }
    }

    public Condominium findById(int id)
    {
        log.debug("getting Condominium instance with id: " + id);
        try
        {
            Condominium instance = (Condominium) sessionFactory.getCurrentSession().get("com.ssl.dao.imp.Condominium",
                    id);
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

    public List<Condominium> findByExample(Condominium instance)
    {
        log.debug("finding Condominium instance by example");
        try
        {
            List<Condominium> results = (List<Condominium>) sessionFactory.getCurrentSession()
                    .createCriteria("com.ssl.dao.imp.Condominium").add(create(instance)).list();
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

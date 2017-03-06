package com.ssl.database.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.database.ICondominiumDao;
import com.ssl.entities.Condominium;

@Component
@Repository
public class CondominiumDao implements ICondominiumDao
{

    private static final Log log = LogFactory.getLog(CondominiumDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession()
    {
        log.debug("Getting current session of data base");
        Session session = null;
        try
        {
            session = this.sessionFactory.getCurrentSession();
            log.error("Getting current session successful");
        }
        catch (RuntimeException e)
        {
            log.error("Getting current session failed", e);
            throw e;
        }
        return session;
    }

    @Transactional // TODO move-me to service layer
    @Override
    public void addCondominium(Condominium condominium)
    {
        log.debug("Persisting Condominium: " + condominium.getName() + " instance");
        try
        {
            this.getCurrentSession().persist(condominium);
            log.debug("Persisting Condominium successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Persisting Condominium: " + condominium.getName() + "failed", e);
            throw e;
        }
    }

    @Override
    public void removeCondominium(Condominium condominium)
    {
        log.debug("Removing Condominium: " + condominium.getName());
        try
        {
            condominium.setActive(false);
            this.updateCondominium(condominium);
            log.debug("Removing Condominium successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Removing Condominium: " + condominium.getName() + "failed", e);
            throw e;
        }
    }

    @Override
    public void removeCondominiumById(int condominiumId)
    {
        log.debug("Removing Condominium with id: " + condominiumId);
        try
        {
            Condominium condominium = this.getCondominiumById(condominiumId);
            if (condominium != null)
            {
                condominium.setActive(false);
                this.updateCondominium(condominium);
                log.debug("Removing Condominium successful ");
            }
        }
        catch (RuntimeException e)
        {
            log.error("Removing Condominium with id: " + condominiumId + "failed", e);
            throw e;
        }

    }

    @Override
    public Condominium updateCondominium(Condominium condominium)
    {

        log.debug("Updating Condominium with id: " + condominium.getId());

        Condominium newCond = null;

        try
        {
            newCond = (Condominium) this.getCurrentSession().merge(condominium);
            log.debug("Updating Condominium successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Updating Condominium with id: " + condominium.getId() + "failed", e);
            throw e;
        }
        return newCond;
    }

    @Override
    public Condominium getCondominiumById(int id)
    {
        log.debug("Getting Condominium with id: " + id);

        Condominium cond = null;

        try
        {
            cond = this.getCurrentSession().get(Condominium.class, id);
            log.debug("Getting Condominium successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Getting Condominium with id: " + id + "failed", e);
            throw e;
        }
        return cond;
    }

    @Override
    public Condominium getCondominiumByName(String name)
    {
        log.debug("Getting Condominium with name: " + name);

        Condominium cond = null;

        try
        {
            CriteriaBuilder cBuilder = this.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Condominium> criteria = cBuilder.createQuery(Condominium.class);

            criteria.select(criteria.from(Condominium.class))
                    .where(cBuilder.equal(criteria.from(Condominium.class).get("name"), name));

            cond = this.getCurrentSession().createQuery(criteria).getSingleResult();

            log.debug("Getting Condominium successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Getting Condominium with name: " + name + "failed", e);
            throw e;
        }
        return cond;

    }

    @Override
    public List<Condominium> getAllCondominiums()
    {
        log.debug("Getting all condominiums");

        List<Condominium> allCond = null;

        try
        {
            CriteriaBuilder cBuilder = this.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Condominium> criteria = cBuilder.createQuery(Condominium.class);

            criteria.select(criteria.from(Condominium.class));

            allCond = this.getCurrentSession().createQuery(criteria).getResultList();
        }
        catch (RuntimeException e)
        {
            log.error("Getting all Condominium failed", e);
            throw e;
        }

        return allCond;
    }

}

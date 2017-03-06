package com.ssl.database.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.ICondominiumAdressDao;
import com.ssl.entities.CondominiumAddress;

@Component
@Repository
public class CondominiumAdressDao implements ICondominiumAdressDao
{
    private static final Log log = LogFactory.getLog(CondominiumAdressDao.class);

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

    @Override
    public void addCondominiumAddress(CondominiumAddress address)
    {
        log.debug("Persisting Condominium Address instance");
        try
        {
            this.getCurrentSession().persist(address);
            log.debug("Persisting Condominium Address successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Persisting Condominium Address", e);
            throw e;
        }
    }

    @Override
    public CondominiumAddress getCondominiumAddressById(int id)
    {
        log.debug("Getting Condominium address with id: " + id);

        CondominiumAddress address = null;

        try
        {
            address = this.getCurrentSession().get(CondominiumAddress.class, id);
            log.debug("Getting Condominium address successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Getting Condominium address with id: " + id + "failed", e);
            throw e;
        }
        return address;
    }

    @Override
    public CondominiumAddress getCondominiumAddressByCondominiumId(int CondId)
    {
        log.debug("Getting Condominium address with condominium id: " + CondId);

        CondominiumAddress address = null;

        try
        {
            CriteriaBuilder cBuilder = this.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<CondominiumAddress> criteria = cBuilder.createQuery(CondominiumAddress.class);

            criteria.where(cBuilder.equal(criteria.from(CondominiumAddress.class).get("condominium"), CondId));

            address = this.getCurrentSession().createQuery(criteria).getSingleResult();
            log.debug("Getting Condominium address successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Getting Condominium address with condominium id: " + CondId + "failed", e);
            throw e;
        }
        return address;

    }

    @Override
    public CondominiumAddress updateCondominiumAddress(CondominiumAddress address)
    {
        log.debug("Updating Condominium address with id: " + address.getId());

        CondominiumAddress newCondAdress = null;

        try
        {
            newCondAdress = (CondominiumAddress) this.getCurrentSession().merge(address);
            log.debug("Updating Condominium address successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Updating Condominium address with id: " + address.getId() + "failed", e);
            throw e;
        }
        return newCondAdress;
    }

    @Override
    public void removeCondominiumAddress(CondominiumAddress address)
    {
        log.debug("Removing Condominium address: " + address.getId());
        try
        {
            this.getCurrentSession().delete(address);
            log.debug("Removing Condominium address successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Removing Condominium address: " + address.getId() + "failed", e);
            throw e;
        }
    }

    @Override
    public void removeCondominiumAddressById(int id)
    {
        log.debug("Removing Condominium address: " + id);
        try
        {
            CondominiumAddress address = this.getCondominiumAddressById(id);
            this.getCurrentSession().delete(address);
            log.debug("Removing Condominium address successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Removing Condominium address: " + id + "failed", e);
            throw e;
        }
    }

    @Override
    public void removeCondominiumAddressByCondominiumId(int id)
    {
        log.debug("Removing Condominium address with condominium id: " + id);
        try
        {
            CriteriaBuilder cBuilder = this.getCurrentSession().getCriteriaBuilder();
            CriteriaDelete<CondominiumAddress> deleteCriteria = cBuilder.createCriteriaDelete(CondominiumAddress.class);

            deleteCriteria
                    .where(cBuilder.equal(deleteCriteria.from(CondominiumAddress.class).get("condominium"), id));

            this.getCurrentSession().createQuery(deleteCriteria).executeUpdate();
  
            log.debug("Removing Condominium address successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Removing Condominium address with condominium id: " + id + "failed", e);
            throw e;
        }
    }

}

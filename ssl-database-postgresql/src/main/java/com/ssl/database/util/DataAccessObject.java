package com.ssl.database.util;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IDataAccessObject;

@Component
@Repository
@Scope("prototype")
public class DataAccessObject<T> implements IDataAccessObject<T>
{
    private static Logger log;

    private Class<T> clazz = null;

    @Override
    public void setClassType(Class<T> clazz)
    {
        this.clazz = clazz;
        log = LoggerFactory.getLogger(this.clazz);
    }

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
    public void addEntity(T entity)
    {
        log.debug("Persisting " + this.clazz.getName() + ": " + entity.toString() + " instance");
        try
        {
            this.getCurrentSession().persist(entity);
            log.debug("Persisting " + this.clazz.getName() + " successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Persisting " + this.clazz.getName() + ": " + entity.toString() + "failed", e);
            throw e;
        }
    }

    @Override
    public T getEntityById(int id)
    {
        log.debug("Getting " + this.clazz.getName() + " with id: " + id);

        T entity = null;

        try
        {
            entity = this.getCurrentSession().get(this.clazz, id);
            log.debug("Getting " + this.clazz.getName() + " successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Getting " + this.clazz.getName() + " with id: " + id + "failed", e);
            throw e;
        }
        return entity;
    }

    @Override
    public List<T> getEntitiesByEntityColumn(String columnName, Object columnValue)
    {
        log.debug("Getting " + this.clazz.getName() + " by: " + columnName);

        List<T> entities = null;

        try
        {
            CriteriaBuilder cBuilder = this.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<T> criteria = cBuilder.createQuery(this.clazz);

            criteria.select(criteria.from(this.clazz))
                    .where(cBuilder.equal(criteria.from(this.clazz).get(columnName), columnValue));

            entities = this.getCurrentSession().createQuery(criteria).getResultList();

            log.debug("Getting " + this.clazz.getName() + " successful ");
        }
        catch (NoResultException nre)
        {
            log.error("No entity: " + this.clazz.getName() + " found", nre);
        }
        catch (RuntimeException e)
        {
            log.error("Getting " + this.clazz.getName() + " with by: " + columnName + "failed", e);
            throw e;
        }
        return entities;
    }

    @Override
    public T getEntityByEntityColumn(String columnName, Object columnValue)
    {
        log.debug("Getting " + this.clazz.getName() + " by: " + columnName);

        T entity = null;

        try
        {
            CriteriaBuilder cBuilder = this.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<T> criteria = cBuilder.createQuery(this.clazz);

            criteria.select(criteria.from(this.clazz))
                    .where(cBuilder.equal(criteria.from(this.clazz).get(columnName), columnValue));

            entity = this.getCurrentSession().createQuery(criteria).getSingleResult();

            log.debug("Getting " + this.clazz.getName() + " successful ");
        }
        catch (NoResultException nre)
        {
            log.error("No entity: " + this.clazz.getName() + " found", nre);
        }
        catch (RuntimeException e)
        {
            log.error("Getting " + this.clazz.getName() + " with by: " + columnName + "failed", e);
            throw e;
        }
        return entity;
    }

    @Override
    public T updateEntity(T entity)
    {
        log.debug("Updating " + this.clazz.getName() + ": " + entity.toString() + " instance");

        T updatedEntity = null;
        try
        {
            Object obj = this.getCurrentSession().merge(entity);
            if (obj != null && this.clazz.isAssignableFrom(obj.getClass()))
            {
                updatedEntity = (T) obj;
            }
            log.debug("Updating " + this.clazz.getName() + " successful");
        }
        catch (RuntimeException e)
        {
            log.error("Updating " + this.clazz.getName() + ": " + entity.toString() + "failed", e);
            throw e;
        }
        return updatedEntity;
    }

    @Override
    public void removeEntity(T entity)
    {
        log.debug("Removing " + this.clazz.getName() + ": " + entity.toString() + " instance");
        try
        {
            this.getCurrentSession().delete(entity);
            log.debug("Removing " + this.clazz.getName() + " successful ");
        }
        catch (RuntimeException e)
        {
            log.error("Removing " + this.clazz.getName() + ": " + entity.toString() + "failed", e);
            throw e;
        }
    }

    @Override
    public void removeEntityById(int id)
    {
        log.debug("Removing " + this.clazz.getName() + "with id: " + id + " instance");
        try
        {
            T entity = this.getEntityById(id);
            this.getCurrentSession().delete(entity);
            log.debug("Removing " + this.clazz.getName() + " successful");
        }
        catch (RuntimeException e)
        {
            log.error("Removing " + this.clazz.getName() + "with id: " + id + "failed", e);
            throw e;
        }
    }

    @Override
    public void removeEntityByColumn(String columnName, Object columnValue)
    {
        log.debug("Removing " + this.clazz.getName() + "by: " + columnName + " instance");
        try
        {
            CriteriaBuilder cBuilder = this.getCurrentSession().getCriteriaBuilder();
            CriteriaDelete<T> deleteCriteria = cBuilder.createCriteriaDelete(this.clazz);

            deleteCriteria.where(cBuilder.equal(deleteCriteria.from(this.clazz).get(columnName), columnValue));

            this.getCurrentSession().createQuery(deleteCriteria).executeUpdate();

            log.debug("Removing " + this.clazz.getName() + " successful");
        }
        catch (RuntimeException e)
        {
            log.error("Removing " + this.clazz.getName() + "by: " + columnName + "failed", e);
            throw e;
        }
    }

    @Override
    public List<T> getAllEntitiesOrdered(String orderClause)
    {
        log.debug("Getting all entities from " + this.clazz.getName() + " in order by: " + orderClause);

        List<T> entities = null;

        try
        {
            CriteriaBuilder cBuilder = this.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<T> criteria = cBuilder.createQuery(this.clazz);

            criteria.select(criteria.from(this.clazz));
            if (orderClause != null && !orderClause.isEmpty())
            {
                criteria.orderBy(cBuilder.asc(criteria.from(this.clazz).get(orderClause)));
            }

            entities = this.getCurrentSession().createQuery(criteria).getResultList();
            log.debug("Getting all entities " + this.clazz.getName() + " successful");
        }
        catch (RuntimeException e)
        {
            log.error("Getting all entities from " + this.clazz.getName() + "failed", e);
            throw e;
        }
        return entities;

    }

    @Override
    public List<T> getAllEntities()
    {
        return this.getAllEntitiesOrdered("");
    }

}

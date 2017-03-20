package com.ssl.database;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface IDataAccessObject<T>
{
    void setClassType(Class<T> clazz);

    void addEntity(T entity);

    T getEntityById(int id);

    T getEntityByEntityColumn(String columnName, Object columnValue);

    List<T> getEntitiesByEntityColumn(String columnName, Object columnValue);

    T updateEntity(T entity);

    void removeEntity(T entity);

    void removeEntityById(int id);

    void removeEntityByColumn(String columnName, Object columnValue);

    List<T> getAllEntities();

    List<T> getAllEntitiesOrdered(String orderClause);

}

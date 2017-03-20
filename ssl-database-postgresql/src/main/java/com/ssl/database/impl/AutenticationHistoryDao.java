package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IAutenticationHistoryDao;
import com.ssl.database.IDataAccessObject;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.AutenticationHistory;

@Component
@Repository
public class AutenticationHistoryDao implements IAutenticationHistoryDao
{

    private static final Logger log = LoggerFactory.getLogger(AutenticationHistoryDao.class);

    @Autowired
    private IDataAccessObject<AutenticationHistory> autenticationHistoryDataAcessObject;

    @PostConstruct
    public void initAutenticationHistoryDao()
    {
        log.debug("Initializing generic repository access");
        this.autenticationHistoryDataAcessObject.setClassType(AutenticationHistory.class);
        log.debug("Generic repository initialized with entity :" + AutenticationHistory.class.getName());
    }

    @Override
    public void addAutenticationHistory(AutenticationHistory autenticationHistory)
    {
        this.autenticationHistoryDataAcessObject.addEntity(autenticationHistory);
    }

    @Override
    public AutenticationHistory getAutenticationHistoryById(int id)
    {
        return this.autenticationHistoryDataAcessObject.getEntityById(id);
    }

    @Override
    public List<AutenticationHistory> getAutenticationHistoryByCondominiumId(int condominiumId)
    {
        return this.autenticationHistoryDataAcessObject
                .getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.CONDOMINIUM, condominiumId);
    }

    @Override
    public List<AutenticationHistory> getAutenticationHistoryByEmployeId(int employeeId)
    {
        return this.autenticationHistoryDataAcessObject
                .getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.EMPLOYEE, employeeId);
    }

    @Override
    public List<AutenticationHistory> getAutenticationHistoryByUserId(int userId)
    {
        return this.autenticationHistoryDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.USER,
                userId);
    }

    @Override
    public AutenticationHistory updateAutenticationHistory(AutenticationHistory autenticationHistory)
    {
        return this.autenticationHistoryDataAcessObject.updateEntity(autenticationHistory);
    }

    @Override
    public void removeAutenticationHistory(AutenticationHistory autenticationHistory)
    {
        this.autenticationHistoryDataAcessObject.removeEntity(autenticationHistory);
    }

    @Override
    public void removeAutenticationHistoryById(int id)
    {
        this.autenticationHistoryDataAcessObject.removeEntityById(id);
    }

}

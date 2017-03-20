package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssl.database.IDataAccessObject;
import com.ssl.database.IScheduledVisitDao;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.ScheduledVisit;

public class ScheduledVisitDao implements IScheduledVisitDao
{

    private static final Logger log = LoggerFactory.getLogger(ScheduledVisitDao.class);

    @Autowired
    private IDataAccessObject<ScheduledVisit> scheduledVisitDataAcessObject;

    @PostConstruct
    public void initScheduledVisitDao()
    {
        log.debug("Initializing generic repository access");
        this.scheduledVisitDataAcessObject.setClassType(ScheduledVisit.class);
        log.debug("Generic repository initialized with entity :" + ScheduledVisit.class.getName());
    }

    @Override
    public void addScheduledVisit(ScheduledVisit visit)
    {
        this.scheduledVisitDataAcessObject.addEntity(visit);
    }

    @Override
    public ScheduledVisit getScheduledVisitById(int id)
    {
        return this.scheduledVisitDataAcessObject.getEntityById(id);
    }

    @Override
    public List<ScheduledVisit> getScheduledVisitByCondominium(int condominiumId)
    {
        return this.scheduledVisitDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.CONDOMINIUM,
                condominiumId);
    }

    @Override
    public ScheduledVisit updateScheduledVisit(ScheduledVisit visit)
    {
        return this.scheduledVisitDataAcessObject.updateEntity(visit);
    }

    @Override
    public void removeScheduledVisit(ScheduledVisit visit)
    {
        this.scheduledVisitDataAcessObject.removeEntity(visit);
    }

    @Override
    public void removeScheduledVisitById(int id)
    {
        this.scheduledVisitDataAcessObject.removeEntityById(id);
    }

    @Override
    public void removeScheduledVisitByCondominium(int condominiumId)
    {
        this.scheduledVisitDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.CONDOMINIUM,
                condominiumId);
    }

}

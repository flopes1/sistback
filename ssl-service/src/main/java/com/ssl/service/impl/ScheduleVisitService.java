package com.ssl.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.database.IPhoneNumberVisitorDao;
import com.ssl.database.IScheduledVisitDao;
import com.ssl.database.IServiceProvisionDao;
import com.ssl.database.IVisitorDao;
import com.ssl.entities.ScheduledVisit;
import com.ssl.service.IScheduledVisitService;

@Component
@Transactional
public class ScheduleVisitService implements IScheduledVisitService
{

    private static final Logger log = LoggerFactory.getLogger(ScheduleVisitService.class);

    @Autowired
    private IScheduledVisitDao scheduledVisitDao;

    @Autowired
    private IServiceProvisionDao serviceProvisionDao;

    @Autowired
    private IVisitorDao visitorDao;

    @Autowired
    private IPhoneNumberVisitorDao phoneNumberVisitorDao;

    @Override
    public void addScheduledVisit(ScheduledVisit visit)
    {
        this.scheduledVisitDao.addScheduledVisit(visit);
    }

    @Override
    public ScheduledVisit getScheduledVisitById(int id)
    {
        return this.scheduledVisitDao.getScheduledVisitById(id);
    }

    @Override
    public List<ScheduledVisit> getScheduledVisitByCondominium(int condominiumId)
    {
        return this.scheduledVisitDao.getScheduledVisitByCondominium(condominiumId);
    }

    @Override
    public ScheduledVisit updateScheduledVisit(ScheduledVisit visit)
    {
        return this.scheduledVisitDao.updateScheduledVisit(visit);
    }

    @Override
    public void removeScheduledVisit(ScheduledVisit visit)
    {
        this.scheduledVisitDao.removeScheduledVisit(visit);
    }

    @Override
    public void removeScheduledVisitById(int id)
    {
        this.scheduledVisitDao.removeScheduledVisitByCondominium(id);
    }

    @Override
    public void removeScheduledVisitByCondominium(int condominiumId)
    {
        this.scheduledVisitDao.removeScheduledVisitByCondominium(condominiumId);
    }

}

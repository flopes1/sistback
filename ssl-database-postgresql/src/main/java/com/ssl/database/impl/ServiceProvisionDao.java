package com.ssl.database.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IDataAccessObject;
import com.ssl.database.IServiceProvisionDao;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.ServiceProvision;

@Component
@Repository
public class ServiceProvisionDao implements IServiceProvisionDao
{

    private static final Logger log = LoggerFactory.getLogger(ServiceProvisionDao.class);

    @Autowired
    private IDataAccessObject<ServiceProvision> serviceProvisionDataAcessObject;

    @PostConstruct
    public void initServiceProvisionDao()
    {
        log.debug("Initializing generic repository access");
        this.serviceProvisionDataAcessObject.setClassType(ServiceProvision.class);
        log.debug("Generic repository initialized with entity :" + ServiceProvision.class.getName());
    }

    @Override
    public void addServiceProvision(ServiceProvision serviceProvision)
    {
        this.serviceProvisionDataAcessObject.addEntity(serviceProvision);
    }

    @Override
    public ServiceProvision getServiceProvisionById(int id)
    {
        return this.serviceProvisionDataAcessObject.getEntityById(id);
    }

    @Override
    public ServiceProvision getServiceProvisionByScheduledVisitId(int scheduledVisitId)
    {
        return this.serviceProvisionDataAcessObject
                .getEntityByEntityColumn(DataBaseColumnQuerysConstants.SCHEDULED_VISIT, scheduledVisitId);
    }

    @Override
    public ServiceProvision updateServiceProvision(ServiceProvision serviceProvision)
    {
        return this.serviceProvisionDataAcessObject.updateEntity(serviceProvision);
    }

    @Override
    public void removeServiceProvision(ServiceProvision serviceProvision)
    {
        this.serviceProvisionDataAcessObject.removeEntity(serviceProvision);
    }

    @Override
    public void removeServiceProvisionById(int id)
    {
        this.serviceProvisionDataAcessObject.removeEntityById(id);
    }

    @Override
    public void removeServiceProvisionByScheduledVisitId(int scheduledVisitId)
    {
        this.serviceProvisionDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.SCHEDULED_VISIT,
                scheduledVisitId);
    }

}

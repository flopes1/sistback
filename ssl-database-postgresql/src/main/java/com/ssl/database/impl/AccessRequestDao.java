package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssl.database.IAccessRequestDao;
import com.ssl.database.IDataAccessObject;
import com.ssl.entities.AccessRequest;

public class AccessRequestDao implements IAccessRequestDao
{

    private static final Logger log = LoggerFactory.getLogger(AccessRequestDao.class);

    @Autowired
    private IDataAccessObject<AccessRequest> accessRequestDataAcessObject;

    @PostConstruct
    public void initAccessRequestDao()
    {
        log.debug("Initializing generic repository access");
        this.accessRequestDataAcessObject.setClassType(AccessRequest.class);
        log.debug("Generic repository initialized with entity :" + AccessRequest.class.getName());
    }

    @Override
    public void addAccessRequest(AccessRequest accessRequest)
    {
        this.accessRequestDataAcessObject.addEntity(accessRequest);
    }

    @Override
    public AccessRequest getAccessRequestById(int accessRequetId)
    {
        return this.accessRequestDataAcessObject.getEntityById(accessRequetId);
    }

    @Override
    public List<AccessRequest> getAllAccessRequest()
    {
        return this.accessRequestDataAcessObject.getAllEntities();
    }

    @Override
    public AccessRequest updateAccessRequest(AccessRequest accessRequest)
    {
        return this.accessRequestDataAcessObject.updateEntity(accessRequest);
    }

    @Override
    public void removeAccessRequest(AccessRequest accessRequest)
    {
        this.accessRequestDataAcessObject.removeEntity(accessRequest);
    }

    @Override
    public void removeAccessRequestById(int accessRequetId)
    {
        this.accessRequestDataAcessObject.removeEntityById(accessRequetId);
    }

}

package com.ssl.database.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.ICondominiumAddressDao;
import com.ssl.database.IDataAccessObject;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.CondominiumAddress;

@Component
@Repository
public class CondominiumAddressDao implements ICondominiumAddressDao
{
    private static final Logger log = LoggerFactory.getLogger(CondominiumAddressDao.class);

    @Autowired
    private IDataAccessObject<CondominiumAddress> condAddressDataAcessObject;

    @PostConstruct
    public void initCondominiumAddressDao()
    {
        log.debug("Initializing generic repository access");
        this.condAddressDataAcessObject.setClassType(CondominiumAddress.class);
        log.debug("Generic repository initialized with entity :" + CondominiumAddress.class.getName());
    }

    @Override
    public void addCondominiumAddress(CondominiumAddress address)
    {
        this.condAddressDataAcessObject.addEntity(address);
    }

    @Override
    public CondominiumAddress getCondominiumAddressById(int id)
    {
        return this.condAddressDataAcessObject.getEntityById(id);
    }

    @Override
    public CondominiumAddress getCondominiumAddressByCondominiumId(int condId)
    {
        return this.condAddressDataAcessObject.getEntityByEntityColumn(DataBaseColumnQuerysConstants.CONDOMINIUM,
                condId);
    }

    @Override
    public CondominiumAddress updateCondominiumAddress(CondominiumAddress address)
    {
        return this.condAddressDataAcessObject.updateEntity(address);
    }

    @Override
    public void removeCondominiumAddress(CondominiumAddress address)
    {
        this.condAddressDataAcessObject.removeEntity(address);
    }

    @Override
    public void removeCondominiumAddressById(int id)
    {
        this.condAddressDataAcessObject.removeEntityById(id);
    }

    @Override
    public void removeCondominiumAddressByCondominiumId(int id)
    {
        this.condAddressDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.CONDOMINIUM, id);
    }

}

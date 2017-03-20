package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IDataAccessObject;
import com.ssl.database.IPhoneNumberCondominiumDao;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.PhoneNumberCondominium;

@Component
@Repository
public class PhoneNumberCondominiumDao implements IPhoneNumberCondominiumDao
{

    private static final Logger log = LoggerFactory.getLogger(PhoneNumberCondominiumDao.class);

    @Autowired
    private IDataAccessObject<PhoneNumberCondominium> phoneNumberCondominiumDataAcessObject;

    @PostConstruct
    public void initPhoneNumberCondominiumDao()
    {
        log.debug("Initializing generic repository access");
        this.phoneNumberCondominiumDataAcessObject.setClassType(PhoneNumberCondominium.class);
        log.debug("Generic repository with entity :" + PhoneNumberCondominium.class.getName());
    }

    @Override
    public void addPhoneNumber(PhoneNumberCondominium number)
    {
        this.phoneNumberCondominiumDataAcessObject.addEntity(number);
    }

    @Override
    public List<PhoneNumberCondominium> getNumberByOwnerId(int id)
    {
        return this.phoneNumberCondominiumDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.USER,
                id);
    }

    @Override
    public PhoneNumberCondominium updateNumber(PhoneNumberCondominium number)
    {
        return this.phoneNumberCondominiumDataAcessObject.updateEntity(number);
    }

    @Override
    public void removeNumber(PhoneNumberCondominium number)
    {
        this.phoneNumberCondominiumDataAcessObject.removeEntity(number);
    }

    @Override
    public void removeNumberByOwnerId(int id)
    {
        this.phoneNumberCondominiumDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.USER, id);
    }

}

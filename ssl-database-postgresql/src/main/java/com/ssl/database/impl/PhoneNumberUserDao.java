package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IDataAccessObject;
import com.ssl.database.IPhoneNumberUserDao;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.PhoneNumberUserr;

@Component
@Repository
public class PhoneNumberUserDao implements IPhoneNumberUserDao
{

    private static final Logger log = LoggerFactory.getLogger(PhoneNumberUserDao.class);

    @Autowired
    private IDataAccessObject<PhoneNumberUserr> phoneNumberUserDataAcessObject;

    @PostConstruct
    public void initPhoneNumberUserDao()
    {
        log.debug("Initializing generic repository access");
        this.phoneNumberUserDataAcessObject.setClassType(PhoneNumberUserr.class);
        log.debug("Generic repository with entity :" + PhoneNumberUserr.class.getName());
    }

    @Override
    public void addPhoneNumber(PhoneNumberUserr number)
    {
        this.phoneNumberUserDataAcessObject.addEntity(number);
    }

    @Override
    public List<PhoneNumberUserr> getNumberByOwnerId(int id)
    {
        return this.phoneNumberUserDataAcessObject
                .getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.USER, id);
    }

    @Override
    public PhoneNumberUserr updateNumber(PhoneNumberUserr number)
    {
        return this.phoneNumberUserDataAcessObject.updateEntity(number);
    }

    @Override
    public void removeNumber(PhoneNumberUserr number)
    {
        this.phoneNumberUserDataAcessObject.removeEntity(number);
    }

    @Override
    public void removeNumberByOwnerId(int id)
    {
        this.phoneNumberUserDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.USER, id);
    }

}

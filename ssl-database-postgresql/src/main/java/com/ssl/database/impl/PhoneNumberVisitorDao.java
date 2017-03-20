package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IDataAccessObject;
import com.ssl.database.IPhoneNumberVisitorDao;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.PhoneNumberVisitor;

@Component
@Repository
public class PhoneNumberVisitorDao implements IPhoneNumberVisitorDao
{

    private static final Logger log = LoggerFactory.getLogger(PhoneNumberVisitorDao.class);

    @Autowired
    private IDataAccessObject<PhoneNumberVisitor> phoneNumberVisitorDataAcessObject;

    @PostConstruct
    public void initPhoneNumberVisitorDao()
    {
        log.debug("Initializing generic repository access");
        this.phoneNumberVisitorDataAcessObject.setClassType(PhoneNumberVisitor.class);
        log.debug("Generic repository with entity :" + PhoneNumberVisitor.class.getName());
    }

    @Override
    public void addPhoneNumber(PhoneNumberVisitor number)
    {
        this.phoneNumberVisitorDataAcessObject.addEntity(number);
    }

    @Override
    public List<PhoneNumberVisitor> getNumberByOwnerId(int id)
    {
        return this.phoneNumberVisitorDataAcessObject
                .getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.VISITOR, id);
    }

    @Override
    public PhoneNumberVisitor updateNumber(PhoneNumberVisitor number)
    {
        return this.phoneNumberVisitorDataAcessObject.updateEntity(number);
    }

    @Override
    public void removeNumber(PhoneNumberVisitor number)
    {
        this.phoneNumberVisitorDataAcessObject.removeEntity(number);
    }

    @Override
    public void removeNumberByOwnerId(int id)
    {
        this.phoneNumberVisitorDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.USER, id);
    }

}

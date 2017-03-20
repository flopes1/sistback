package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IDataAccessObject;
import com.ssl.database.IPhoneNumberEmployeeDao;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.PhoneNumberEmployee;

@Component
@Repository
public class PhoneNumberEmployeeDao implements IPhoneNumberEmployeeDao
{

    private static final Logger log = LoggerFactory.getLogger(PhoneNumberEmployeeDao.class);

    @Autowired
    private IDataAccessObject<PhoneNumberEmployee> phoneNumberEmployeeDataAcessObject;

    @PostConstruct
    public void initPhoneNumberEmployeeDao()
    {
        log.debug("Initializing generic repository access");
        this.phoneNumberEmployeeDataAcessObject.setClassType(PhoneNumberEmployee.class);
        log.debug("Generic repository with entity :" + PhoneNumberEmployee.class.getName());
    }

    @Override
    public void addPhoneNumber(PhoneNumberEmployee number)
    {
        this.phoneNumberEmployeeDataAcessObject.addEntity(number);
    }

    @Override
    public List<PhoneNumberEmployee> getNumberByOwnerId(int id)
    {
        return this.phoneNumberEmployeeDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.EMPLOYEE,
                id);
    }

    @Override
    public PhoneNumberEmployee updateNumber(PhoneNumberEmployee number)
    {
        return this.phoneNumberEmployeeDataAcessObject.updateEntity(number);
    }

    @Override
    public void removeNumber(PhoneNumberEmployee number)
    {
        this.phoneNumberEmployeeDataAcessObject.removeEntity(number);
    }

    @Override
    public void removeNumberByOwnerId(int id)
    {
        this.phoneNumberEmployeeDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.USER, id);
    }

}

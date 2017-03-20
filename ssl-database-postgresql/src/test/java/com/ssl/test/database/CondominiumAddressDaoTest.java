package com.ssl.test.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.config.HibernateConfig;
import com.ssl.database.ICondominiumAddressDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
    { HibernateConfig.class })
@Transactional(propagation = Propagation.REQUIRED)
public class CondominiumAddressDaoTest
{
    // TODO Test MP

    @Autowired
    private ICondominiumAddressDao condAddressDAO;

}

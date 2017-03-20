package com.ssl.test.database;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.config.HibernateConfig;
import com.ssl.database.IUserDao;
import com.ssl.entities.Condominium;
import com.ssl.entities.PhoneNumberUserr;
import com.ssl.entities.Userr;
import com.ssl.entities.Vehicle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
    { HibernateConfig.class })
@Transactional(propagation = Propagation.REQUIRED)
public class UserDaoTest
{

    @Autowired
    private IUserDao userDAO;

    @Test
    public void test()
    {
        fail("Not yet implemented");
    }

    private Set<Userr> getMockUserr(Condominium condominium)
    {
        Set<Userr> users = new HashSet<>();

        for (int i = 0; i < 10; i++)
        {
            Userr user = new Userr();
            user.setName("Usuario" + i);
            user.setCpf("111111111" + i);
            user.setApartmentIdentifier("APT" + i);
            user.setEmail("EmailUser" + i);
            user.setPhoneNumberUserrs(this.getMockPhoneNumberUser(user));
            user.setVehicles(this.getMockVehicles(user));

            user.setCondominium(condominium);

            users.add(user);
        }

        return users;
    }

    private Set<Vehicle> getMockVehicles(Userr user)
    {
        Set<Vehicle> vehicles = new HashSet<>();

        for (int i = 0; i < 2; i++)
        {
            Vehicle vehicle1 = new Vehicle();
            vehicle1.setLicensePlate("123abc" + i);
            vehicle1.setModel("Vovorola" + i);
            vehicle1.setColor("Azul" + i);
            vehicle1.setUserr(user);

            vehicles.add(vehicle1);
        }

        return vehicles;
    }

    private Set<PhoneNumberUserr> getMockPhoneNumberUser(Userr user)
    {
        Set<PhoneNumberUserr> numbers = new HashSet<>();

        for (int i = 0; i < 2; i++)
        {
            PhoneNumberUserr ph = new PhoneNumberUserr();
            ph.setCountryCode((short) 55);
            ph.setStateCode((short) 81);
            ph.setNumber(7777777 + i + 1);
            ph.setUserr(user);

            numbers.add(ph);
        }

        return numbers;
    }

}

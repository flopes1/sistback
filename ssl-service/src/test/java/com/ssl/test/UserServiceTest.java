package com.ssl.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.config.HibernateConfig;
import com.ssl.entities.Condominium;
import com.ssl.entities.PhoneNumberUserr;
import com.ssl.entities.Userr;
import com.ssl.entities.Vehicle;
import com.ssl.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
    { HibernateConfig.class })
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceTest
{

    @Autowired
    private IUserService userService;

    @Rollback(false)
    @Test
    public void login()
    {
        Userr userInDatabase = this.getMockUserr();

        this.userService.addUser(userInDatabase);

        Userr user = new Userr();
        user.setEmail("email@gmail.com");
        user.setPassword("123");

        Userr verifiedUser = this.userService.login(user);

        assertEquals(verifiedUser == null, false);

    }

    private Userr getMockUserr()
    {

        Userr user = new Userr();
        user.setName("Usuario 1");
        user.setCpf("111111111");
        user.setApartmentIdentifier("APT 77");
        user.setEmail("email@gmail.com");
        user.setPassword("123");
        user.setPhoneNumberUserrs(this.getMockPhoneNumberUser(user));
        user.setVehicles(this.getMockVehicles(user));

        Condominium condominium = new Condominium();
        condominium.setId(1);

        user.setCondominium(condominium);

        return user;

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

package com.ssl.test.database;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
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
import com.ssl.database.ICondominiumDao;
import com.ssl.entities.Condominium;
import com.ssl.entities.CondominiumAddress;
import com.ssl.entities.Employee;
import com.ssl.entities.PhoneNumberCondominium;
import com.ssl.entities.PhoneNumberEmployee;
import com.ssl.entities.PhoneNumberUserr;
import com.ssl.entities.Userr;
import com.ssl.entities.Vehicle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
    { HibernateConfig.class })
@Transactional(propagation = Propagation.REQUIRED)
public class CondominiumDaoTest
{
    // TODO Configurar o teste para zerar o banco a cada @Test, da forma que está os testes só
    // funcionam na primeira vez em que são executados

    @Autowired
    private ICondominiumDao condDAO;

    @Rollback(false)
    @Test
    public void addCondominium()
    {
        // Condominium condominium = new Condominium();
        // condominium.setName("Nome do condominio add");
        //
        // CondominiumAddress address = this.getMockAddress(condominium);
        // condominium.setCondominiumAddress(address);
        //
        // condominium.setPhoneNumberCondominiums(this.getMockPhoneNumberCondominium(condominium));
        //
        // try
        // {
        // condDAO.addCondominium(condominium);
        // }
        // catch (Exception e)
        // {
        // fail();
        // }

    }

    @Rollback(false)
    @Test
    public void getCondominiumById()
    {
        // Condominium condominium = new Condominium();
        // condominium.setName("Nome do condominio get by id");
        //
        // CondominiumAddress address = this.getMockAddress(condominium);
        // condominium.setCondominiumAddress(address);
        //
        // condominium.setPhoneNumberCondominiums(this.getMockPhoneNumberCondominium(condominium));
        //
        // this.condDAO.addCondominium(condominium);

        // Condominium added = this.condDAO.getCondominiumById(2);
        //
        // assertEquals(added != null, true);
        // assertEquals(added.getId(), 2);

    }

    @Rollback(false)
    @Test
    public void getCondominiumByName()
    {
        // Condominium condominium = new Condominium();
        // condominium.setName("Nome do condominio by name");
        //
        // CondominiumAddress address = this.getMockAddress(condominium);
        // condominium.setCondominiumAddress(address);
        //
        // condominium.setPhoneNumberCondominiums(this.getMockPhoneNumberCondominium(condominium));
        //
        // condDAO.addCondominium(condominium);
        //
        // Condominium cond = condDAO.getCondominiumByName("Nome do condominio by name");
        //
        // assertEquals(cond != null, true);
        // assertEquals(cond.getName(), "Nome do condominio by name");
    }

    @Rollback(false)
    @Test
    public void removeCondominium()
    {
        // Condominium condominium = new Condominium();
        // condominium.setName("Nome do condominio Remove");
        //
        // CondominiumAddress address = this.getMockAddress(condominium);
        // condominium.setCondominiumAddress(address);
        //
        // condominium.setPhoneNumberCondominiums(this.getMockPhoneNumberCondominium(condominium));
        //
        // condDAO.addCondominium(condominium);
        // Condominium cond = condDAO.getCondominiumByName("Nome do condominio Remove");
        //
        // assertEquals(cond != null, true);
        // assertEquals(cond.getName(), "Nome do condominio Remove");
        //
        // condDAO.removeCondominium(condominium);
        // Condominium cond2 = condDAO.getCondominiumByName("Nome do condominio Remove");
        //
        // assertEquals(cond2 == null, true);
    }

    @Test
    public void removeCondominiumById()
    {
        // Condominium condominium = new Condominium();
        // condominium.setName("Nome do condominio Remove id");
        //
        // CondominiumAddress address = this.getMockAddress();
        // condominium.setCondominiumAddress(address);
        // address.setCondominium(condominium);
        //
        // condDAO.addCondominium(condominium);
        // Condominium cond = condDAO.getCondominiumById(113);
        //
        // assertEquals(cond != null, true);
        // assertEquals(cond.getName(), "Nome do condominio Remove id");
        //
        // condDAO.removeCondominiumById(113);
        // Condominium cond2 = condDAO.getCondominiumByName("Nome do condominio Remove id");
        //
        // assertEquals(cond2 == null, true);
    }

    @Rollback(false)
    @Test
    public void removeCondominiumByName()
    {
        // Condominium condominium = new Condominium();
        // condominium.setName("Nome do condominio Remove Name");
        //
        // CondominiumAddress address = this.getMockAddress(condominium);
        // condominium.setCondominiumAddress(address);
        //
        // condominium.setPhoneNumberCondominiums(this.getMockPhoneNumberCondominium(condominium));
        //
        // condDAO.addCondominium(condominium);
        // Condominium cond = condDAO.getCondominiumByName("Nome do condominio Remove Name");
        //
        // assertEquals(cond != null, true);
        // assertEquals(cond.getName(), "Nome do condominio Remove Name");
        //
        // condDAO.removeCondominiumByName("Nome do condominio Remove Name");
        // Condominium cond2 = condDAO.getCondominiumByName("Nome do condominio Remove Name");
        //
        // assertEquals(cond2 == null, true);
    }

    @Rollback(false)
    @Test
    public void updateCondominium()
    {
        // Condominium condominium = new Condominium();
        // condominium.setName("Nome do condominio update");
        //
        // CondominiumAddress address = this.getMockAddress(condominium);
        // condominium.setCondominiumAddress(address);
        //
        // condominium.setPhoneNumberCondominiums(this.getMockPhoneNumberCondominium(condominium));
        //
        // condDAO.addCondominium(condominium);
        // Condominium cond = condDAO.getCondominiumByName("Nome do condominio update");
        //
        // assertEquals(cond != null, true);
        // assertEquals(cond.getName(), "Nome do condominio update");
        //
        // cond.setName("Nome do condominio update pos update");
        //
        // Condominium updatedCond = condDAO.updateCondominium(cond);
        //
        // assertEquals(updatedCond != null, true);
        // assertEquals(updatedCond.getName(), "Nome do condominio update pos update");

    }

    @Rollback(false)
    @Test
    public void getAllCondominiums()
    {
        // for (int i = 0; i < 5; i++)
        // {
        // Condominium condominium = new Condominium();
        // condominium.setName("Nome " + i);
        //
        // CondominiumAddress address = this.getMockAddress(condominium);
        // condominium.setCondominiumAddress(address);
        //
        // condominium.setPhoneNumberCondominiums(this.getMockPhoneNumberCondominium(condominium));
        //
        // condDAO.addCondominium(condominium);
        // }

        // List<Condominium> allCond = this.condDAO.getAllCondominiums();
        //
        // assertEquals(allCond == null, false);
        // assertEquals(allCond.size(), 5);

    }

    public CondominiumAddress getMockAddress(Condominium condominium)
    {
        CondominiumAddress address = new CondominiumAddress();
        address.setCity("Jaboatao");
        address.setCountry("Brasil");
        address.setDistrict("Piedade");
        address.setNumber(777);
        address.setState("PE");
        address.setZipCode(7777777);
        address.setStreet("Rua 7");
        address.setComplement("Complemento");
        address.setCondominium(condominium);
        //
        return address;
    }

    private Set<PhoneNumberCondominium> getMockPhoneNumberCondominium(Condominium condominium)
    {
        Set<PhoneNumberCondominium> numbers = new HashSet<>();

        for (int i = 0; i < 2; i++)
        {
            PhoneNumberCondominium ph = new PhoneNumberCondominium();
            ph.setCountryCode((short) 55);
            ph.setStateCode((short) 81);
            ph.setNumber(7777777);
            ph.setCondominium(condominium);

            numbers.add(ph);
        }

        return numbers;
    }

}

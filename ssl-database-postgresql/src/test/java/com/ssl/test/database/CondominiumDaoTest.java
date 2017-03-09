package com.ssl.test.database;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.config.HibernateConfig;
import com.ssl.database.ICondominiumDao;
import com.ssl.entities.Condominium;
import com.ssl.entities.CondominiumAddress;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
    { HibernateConfig.class })
@Transactional(propagation = Propagation.REQUIRED)
public class CondominiumDaoTest
{
    // TODO Id based tests will fail caused postgree sequence generator error
    @Autowired
    private ICondominiumDao condDAO;

    @Test
    public void addCondominiumAndGetById()
    {
        Condominium condominium = new Condominium();
        condominium.setName("Nome");

        CondominiumAddress address = this.getMockAddress();
        condominium.setCondominiumAddress(address);
        address.setCondominium(condominium);

        condDAO.addCondominium(condominium);

        Condominium cond = condDAO.getCondominiumById(103);

        assertEquals(cond != null, true);
    }

    @Test
    public void getCondominiumByName()
    {
        Condominium condominium = new Condominium();
        condominium.setName("Nome do condominio");

        CondominiumAddress address = this.getMockAddress();
        condominium.setCondominiumAddress(address);
        address.setCondominium(condominium);

        condDAO.addCondominium(condominium);
        // condDAO.removeEntity(condominium);

        Condominium cond = condDAO.getCondominiumByName("Nome do condominio");

        assertEquals(cond != null, true);
        assertEquals(cond.getName(), "Nome do condominio");
    }

    @Test
    public void removeCondominium()
    {
        Condominium condominium = new Condominium();
        condominium.setName("Nome do condominio Remove");

        CondominiumAddress address = this.getMockAddress();
        condominium.setCondominiumAddress(address);
        address.setCondominium(condominium);

        condDAO.addCondominium(condominium);
        Condominium cond = condDAO.getCondominiumByName("Nome do condominio Remove");

        assertEquals(cond != null, true);
        assertEquals(cond.getName(), "Nome do condominio Remove");

        condDAO.removeCondominium(condominium);
        Condominium cond2 = condDAO.getCondominiumByName("Nome do condominio Remove");

        assertEquals(cond2 == null, true);
    }

    @Test
    public void removeCondominiumById()
    {
        Condominium condominium = new Condominium();
        condominium.setName("Nome do condominio Remove id");

        CondominiumAddress address = this.getMockAddress();
        condominium.setCondominiumAddress(address);
        address.setCondominium(condominium);

        condDAO.addCondominium(condominium);
        Condominium cond = condDAO.getCondominiumById(113);

        assertEquals(cond != null, true);
        assertEquals(cond.getName(), "Nome do condominio Remove id");

        condDAO.removeCondominiumById(113);
        Condominium cond2 = condDAO.getCondominiumByName("Nome do condominio Remove id");

        assertEquals(cond2 == null, true);
    }

    @Test
    public void removeCondominiumByName()
    {
        Condominium condominium = new Condominium();
        condominium.setName("Nome do condominio Remove Name");

        CondominiumAddress address = this.getMockAddress();
        condominium.setCondominiumAddress(address);
        address.setCondominium(condominium);

        condDAO.addCondominium(condominium);
        Condominium cond = condDAO.getCondominiumByName("Nome do condominio Remove Name");

        assertEquals(cond != null, true);
        assertEquals(cond.getName(), "Nome do condominio Remove Name");

        condDAO.removeCondominiumByName("Nome do condominio Remove Name");
        Condominium cond2 = condDAO.getCondominiumByName("Nome do condominio Remove Name");

        assertEquals(cond2 == null, true);
    }

    @Test
    public void updateCondominium()
    {
        Condominium condominium = new Condominium();
        condominium.setName("Nome do condominio update");

        CondominiumAddress address = this.getMockAddress();
        condominium.setCondominiumAddress(address);
        address.setCondominium(condominium);

        condDAO.addCondominium(condominium);
        Condominium cond = condDAO.getCondominiumByName("Nome do condominio update");

        assertEquals(cond != null, true);
        assertEquals(cond.getName(), "Nome do condominio update");

        cond.setName("Nome do condominio update pos update");

        Condominium updatedCond = condDAO.updateCondominium(cond);

        assertEquals(updatedCond != null, true);
        assertEquals(updatedCond.getName(), "Nome do condominio update pos update");

    }

    @Test
    public void getAllCondominiums()
    {
        for (int i = 0; i < 5; i++)
        {
            Condominium condominium = new Condominium();
            condominium.setName("Nome " + i);

            CondominiumAddress address = this.getMockAddress();
            condominium.setCondominiumAddress(address);
            address.setCondominium(condominium);
            condDAO.addCondominium(condominium);
        }

        List<Condominium> allCond = this.condDAO.getAllCondominiums();

        assertEquals(allCond == null, false);
        assertEquals(allCond.size(), 5);

    }

    public CondominiumAddress getMockAddress()
    {
        CondominiumAddress address = new CondominiumAddress();
        address.setCity("Jaboatao");
        address.setCountry("Brasil");
        address.setDistrict("Piedade");
        address.setNumber(777);
        address.setState("PE");
        address.setZipCode(7777777);
        address.setStreet("Rua 7");
        return address;
    }
}

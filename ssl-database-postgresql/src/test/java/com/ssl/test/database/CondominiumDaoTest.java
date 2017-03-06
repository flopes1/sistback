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

    @Autowired
    private ICondominiumDao condDAO;

    // @Rollback(false)
    @Test
    public void testAddCondominiumAndGetById()
    {
        Condominium c = new Condominium();
        c.setName("Nome7777777");

        CondominiumAddress a = this.getMockAddress();

        c.setCondominiumAddress(a);
        a.setCondominium(c);

        condDAO.addCondominium(c);

        Condominium cond = condDAO.getCondominiumById(30);

        assertEquals(cond != null, true);
        assertEquals(cond.getName(), "Nome");
    }

    @Test
    public void testRemoveCondominiumAndGetByName()
    {
        Condominium c = new Condominium();
        c.setName("Nome do condominio");

        CondominiumAddress a = this.getMockAddress();
        c.setCondominiumAddress(a);
        a.setCondominium(c);

        condDAO.addCondominium(c);
        condDAO.removeCondominium(c);

        Condominium cond = condDAO.getCondominiumByName("Nome do condominio");

        assertEquals(cond != null, true);
        assertEquals(cond.getName(), "Nome do condominio");
        assertEquals(cond.getActive(), false);
    }

    @Test
    public void testUpdateCondominium()
    {
        Condominium c = new Condominium();
        c.setName("Nome do condominio");

        condDAO.addCondominium(c);

        c.setName("Nome do condominio editado");

        condDAO.updateCondominium(c);

        Condominium cond = condDAO.getCondominiumByName("Nome do condominio editado");

        assertEquals(cond != null, true);
        assertEquals(cond.getName(), "Nome do condominio editado");
    }

    @Test
    public void getAllCondominiums()
    {
        for (int i = 0; i < 5; i++)
        {
            Condominium a = new Condominium();
            a.setName("Nome: " + i);
            condDAO.addCondominium(a);
        }

        List<Condominium> allCond = this.condDAO.getAllCondominiums();

        assertEquals(allCond == null, false);
        assertEquals(allCond.size(), 5);

    }

    private CondominiumAddress getMockAddress()
    {
        CondominiumAddress address = new CondominiumAddress();
        address.setCity("Jaboatao7777");
        address.setCountry("Brasil7777");
        address.setDistrict("Piedade777");
        address.setNumber(1554);
        address.setState("PE777");
        address.setZipCode(7777777);
        address.setStreet("Rua 277777");
        return address;
    }
}

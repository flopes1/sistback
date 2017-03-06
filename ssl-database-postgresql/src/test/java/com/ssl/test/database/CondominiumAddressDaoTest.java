package com.ssl.test.database;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.config.HibernateConfig;
import com.ssl.database.ICondominiumAdressDao;
import com.ssl.entities.Condominium;
import com.ssl.entities.CondominiumAddress;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
    { HibernateConfig.class })
@Transactional(propagation = Propagation.REQUIRED)
public class CondominiumAddressDaoTest
{
    // TODO Fix-me Refatorar teste após correção de dupla referencia endereço vs condominio
    // se for realmente necessário
    @Autowired
    private ICondominiumAdressDao condAddressDAO;

    // @Rollback(false)
    @Test
    public void testAddCondominiumAddressAndGetById()
    {
        CondominiumAddress c = new CondominiumAddress();
        c.setCity("Recife");
        c.setCountry("Brasil");
        c.setDistrict("Candeias");
        c.setNumber(1554);
        c.setState("PE");
        c.setZipCode(12345678);
        c.setStreet("Rua 1");

        Condominium condominium = new Condominium();
        condominium.setId(30);
        condominium.setName("Condominio padrão");

        c.setCondominium(condominium);

        condAddressDAO.addCondominiumAddress(c);

        CondominiumAddress cond = condAddressDAO.getCondominiumAddressById(3);

        assertEquals(cond != null, true);
        assertEquals(cond.getId(), "3");
    }

    @Test
    public void testRemoveCondominiumAdressAndGetByCondominiumId()
    {
        CondominiumAddress address = new CondominiumAddress();
        address.setCity("Recife");
        address.setCountry("Brasil");
        address.setDistrict("Candeias");
        address.setNumber(1554);
        address.setState("PE");
        address.setZipCode(12345678);
        address.setStreet("Rua 1");

        Condominium condominium = new Condominium();
        condominium.setId(30);
        condominium.setName("Condominio padrão");

        address.setCondominium(condominium);

        condAddressDAO.addCondominiumAddress(address);

        CondominiumAddress insertedAd = condAddressDAO.getCondominiumAddressByCondominiumId(condominium.getId());

        condAddressDAO.removeCondominiumAddress(insertedAd);

        CondominiumAddress deleted = condAddressDAO.getCondominiumAddressById(30);

        assertEquals(deleted != null, false);
    }

    @Test
    public void testUpdateCondominium()
    {
        CondominiumAddress address = new CondominiumAddress();
        address.setCity("Recife");
        address.setCountry("Brasil");
        address.setDistrict("Candeias");
        address.setNumber(1554);
        address.setState("PE");
        address.setZipCode(12345678);
        address.setStreet("Rua 1");

        // Condominium condominium = new Condominium();
        // condominium.setId(120);
        // condominium.setName("Condominio padrão");

        // address.setCondominium(condominium);
        // condominium.setCondominiumAddress(address);

        condAddressDAO.addCondominiumAddress(address);

        address.setNumber(777777);

        CondominiumAddress operation = condAddressDAO.updateCondominiumAddress(address);

        CondominiumAddress updated = condAddressDAO.getCondominiumAddressById(operation.getId());

        assertEquals(updated.getNumber(), operation.getNumber());
    }

    @Test
    public void testRemoveCondominiumAddressByCondominiumId()
    {
        CondominiumAddress address = new CondominiumAddress();
        address.setCity("Recife");
        address.setCountry("Brasil");
        address.setDistrict("Candeias");
        address.setNumber(1554);
        address.setState("PE");
        address.setZipCode(12345678);
        address.setStreet("Rua 1");

        // Condominium condominium = new Condominium();
        // condominium.setId(120);
        // condominium.setName("Condominio padrão");

        // address.setCondominium(condominium);
        // condominium.setCondominiumAddress(address);

        // condAddressDAO.addCondominiumAddress(address);
        CondominiumAddress before = this.condAddressDAO.getCondominiumAddressByCondominiumId(100);
        assertEquals(before != null, true);
        condAddressDAO.removeCondominiumAddressByCondominiumId(100);
        CondominiumAddress after = condAddressDAO.getCondominiumAddressById(before.getId());
        assertEquals(after == null, true);
    }

}

package condominium;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssl.dao.imp.CondominiumHome;
import com.ssl.entities.Condominium;

public class CondominiumTest
{
    @Autowired
    private CondominiumHome condDao;
    
    @Before
    public void initialize()
    {
    }
    
    @Test
    public void insert()
    {
        Condominium cond = new Condominium();
        cond.setName("Teste nome");
        this.condDao.persist(cond);
    }

}

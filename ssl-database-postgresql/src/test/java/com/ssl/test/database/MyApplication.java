package com.ssl.test.database;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssl.database.ICondominiumDao;
import com.ssl.entities.Condominium;

/**
 * 
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 * 
 */
@Component
public class MyApplication {

	final static Logger logger = Logger.getLogger(MyApplication.class);

	@Autowired
	private ICondominiumDao cond;
	
	public void performDbTasks()
	{
		Condominium c = new Condominium();
		c.setName("Condominio 1");

		cond.addCondominium(c);
		

	}

}

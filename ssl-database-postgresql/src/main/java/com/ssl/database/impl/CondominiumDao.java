package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.ICondominiumDao;
import com.ssl.database.IDataAccessObject;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.Condominium;

@Component
@Repository
public class CondominiumDao implements ICondominiumDao
{

    private static final Logger log = LoggerFactory.getLogger(CondominiumDao.class);

    @Autowired
    private IDataAccessObject<Condominium> condDataAcessObject;

    @PostConstruct
    public void initCondominiumDao()
    {
        log.debug("Initializing generic repository access");
        this.condDataAcessObject.setClassType(Condominium.class);
        log.debug("Generic repository initialized with entity :" + Condominium.class.getName());
    }

    @Override
    public void addCondominium(Condominium condominium)
    {
        this.condDataAcessObject.addEntity(condominium);
    }

    @Override
    public void removeCondominium(Condominium condominium)
    {
        this.condDataAcessObject.removeEntity(condominium);
    }

    @Override
    public void removeCondominiumById(int condominiumId)
    {
        this.condDataAcessObject.removeEntityById(condominiumId);
    }

    @Override
    public void removeCondominiumByName(String name)
    {
        this.condDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.NAME, name);
    }

    @Override
    public Condominium updateCondominium(Condominium condominium)
    {
        return this.condDataAcessObject.updateEntity(condominium);
    }

    @Override
    public Condominium getCondominiumById(int id)
    {
        return this.condDataAcessObject.getEntityById(id);
    }

    @Override
    public Condominium getCondominiumByName(String name)
    {
        return this.condDataAcessObject.getEntityByEntityColumn(DataBaseColumnQuerysConstants.NAME, name);
    }

    @Override
    public List<Condominium> getAllCondominiums()
    {
        return this.condDataAcessObject.getAllEntities();
    }

}

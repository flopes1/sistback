package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IDataAccessObject;
import com.ssl.database.IVisitorDao;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.Visitor;

@Component
@Repository
public class VisitorDao implements IVisitorDao
{

    private static final Logger log = LoggerFactory.getLogger(VisitorDao.class);

    @Autowired
    private IDataAccessObject<Visitor> visitorDataAcessObject;

    @PostConstruct
    public void initVisitorDao()
    {
        log.debug("Initializing generic repository access");
        this.visitorDataAcessObject.setClassType(Visitor.class);
        log.debug("Generic repository initialized with entity :" + Visitor.class.getName());
    }

    @Override
    public void addVisitor(Visitor visitor)
    {
        this.visitorDataAcessObject.addEntity(visitor);
    }

    @Override
    public Visitor getVisitorById(int id)
    {
        return this.visitorDataAcessObject.getEntityById(id);
    }

    @Override
    public List<Visitor> getCondominiumVisitorsList(int condiminiumId)
    {
        return this.visitorDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.CONDOMINIUM,
                condiminiumId);
    }

    @Override
    public Visitor updateVisitor(Visitor visitor)
    {
        return this.visitorDataAcessObject.updateEntity(visitor);
    }

    @Override
    public void removeVisitor(Visitor visitor)
    {
        this.visitorDataAcessObject.removeEntity(visitor);
    }

    @Override
    public void removeVisitorByCondominiumId(int condominiumId)
    {
        this.visitorDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.CONDOMINIUM, condominiumId);
    }

}

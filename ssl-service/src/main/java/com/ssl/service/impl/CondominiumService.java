package com.ssl.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.ICondominiumService;
import com.ssl.database.ICondominiumAddressDao;
import com.ssl.database.ICondominiumDao;
import com.ssl.database.IPhoneNumberCondominiumDao;
import com.ssl.entities.Condominium;

@Service
@Component
@Transactional
public class CondominiumService implements ICondominiumService
{

    private static final Logger log = LoggerFactory.getLogger(CondominiumService.class);

    @Autowired
    private ICondominiumDao condominiumDao;

    @Autowired
    private ICondominiumAddressDao condominiumAddressDao;

    @Autowired
    private IPhoneNumberCondominiumDao phoneNumberCondiminiumDao;

    @Override
    public void addCondominium(Condominium condominium)
    {
        this.condominiumDao.addCondominium(condominium);
    }

    @Override
    public void removeCondominium(Condominium condominium)
    {
        this.condominiumDao.removeCondominium(condominium);
    }

    @Override
    public void removeCondominiumById(int condominiumId)
    {
        this.condominiumDao.removeCondominiumById(condominiumId);
    }

    @Override
    public void removeCondominiumByName(String name)
    {
        this.condominiumDao.removeCondominiumByName(name);
    }

    @Override
    public Condominium updateCondominium(Condominium condominium)
    {
        return this.condominiumDao.updateCondominium(condominium);
    }

    @Override
    public Condominium getCondominiumById(int id)
    {
        return this.condominiumDao.getCondominiumById(id);
    }

    @Override
    public Condominium getCondominiumByName(String name)
    {
        return this.condominiumDao.getCondominiumByName(name);
    }

    @Override
    public List<Condominium> getAllCondominiums()
    {
        return this.condominiumDao.getAllCondominiums();
    }

}

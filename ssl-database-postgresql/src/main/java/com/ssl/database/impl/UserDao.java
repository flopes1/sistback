package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IDataAccessObject;
import com.ssl.database.IUserDao;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.Userr;

@Component
@Repository
public class UserDao implements IUserDao
{

    private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private IDataAccessObject<Userr> userDataAcessObject;

    @PostConstruct
    public void initUserDao()
    {
        log.debug("Initializing generic repository access");
        this.userDataAcessObject.setClassType(Userr.class);
        log.debug("Generic repository initialized with entity :" + Userr.class.getName());
    }

    @Override
    public void addUser(Userr user)
    {
        this.userDataAcessObject.addEntity(user);
    }

    @Override
    public Userr getUserById(int userId)
    {
        return this.userDataAcessObject.getEntityById(userId);
    }

    @Override
    public Userr getUserByCpf(String cpf)
    {
        return this.userDataAcessObject.getEntityByEntityColumn(DataBaseColumnQuerysConstants.CPF, cpf);
    }

    @Override
    public List<Userr> getUserByCondominiumId(int condId)
    {
        return this.userDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.CONDOMINIUM, condId);
    }

    @Override
    public List<Userr> getUserFromApartment(String apartIdentifier)
    {
        return this.userDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.APARTAMENT,
                apartIdentifier);
    }

    @Override
    public Userr updateUser(Userr user)
    {
        return this.userDataAcessObject.updateEntity(user);
    }

    @Override
    public void removeUser(Userr user)
    {
        this.userDataAcessObject.removeEntity(user);
    }

    @Override
    public void removeUserById(int userId)
    {
        this.userDataAcessObject.removeEntityById(userId);
    }

    @Override
    public void removeUserByCpf(String cpf)
    {
        this.userDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.CPF, cpf);
    }

    @Override
    public Userr getUserByEmail(String userEmail)
    {
        return this.userDataAcessObject.getEntityByEntityColumn(DataBaseColumnQuerysConstants.EMAIL, userEmail);
    }

}

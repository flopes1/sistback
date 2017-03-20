package com.ssl.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.IUserService;
import com.ssl.database.IPhoneNumberUserDao;
import com.ssl.database.IUserDao;
import com.ssl.database.IVehicleDao;
import com.ssl.entities.Userr;

@Service
@Component
@Transactional
public class UserService implements IUserService
{
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IPhoneNumberUserDao phoneNumberUserDao;

    @Autowired
    private IVehicleDao vehicleDao;

    @Override
    public boolean recoveryPass(Userr user)
    {
        log.debug("Recovering user with e-mail: " + user.getEmail() + " password");

        Userr userReturned = this.userDao.getUserByEmail(user.getEmail());

        boolean recoveredPass = true;

        if (userReturned != null)
        {
            String newPassword = "";

            log.debug("Sending user new password to e-mail: " + user.getEmail());

            // TODO fazer servico para enviar email com senha autogerada

            log.debug("New password sent to e-mail: " + user.getEmail() + " with success");

            userReturned.setPassword(newPassword);

            this.updateUser(userReturned);
        }
        else
        {
            recoveredPass = false;
            log.debug("User with e-mail: " + user.getEmail() + " not found");
        }

        return recoveredPass;
    }

    @Override
    public Userr login(Userr user)
    {
        log.debug("Trying to login user with e-mail: " + user.getEmail());

        Userr userReturned = this.userDao.getUserByEmail(user.getEmail());

        boolean isValidLogin = true;

        if (userReturned != null)
        {
            String pass = userReturned.getPassword();
            String inputPass = user.getPassword();

            isValidLogin = pass.equals(inputPass);
        }
        else
        {
            log.debug("Login failed! User with e-mail: " + user.getEmail() + " not found");
        }

        if (!isValidLogin)
        {
            userReturned = null;
        }

        return userReturned;
    }

    @Override
    public void addUser(Userr user)
    {
        this.userDao.addUser(user);
    }

    @Override
    public Userr getUserById(int userId)
    {
        return this.userDao.getUserById(userId);
    }

    @Override
    public Userr getUserByCpf(String cpf)
    {
        return this.userDao.getUserByCpf(cpf);
    }

    @Override
    public List<Userr> getUserByCondominiumId(int condominiumId)
    {
        return this.userDao.getUserByCondominiumId(condominiumId);
    }

    @Override
    public List<Userr> getUserFromApartment(String apartIdentifier)
    {
        return this.userDao.getUserFromApartment(apartIdentifier);
    }

    @Override
    public Userr updateUser(Userr user)
    {
        return this.userDao.updateUser(user);
    }

    @Override
    public void removeUser(Userr user)
    {
        this.userDao.removeUser(user);
    }

    @Override
    public void removeUserById(int userId)
    {
        this.userDao.removeUserById(userId);
    }

    @Override
    public void removeUserByCpf(String cpf)
    {
        this.userDao.removeUserByCpf(cpf);
    }
}

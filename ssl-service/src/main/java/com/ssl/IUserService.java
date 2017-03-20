package com.ssl;

import java.util.List;

import com.ssl.entities.Userr;

public interface IUserService
{

    void addUser(Userr user);

    Userr getUserById(int userId);

    Userr getUserByCpf(String cpf);

    List<Userr> getUserByCondominiumId(int condominiumId);

    List<Userr> getUserFromApartment(String apartIdentifier);

    Userr updateUser(Userr user);

    void removeUser(Userr user);

    void removeUserById(int userId);

    void removeUserByCpf(String cpf);

    Userr login(Userr user);

    boolean recoveryPass(Userr user);

}

package com.ssl.database;

import java.util.List;

import com.ssl.entities.Userr;

public interface IUserDao
{

    void addUser(Userr user);

    Userr getUserById(int userId);

    Userr getUserByCpf(String cpf);

    List<Userr> getUserByCondominiumId(int condId);

    List<Userr> getUserFromApartment(String apartIdentifier);

    Userr updateUser(Userr user);

    void removeUser(Userr user);

    void removeUserById(int userId);

    void removeUserByCpf(String cpf);

    Userr getUserByEmail(String userEmail);

}

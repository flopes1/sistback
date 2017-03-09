package com.ssl.database;

import java.util.List;

import com.ssl.entities.Condominium;

public interface ICondominiumDao
{

    void addCondominium(Condominium condominium);

    void removeCondominium(Condominium condominium);

    void removeCondominiumById(int condominiumId);

    void removeCondominiumByName(String name);

    Condominium updateCondominium(Condominium condominium);

    Condominium getCondominiumById(int id);

    Condominium getCondominiumByName(String name);

    List<Condominium> getAllCondominiums();

}

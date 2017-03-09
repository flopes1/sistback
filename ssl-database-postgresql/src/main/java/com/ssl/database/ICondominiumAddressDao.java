package com.ssl.database;

import com.ssl.entities.CondominiumAddress;

public interface ICondominiumAddressDao
{

    void addCondominiumAddress(CondominiumAddress address);

    CondominiumAddress getCondominiumAddressById(int id);

    CondominiumAddress getCondominiumAddressByCondominiumId(int CondId);

    CondominiumAddress updateCondominiumAddress(CondominiumAddress address);

    void removeCondominiumAddress(CondominiumAddress address);

    void removeCondominiumAddressById(int id);

    void removeCondominiumAddressByCondominiumId(int id);

}

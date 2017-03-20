package com.ssl.database;

import java.util.List;

import com.ssl.entities.PhoneNumberCondominium;

public interface IPhoneNumberCondominiumDao
{

    void addPhoneNumber(PhoneNumberCondominium number);

    List<PhoneNumberCondominium> getNumberByOwnerId(int id);

    PhoneNumberCondominium updateNumber(PhoneNumberCondominium number);

    void removeNumber(PhoneNumberCondominium number);

    void removeNumberByOwnerId(int id);

}

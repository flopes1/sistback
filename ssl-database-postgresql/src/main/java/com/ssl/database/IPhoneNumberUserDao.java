package com.ssl.database;

import java.util.List;

import com.ssl.entities.PhoneNumberUserr;

public interface IPhoneNumberUserDao
{

    void addPhoneNumber(PhoneNumberUserr number);

    List<PhoneNumberUserr> getNumberByOwnerId(int id);

    PhoneNumberUserr updateNumber(PhoneNumberUserr number);

    void removeNumber(PhoneNumberUserr number);

    void removeNumberByOwnerId(int id);

}

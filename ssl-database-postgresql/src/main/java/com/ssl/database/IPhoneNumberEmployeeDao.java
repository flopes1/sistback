package com.ssl.database;

import java.util.List;

import com.ssl.entities.PhoneNumberEmployee;

public interface IPhoneNumberEmployeeDao
{

    void addPhoneNumber(PhoneNumberEmployee number);

    List<PhoneNumberEmployee> getNumberByOwnerId(int id);

    PhoneNumberEmployee updateNumber(PhoneNumberEmployee number);

    void removeNumber(PhoneNumberEmployee number);

    void removeNumberByOwnerId(int id);

}

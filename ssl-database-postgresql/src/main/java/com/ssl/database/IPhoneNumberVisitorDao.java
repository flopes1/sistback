package com.ssl.database;

import java.util.List;

import com.ssl.entities.PhoneNumberVisitor;

public interface IPhoneNumberVisitorDao
{

    void addPhoneNumber(PhoneNumberVisitor number);

    List<PhoneNumberVisitor> getNumberByOwnerId(int id);

    PhoneNumberVisitor updateNumber(PhoneNumberVisitor number);

    void removeNumber(PhoneNumberVisitor number);

    void removeNumberByOwnerId(int id);

}

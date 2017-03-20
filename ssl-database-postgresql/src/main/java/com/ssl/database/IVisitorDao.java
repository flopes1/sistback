package com.ssl.database;

import java.util.List;

import com.ssl.entities.Visitor;

public interface IVisitorDao
{

    void addVisitor(Visitor visitor);

    Visitor getVisitorById(int id);

    List<Visitor> getCondominiumVisitorsList(int condiminiumId);

    Visitor updateVisitor(Visitor visitor);

    void removeVisitor(Visitor visitor);

    void removeVisitorByCondominiumId(int condominiumId);

}

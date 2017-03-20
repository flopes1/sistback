package com.ssl.database;

import java.util.List;

import com.ssl.entities.AutenticationHistory;

public interface IAutenticationHistoryDao
{

    void addAutenticationHistory(AutenticationHistory autenticationHistory);

    AutenticationHistory getAutenticationHistoryById(int id);

    List<AutenticationHistory> getAutenticationHistoryByCondominiumId(int condominiumId);

    List<AutenticationHistory> getAutenticationHistoryByEmployeId(int employeeId);

    List<AutenticationHistory> getAutenticationHistoryByUserId(int userId);

    AutenticationHistory updateAutenticationHistory(AutenticationHistory autenticationHistory);

    void removeAutenticationHistory(AutenticationHistory autenticationHistory);

    void removeAutenticationHistoryById(int id);

}

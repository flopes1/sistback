package com.ssl.database;

import java.util.List;

import com.ssl.entities.ScheduledVisit;

public interface IScheduledVisitDao
{

    void addScheduledVisit(ScheduledVisit visit);

    ScheduledVisit getScheduledVisitById(int id);

    List<ScheduledVisit> getScheduledVisitByCondominium(int condominiumId);

    ScheduledVisit updateScheduledVisit(ScheduledVisit visit);

    void removeScheduledVisit(ScheduledVisit visit);

    void removeScheduledVisitById(int id);

    void removeScheduledVisitByCondominium(int condominiumId);

}

package com.ssl.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.IAutenticationHistoryService;
import com.ssl.database.IAutenticationHistoryDao;
import com.ssl.entities.AutenticationHistory;

@Service
@Component
@Transactional
public class AutenticationHistoryService implements IAutenticationHistoryService
{

    private static final Logger log = LoggerFactory.getLogger(AutenticationHistoryService.class);

    @Autowired
    private IAutenticationHistoryDao autenticationhistoryDao;

    @Override
    public void addAutenticationHistory(AutenticationHistory autenticationHistory)
    {
        this.autenticationhistoryDao.addAutenticationHistory(autenticationHistory);
    }

    @Override
    public AutenticationHistory getAutenticationHistoryById(int id)
    {
        return this.autenticationhistoryDao.getAutenticationHistoryById(id);
    }

    @Override
    public List<AutenticationHistory> getAutenticationHistoryByCondominiumId(int condominiumId)
    {
        return this.autenticationhistoryDao.getAutenticationHistoryByCondominiumId(condominiumId);
    }

    @Override
    public List<AutenticationHistory> getAutenticationHistoryByEmployeId(int employeeId)
    {
        return this.autenticationhistoryDao.getAutenticationHistoryByEmployeId(employeeId);
    }

    @Override
    public List<AutenticationHistory> getAutenticationHistoryByUserId(int userId)
    {
        return this.autenticationhistoryDao.getAutenticationHistoryByUserId(userId);
    }

    @Override
    public AutenticationHistory updateAutenticationHistory(AutenticationHistory autenticationHistory)
    {
        return this.autenticationhistoryDao.updateAutenticationHistory(autenticationHistory);
    }

    @Override
    public void removeAutenticationHistory(AutenticationHistory autenticationHistory)
    {
        this.autenticationhistoryDao.removeAutenticationHistory(autenticationHistory);
    }

    @Override
    public void removeAutenticationHistoryById(int id)
    {
        this.autenticationhistoryDao.removeAutenticationHistoryById(id);
    }

}

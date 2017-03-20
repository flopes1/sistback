package com.ssl.database.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssl.database.IDataAccessObject;
import com.ssl.database.IEmployeeDao;
import com.ssl.database.util.DataBaseColumnQuerysConstants;
import com.ssl.entities.Employee;

@Component
@Repository
public class EmployeeDao implements IEmployeeDao
{

    private static final Logger log = LoggerFactory.getLogger(EmployeeDao.class);

    @Autowired
    private IDataAccessObject<Employee> employeeDataAcessObject;

    @PostConstruct
    public void initEmployeeDao()
    {
        log.debug("Initializing generic repository access");
        this.employeeDataAcessObject.setClassType(Employee.class);
        log.debug("Generic repository initialized with entity :" + Employee.class.getName());
    }

    @Override
    public void addEmployee(Employee employee)
    {
        this.employeeDataAcessObject.addEntity(employee);
    }

    @Override
    public Employee getEmployeeById(int id)
    {
        return this.employeeDataAcessObject.getEntityById(id);
    }

    @Override
    public List<Employee> getCondominiumEmployes(int condId)
    {
        return this.employeeDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.CONDOMINIUM,
                condId);
    }

    @Override
    public List<Employee> getLocalAdmEmployeeList()
    {
        return this.employeeDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.EMPLOYEE_LOCAL_ADM,
                true);
    }

    @Override
    public List<Employee> getSystemAdmEmployeList()
    {
        return this.employeeDataAcessObject.getEntitiesByEntityColumn(DataBaseColumnQuerysConstants.EMPLOYEE_SYSTEM_ADM,
                true);
    }

    @Override
    public Employee updateEmployee(Employee employee)
    {
        return this.employeeDataAcessObject.updateEntity(employee);
    }

    @Override
    public void removeEmployee(Employee employee)
    {
        this.employeeDataAcessObject.removeEntity(employee);
    }

    @Override
    public void removeEmployeeById(int id)
    {
        this.employeeDataAcessObject.removeEntityById(id);
    }

    @Override
    public void removeEmployeeByCondominium(int condId)
    {
        this.employeeDataAcessObject.removeEntityByColumn(DataBaseColumnQuerysConstants.CONDOMINIUM, condId);
    }

    @Override
    public Employee getEmployeeByEmail(String email)
    {
        return this.employeeDataAcessObject.getEntityByEntityColumn(DataBaseColumnQuerysConstants.EMAIL, email);
    }

}

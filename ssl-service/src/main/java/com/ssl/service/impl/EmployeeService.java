package com.ssl.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.IEmployeeService;
import com.ssl.database.IEmployeeDao;
import com.ssl.database.IPhoneNumberEmployeeDao;
import com.ssl.entities.Employee;

@Service
@Component
@Transactional
public class EmployeeService implements IEmployeeService
{

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private IEmployeeDao employeeDao;

    @Autowired
    private IPhoneNumberEmployeeDao phoneNumberEmployeeDao;

    @Override
    public boolean recoveryPass(Employee employee)
    {
        log.debug("Recovering employee with e-mail: " + employee.getEmail() + " password");

        Employee employeeReturned = this.employeeDao.getEmployeeByEmail(employee.getEmail());

        boolean recoveredPass = true;

        if (employeeReturned != null)
        {
            String newPassword = "";

            log.debug("Sending employee new password to e-mail: " + employee.getEmail());

            // TODO fazer servico para enviar email com senha autogerada

            log.debug("New password sent to e-mail: " + employee.getEmail() + " with success");

            employeeReturned.setPassword(newPassword);

            this.updateEmployee(employeeReturned);
        }
        else
        {
            recoveredPass = false;
            log.debug("Employee with e-mail: " + employee.getEmail() + " not found");
        }

        return recoveredPass;
    }

    @Override
    public Employee login(Employee employee)
    {
        log.debug("Trying to login employee with e-mail: " + employee.getEmail());

        Employee employeeReturned = this.employeeDao.getEmployeeByEmail(employee.getEmail());

        boolean isValidLogin = true;

        if (employeeReturned != null)
        {
            String pass = employeeReturned.getPassword();
            String inputPass = employee.getPassword();

            isValidLogin = pass.equals(inputPass);
        }
        else
        {
            log.debug("Login failed! Employee with e-mail: " + employee.getEmail() + " not found");
        }

        if (!isValidLogin)
        {
            employeeReturned = null;
        }

        return employeeReturned;
    }

    @Override
    public void addEmployee(Employee employee)
    {
        this.employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int id)
    {
        return this.employeeDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> getCondominiumEmployes(int condId)
    {
        return this.employeeDao.getCondominiumEmployes(condId);
    }

    @Override
    public List<Employee> getLocalAdmEmployeeList()
    {
        return this.employeeDao.getLocalAdmEmployeeList();
    }

    @Override
    public List<Employee> getSystemAdmEmployeList()
    {
        return this.employeeDao.getSystemAdmEmployeList();
    }

    @Override
    public Employee updateEmployee(Employee employee)
    {
        return this.employeeDao.updateEmployee(employee);
    }

    @Override
    public void removeEmployee(Employee employee)
    {
        this.employeeDao.removeEmployee(employee);
    }

    @Override
    public void removeEmployeeById(int id)
    {
        this.employeeDao.removeEmployeeById(id);
    }

    @Override
    public void removeEmployeeByCondominium(int condId)
    {
        this.employeeDao.removeEmployeeByCondominium(condId);
    }

}

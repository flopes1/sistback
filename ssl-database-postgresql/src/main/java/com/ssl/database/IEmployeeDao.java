package com.ssl.database;

import java.util.List;

import com.ssl.entities.Employee;

public interface IEmployeeDao
{

    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getCondominiumEmployes(int condId);

    List<Employee> getLocalAdmEmployeeList();

    List<Employee> getSystemAdmEmployeList();

    Employee updateEmployee(Employee employee);

    void removeEmployee(Employee employee);

    void removeEmployeeById(int id);

    void removeEmployeeByCondominium(int condId);

    Employee getEmployeeByEmail(String email);

}

package com.ssl.test.database;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.config.HibernateConfig;
import com.ssl.database.IEmployeeDao;
import com.ssl.entities.Condominium;
import com.ssl.entities.Employee;
import com.ssl.entities.PhoneNumberEmployee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
    { HibernateConfig.class })
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeDaoTest
{
    // TODO Configurar o teste para zerar o banco a cada @Test, da forma que está os testes só
    // funcionam na primeira vez em que são executados
    
    @Autowired
    private IEmployeeDao empDAO;

    @Test
    public void test()
    {
        fail("Not yet implemented");
    }
    
    private Set<Employee> getMockemployees(Condominium condominium)
    {
        Set<Employee> employees = new HashSet<>();

        for (int i = 0; i < 5; i++)
        {
            Employee employee = new Employee();
            employee.setName("Funcionário" + i);
            employee.setCpf("00000000000" + i);
            employee.setEmail("Email" + i);
            employee.setLocalAdm(i % 2 == 0);
            employee.setSystemAdm(i % 2 != 0);
            employee.setPhoneNumberEmployees(this.getMockEmployeePhoneNumber(employee));
            employee.setCondominium(condominium);

            employees.add(employee);
        }

        return employees;
    }

    private Set<PhoneNumberEmployee> getMockEmployeePhoneNumber(Employee employee)
    {
        Set<PhoneNumberEmployee> numbers = new HashSet<>();

        for (int i = 0; i < 2; i++)
        {
            PhoneNumberEmployee ph = new PhoneNumberEmployee();
            ph.setCountryCode((short) 55);
            ph.setStateCode((short) 81);
            ph.setNumber(7777777);
            ph.setEmployee(employee);

            numbers.add(ph);
        }

        return numbers;
    }

}

package pro.sky.java.course2.hw27.services;


import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee addEmployee(String firstName, String lastName, String department, int salary);


    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String key) throws EmployeeNotFoundException;

    Map<String, Employee> getMap();
    Collection<Employee> getAllEmployee();
}

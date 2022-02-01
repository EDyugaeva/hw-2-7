package pro.sky.java.course2.hw27.services;


import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.exceptions.EmployeeNotFoundException;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, String passportNum);

    Employee removeEmployee(String firstName, String lastName, String passportNum);

    Employee findEmployee(String passportNum) throws EmployeeNotFoundException;

    Map<String, Employee> getMap();
}

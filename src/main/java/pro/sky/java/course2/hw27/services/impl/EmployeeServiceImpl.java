package pro.sky.java.course2.hw27.services.impl;

import org.springframework.stereotype.Service;

import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.exceptions.EmployeeExistException;
import pro.sky.java.course2.hw27.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.hw27.services.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }



    public Employee addEmployee(String firstName, String lastName, String passportNum) {
        Employee addedEmployee = new Employee(firstName, lastName);
        if (employees.containsKey(passportNum)) {
            throw new EmployeeExistException("Сотрудник уже добавлен");
        }
        employees.put(passportNum, addedEmployee);
        return addedEmployee;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName, String passportNum) {
        Employee removedEmployee = new Employee(firstName, lastName);
        if (!employees.containsKey(passportNum)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.remove(passportNum, removedEmployee);
        return removedEmployee;
    }


    @Override
    public Employee findEmployee(String passportNum) throws EmployeeNotFoundException {
        if (!employees.containsKey(passportNum)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
            return employees.get(passportNum);

    }

    @Override
    public Map<String, Employee> getMap() {
        return employees;
    }


}



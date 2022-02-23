package pro.sky.java.course2.hw27.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.exceptions.EmployeeExistException;
import pro.sky.java.course2.hw27.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.hw27.exceptions.WrongTypeOfNameException;
import pro.sky.java.course2.hw27.services.EmployeeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }


    public Employee addEmployee(String firstName, String lastName) {
        checkWrongName(firstName,lastName);
        Employee addedEmployee = new Employee(StringUtils.capitalize(StringUtils.lowerCase(firstName)), StringUtils.capitalize(StringUtils.lowerCase(lastName)));
        if (employees.containsKey(addedEmployee.getKey())) {
            throw new EmployeeExistException("Сотрудник уже добавлен");
        }
        employees.put(addedEmployee.getKey(), addedEmployee);
        return addedEmployee;
    }

    public Employee addEmployee(String firstName, String lastName, String department, int salary) {
        checkWrongName(firstName,lastName);
        Employee addedEmployee = new Employee(StringUtils.capitalize(StringUtils.lowerCase(firstName)), StringUtils.capitalize(StringUtils.lowerCase(lastName)),department,salary);
        if (employees.containsKey(addedEmployee.getKey())) {
            throw new EmployeeExistException("Сотрудник уже добавлен");
        }
        employees.put(addedEmployee.getKey(), addedEmployee);
        return addedEmployee;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.remove(firstName + lastName);
    }


    @Override
    public Employee findEmployee(String key) throws EmployeeNotFoundException {
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.get(key);

    }

    @Override
    public Map<String, Employee> getMap() {
        return employees;
    }

    public Collection<Employee> getAllEmployee() {
        return employees.values();
    }

    private void checkWrongName(String firstName, String lastName) {
        String chars = "123456789!@#$%^&*()-=,./;'[]{} ";
        if (StringUtils.containsAny(firstName, chars)||StringUtils.containsAny(lastName, chars)) {
            throw new WrongTypeOfNameException("Имя сотрудника задано неверно");
        }

    }







}



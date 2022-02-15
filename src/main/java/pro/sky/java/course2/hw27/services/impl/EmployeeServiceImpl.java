package pro.sky.java.course2.hw27.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.exceptions.EmployeeExistException;
import pro.sky.java.course2.hw27.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.hw27.exceptions.WrongTypeOfName;
import pro.sky.java.course2.hw27.services.EmployeeService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }


    public Employee addEmployee(String firstName, String lastName, String passportNum) {
        if (employees.containsKey(passportNum)) {
            throw new EmployeeExistException("Сотрудник уже добавлен");
        }
        checkWrongName(firstName,lastName);
        Employee addedEmployee = new Employee(StringUtils.capitalize(StringUtils.lowerCase(firstName)), StringUtils.capitalize(StringUtils.lowerCase(lastName)));
        employees.put(passportNum, addedEmployee);
        return addedEmployee;
    }

    public Employee addEmployee(String firstName, String lastName, String passportNum, String department, int salary) {
        if (employees.containsKey(passportNum)) {
            throw new EmployeeExistException("Сотрудник уже добавлен");
        }
        checkWrongName(firstName,lastName);
        Employee addedEmployee = new Employee(StringUtils.capitalize(StringUtils.lowerCase(firstName)), StringUtils.capitalize(StringUtils.lowerCase(lastName)),department,salary);
        employees.put(passportNum, addedEmployee);
        return addedEmployee;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName, String passportNum) {
        if (!employees.containsKey(passportNum)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.remove(passportNum);
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

    public Set<Employee> getAllEmployee() {
        return (Set<Employee>) employees.values();
    }

    private void checkWrongName(String firstName, String lastName) {
        String chars = "123456789!@#$%^&*()-=,./;'[]{} ";
        if (StringUtils.containsAny(firstName, chars)||StringUtils.containsAny(lastName, chars)) {
            throw new WrongTypeOfName("Имя сотрудника задано неверно");
        }

    }







}



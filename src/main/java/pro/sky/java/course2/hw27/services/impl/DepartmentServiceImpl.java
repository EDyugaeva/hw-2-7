package pro.sky.java.course2.hw27.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.hw27.services.DepartmentService;
import pro.sky.java.course2.hw27.services.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee findEmployeeWithMaxSalaryByDepartmentId(String department) {

        return employeeService.getAllEmployee().stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудников нет"));
    }

    public Employee findEmployeeWithMinSalaryByDepartmentId(String department) {
        return employeeService.getAllEmployee().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .min(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудников нет"));
    }

    @Override
    public Set<Employee> findAllEmployeesInDepartment(String department) {
        Set<Employee> result;
        result = employeeService.getAllEmployee().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toSet());
        if (result.isEmpty()) {
            throw new EmployeeNotFoundException("Сотрудников в данном отделе нет");
        }
        return result;
    }

    @Override
    public Map<String, List<Employee>> findEmployees() {
        return employeeService.getAllEmployee().stream().
                collect(Collectors.groupingBy(Employee::getDepartment));

    }
}

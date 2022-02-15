package pro.sky.java.course2.hw27.services;


import pro.sky.java.course2.hw27.data.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalaryByDepartmentId(String departmentId);
    Employee findEmployeeWithMinSalaryByDepartmentId(String departmentId);
    Set<Employee> findAllEmployeesInDepartment(String departmentId);
    Map<String, List<Employee>> findEmployees();


}

package pro.sky.java.course2.hw27.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.services.DepartmentService;


import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService)       {
        this.departmentService = departmentService;
    }

    @GetMapping (path= "/max-salary")
    public Employee findEmployeeWithMaxSalaryInDepartment(@RequestParam("departmentId") String department) {
        return departmentService.findEmployeeWithMaxSalaryByDepartmentId(department);

    }

    @GetMapping (path= "/min-salary")
    public Employee findEmployeeWithMinSalaryInDepartment(@RequestParam("departmentId") String department) {
        return departmentService.findEmployeeWithMinSalaryByDepartmentId(department);

    }
    @GetMapping (path= "/all", params = "departmentId")
    public Set<Employee> findAllEmployeeInDepartment(@RequestParam("departmentId") String department) {
        return departmentService.findAllEmployeesInDepartment(department);

    }

    @GetMapping ( path="/all")
    public Map<String, List<Employee>> findEmployee() {
        return departmentService.findEmployees();

    }




}

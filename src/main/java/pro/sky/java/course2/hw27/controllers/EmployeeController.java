package pro.sky.java.course2.hw27.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.services.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeServiceCollection) {
        this.employeeService = employeeServiceCollection;
    }

    @GetMapping(path = "/add", params = {"department", "firstName","lastName", "salary"})
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") String department,
                                @RequestParam("salary") int salary) {
        return employeeService.addEmployee(firstName, lastName, department,salary);

    }
    @GetMapping(path = "/add", params = {"firstName","lastName"})
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/get")
    public Map<String, Employee> getSet() {
        return employeeService.getMap();

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("key") String passportNum) {
        return employeeService.findEmployee(passportNum);
    }


}

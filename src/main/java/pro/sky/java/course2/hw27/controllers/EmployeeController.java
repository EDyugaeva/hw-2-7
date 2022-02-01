package pro.sky.java.course2.hw27.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("passportNum") String passportNum) {
        return employeeService.addEmployee(firstName, lastName, passportNum);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("passportNum") String passportNum) {
        return employeeService.removeEmployee(firstName, lastName, passportNum);
    }

    @GetMapping("/get")
    public Map<String, Employee> getSet() {
        return employeeService.getMap();

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("passportNum") String passportNum) {
        return employeeService.findEmployee(passportNum);
    }


}

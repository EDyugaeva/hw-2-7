package pro.sky.java.course2.hw27.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.exceptions.EmployeeExistException;
import pro.sky.java.course2.hw27.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.hw27.exceptions.WrongTypeOfNameException;
import pro.sky.java.course2.hw27.services.impl.EmployeeServiceImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {
    private final EmployeeService out = new EmployeeServiceImpl();
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;


    @BeforeEach
    public void getSet() {
        employee1 = new Employee("Иван", "Иванов","1",40_500);
        employee2 = new Employee("Алина", "Иванова","2",40_500);
        employee3 = new Employee("Сергей", "Петров","1",50_500);

        out.addEmployee("ИвАн", "иванов", "1", 40_500);
        out.addEmployee("алина", "иванова", "2", 40_500);
        out.addEmployee("Сергей", "Петров", "1", 50_500);


    }
@Test
    public void testAddEmployee() {
        Map<String, Employee> actual = new HashMap<>();
        Map<String, Employee> expected = out.getMap();

        actual.put("ИванИванов", employee1);
        actual.put("АлинаИванова", employee2);
        actual.put("СергейПетров", employee3);

        assertEquals(expected, actual);

    Assertions.assertThrows(EmployeeExistException.class,
            () -> out.addEmployee("Иван", "Иванов", "1", 42_500));

    Assertions.assertThrows(WrongTypeOfNameException.class,
            () -> out.addEmployee("Иван123456", "Иванов", "1", 42_500));

    }

    @Test
    public void testAddEmployeeWithoutSalaryAndDepartment() {
        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.addEmployee("Иван", "Иванов");
        employeeService.addEmployee("алина", "иваноВА");
        employeeService.addEmployee("сергей", "петров");


        Map<String, Employee> actual = new HashMap<>();
        Map<String, Employee> expected = employeeService.getMap();

        actual.put("ИванИванов", new Employee("Иван", "Иванов"));
        actual.put("АлинаИванова", new Employee("Алина", "Иванова"));
        actual.put("СергейПетров", new Employee("Сергей", "Петров"));

        assertEquals(expected, actual);

        Assertions.assertThrows(EmployeeExistException.class,
                () -> out.addEmployee("Иван", "Иванов"));

        Assertions.assertThrows(WrongTypeOfNameException.class,
                () -> out.addEmployee("Иван123456", "Иванов"));

    }
@Test
    public void testRemoveEmployee() {
        Map<String, Employee> actual = new HashMap<>();
        Map<String, Employee> expected = out.getMap();

        out.removeEmployee("Сергей", "Петров");

        actual.put("ИванИванов", employee1);
        actual.put("АлинаИванова", employee2);

        assertEquals(expected, actual);

        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee("Сергей", "Петров"));

    }

    @Test
    public void testFindEmployee() {
        assertEquals(out.findEmployee("СергейПетров"), employee3);

        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee("Сергей", "Носков"));


    }



    }

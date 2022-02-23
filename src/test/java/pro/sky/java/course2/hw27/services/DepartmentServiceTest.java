package pro.sky.java.course2.hw27.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.hw27.services.impl.DepartmentServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeServiceMock;

    private DepartmentService out;

    @BeforeEach
    public void iniOut() {
        out = new DepartmentServiceImpl(employeeServiceMock);
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee("Иван", "Иванов", "5", 50_000));
        employees.add(new Employee("Алла", "Макаронина", "5", 40_000));
        employees.add(new Employee("Ирина", "Воробьева", "2", 50_000));
        employees.add(new Employee("Александр", "Плющев", "2", 60_000));

        Mockito.when(employeeServiceMock.getAllEmployee()).thenReturn(employees);


    }

    @Test
    public void testFindEmployeeWithMaxSalaryByDepartmentId() {

        assertEquals(out.findEmployeeWithMaxSalaryByDepartmentId("5"), new Employee("Иван", "Иванов", "5", 50_000));

        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId("3"));
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId(""));


    }

    @Test
    public void testFindEmployeeWithMinSalaryByDepartmentId() {

        assertEquals(out.findEmployeeWithMinSalaryByDepartmentId("5"), new Employee("Алла", "Макаронина", "5", 40_000));

        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId("3"));
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId(""));


    }

    @Test
    public void testFindAllEmployeesInDepartment() {
        Set<Employee> actual = new HashSet<>();
        actual.add(new Employee("Ирина", "Воробьева", "2", 50_000));
        actual.add(new Employee("Александр", "Плющев", "2", 60_000));

        assertEquals(out.findAllEmployeesInDepartment("2"), actual);

        assertThrows(EmployeeNotFoundException.class, () -> out.findAllEmployeesInDepartment("0"));


    }

    @Test
    public void testFindAllEmployees() {
        List<Employee> listDepartment2 = new ArrayList<>();
        List<Employee> listDepartment5 = new ArrayList<>();

        listDepartment2.add(new Employee("Александр", "Плющев", "2", 60_000));
        listDepartment2.add(new Employee("Ирина", "Воробьева", "2", 50_000));
        listDepartment5.add(new Employee("Алла", "Макаронина", "5", 40_000));
        listDepartment5.add(new Employee("Иван", "Иванов", "5", 50_000));

        Map<String, List<Employee>> actual = new HashMap<>();
        actual.put("5", listDepartment5);
        actual.put("2", listDepartment2);

        assertEquals(out.findEmployees(), actual);

    }


}

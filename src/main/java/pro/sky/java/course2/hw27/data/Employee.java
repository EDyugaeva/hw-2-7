package pro.sky.java.course2.hw27.data;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String department;
    private final int salary;
    private final String key;

    public Employee(String firstName, String lastName, String department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.key = firstName + lastName;
    }

    public Employee(String firstName, String lastName) {
        this(firstName,lastName,"No department", 0);

    }

    public String getKey() {
        return key;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(department, employee.department) && Objects.equals(key, employee.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary, key);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

package com.othr.ajp.serialization;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Employee extends Person {
    private int employeeId;
    private String department;
    private BigDecimal salaryPerYear;
    private EmployeeStatus status;


    public Employee(String[] firstnames, String lastname, String socialSecurityNumber, Date dateOfBirth, Color eyeColor, Address currentAddress, List<Address> formerAdresses,
                    int employeeId, String department, BigDecimal salaryPerYear, EmployeeStatus status) {
        super(firstnames, lastname, socialSecurityNumber, dateOfBirth, eyeColor, currentAddress, formerAdresses);
        this.employeeId = employeeId;
        this.department = department;
        this.salaryPerYear = salaryPerYear;
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getSalaryPerYear() {
        return salaryPerYear;
    }

    public void setSalaryPerYear(BigDecimal salaryPerYear) {
        this.salaryPerYear = salaryPerYear;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        return getEmployeeId() == employee.getEmployeeId();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getEmployeeId();
        return result;
    }
}

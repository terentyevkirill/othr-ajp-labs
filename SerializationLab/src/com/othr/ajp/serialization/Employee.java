package com.othr.ajp.serialization;

import java.awt.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Employee extends Person {
    static final long serialVersionUID = 1L;
    private Integer employeeId;
    private String department;
    private BigDecimal salaryPerYear;
    private EmployeeStatus status;
    private Date dateHired;


    public Employee(String[] firstnames, String lastname, String socialSecurityNumber, Date dateOfBirth, Color eyeColor, Address currentAddress, List<Address> formerAdresses,
                    Integer employeeId, String department, BigDecimal salaryPerYear, EmployeeStatus status) {
        super(firstnames, lastname, socialSecurityNumber, dateOfBirth, eyeColor, currentAddress, formerAdresses);
        this.employeeId = employeeId;
        this.department = department;
        this.salaryPerYear = salaryPerYear;
        this.status = status;
        this.dateHired = new Date();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", salaryPerYear=" + salaryPerYear +
                ", status=" + status +
                ", dateHired=" + (dateHired != null ? new SimpleDateFormat("dd-MM-yyyy").format(dateHired) : dateHired) +
                ", " + super.toString() +
                '}';
    }
}

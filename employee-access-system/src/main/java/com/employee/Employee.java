package com.employee;

public class Employee {

    private String employeeId;
    private String name;
    private int age;
    private String department;
    private String employmentType;
    private String employmentStatus;
    private int securityClearanceLevel;
    private boolean idValid;

    public Employee(String employeeId,
                    String name,
                    int age,
                    String department,
                    String employmentType,
                    String employmentStatus,
                    int securityClearanceLevel,
                    boolean idValid) {

        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.employmentType = employmentType;
        this.employmentStatus = employmentStatus;
        this.securityClearanceLevel = securityClearanceLevel;
        this.idValid = idValid;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public int getSecurityClearanceLevel() {
        return securityClearanceLevel;
    }

    public boolean isIdValid() {
        return idValid;
    }
}

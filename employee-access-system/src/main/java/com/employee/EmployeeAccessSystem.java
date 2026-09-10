package com.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeAccessSystem {

    private static final List<String> AUTHORIZED_DEPARTMENTS =
            Arrays.asList("IT", "HR", "Finance", "Administration");

    public static String checkEligibility(Employee employee,
                                          int requiredClearance) {

        if (employee == null) {
            throw new IllegalArgumentException(
                    "Employee details cannot be null");
        }

        if (requiredClearance < 0) {
            throw new IllegalArgumentException(
                    "Required security clearance cannot be negative");
        }

        List<String> reasons = new ArrayList<>();

        // Validate Employee ID
        if (employee.getEmployeeId() == null ||
                employee.getEmployeeId().trim().isEmpty()) {

            reasons.add("Employee ID is missing");

        } else if (!employee.isIdValid()) {

            reasons.add("Employee ID is invalid");
        }

        // Validate Employee Name
        if (employee.getName() == null ||
                employee.getName().trim().isEmpty()) {

            reasons.add("Employee name is missing");
        }

        // Check Age
        if (employee.getAge() < 0) {

            reasons.add("Age cannot be negative");

        } else if (employee.getAge() < 21) {

            reasons.add("Employee must be at least 21 years old");
        }

        // Check Department
        if (!AUTHORIZED_DEPARTMENTS.contains(employee.getDepartment())) {

            reasons.add(
                    "Employee does not belong to an authorized department");
        }

        // Check Employment Status
        if (!"Active".equalsIgnoreCase(
                employee.getEmploymentStatus())) {

            reasons.add(
                    "Employee does not have active employment status");
        }

        // Check Security Clearance
        if (employee.getSecurityClearanceLevel()
                < requiredClearance) {

            reasons.add(
                    "Security clearance level is insufficient");
        }

        // If there are no problems
        if (reasons.isEmpty()) {
            return "Eligible";
        }

        // If only security clearance is insufficient
        if (reasons.size() == 1 &&
                reasons.get(0).equals(
                        "Security clearance level is insufficient")) {

            return "Conditionally Eligible: "
                    + reasons.get(0);
        }

        // Display all rejection reasons
        return "Not Eligible: "
                + String.join("; ", reasons);
    }

    public static void main(String[] args) {

        Employee employee1 = new Employee(
                "EMP001",
                "Arun",
                25,
                "IT",
                "Full-Time",
                "Active",
                3,
                true
        );

        Employee employee2 = new Employee(
                "EMP002",
                "Kumar",
                19,
                "Sales",
                "Full-Time",
                "Inactive",
                1,
                false
        );

        Employee employee3 = new Employee(
                "EMP003",
                "Priya",
                30,
                "HR",
                "Full-Time",
                "Active",
                1,
                true
        );

        System.out.println(
                "EMPLOYEE ACCESS ELIGIBILITY SYSTEM");

        System.out.println(
                "=================================");

        System.out.println();

        System.out.println(
                "Employee: " + employee1.getName());

        System.out.println(
                "Result: " +
                checkEligibility(employee1, 2));

        System.out.println();

        System.out.println(
                "Employee: " + employee2.getName());

        System.out.println(
                "Result: " +
                checkEligibility(employee2, 2));

        System.out.println();

        System.out.println(
                "Employee: " + employee3.getName());

        System.out.println(
                "Result: " +
                checkEligibility(employee3, 2));
    }
}

package com.employee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmployeeAccessSystemTest {

    // Test 1: Normal scenario
    @Test
    void testEligibleEmployee() {

        Employee employee = new Employee(
                "EMP001",
                "Arun",
                25,
                "IT",
                "Full-Time",
                "Active",
                3,
                true
        );

        String result =
                EmployeeAccessSystem.checkEligibility(
                        employee, 2);

        assertEquals("Eligible", result);
    }


    // Test 2: Boundary scenario - age exactly 21
    @Test
    void testAgeExactly21() {

        Employee employee = new Employee(
                "EMP002",
                "Kumar",
                21,
                "HR",
                "Full-Time",
                "Active",
                2,
                true
        );

        String result =
                EmployeeAccessSystem.checkEligibility(
                        employee, 2);

        assertEquals("Eligible", result);
    }


    // Test 3: Employee below 21
    @Test
    void testEmployeeBelow21() {

        Employee employee = new Employee(
                "EMP003",
                "Ravi",
                20,
                "IT",
                "Full-Time",
                "Active",
                3,
                true
        );

        String result =
                EmployeeAccessSystem.checkEligibility(
                        employee, 2);

        assertTrue(
                result.contains(
                        "21 years old"));
    }


    // Test 4: Invalid department
    @Test
    void testInvalidDepartment() {

        Employee employee = new Employee(
                "EMP004",
                "Priya",
                25,
                "Sales",
                "Full-Time",
                "Active",
                3,
                true
        );

        String result =
                EmployeeAccessSystem.checkEligibility(
                        employee, 2);

        assertTrue(
                result.contains(
                        "authorized department"));
    }


    // Test 5: Inactive employment status
    @Test
    void testInactiveEmployee() {

        Employee employee = new Employee(
                "EMP005",
                "Meena",
                25,
                "Finance",
                "Full-Time",
                "Inactive",
                3,
                true
        );

        String result =
                EmployeeAccessSystem.checkEligibility(
                        employee, 2);

        assertTrue(
                result.contains(
                        "active employment status"));
    }


    // Test 6: Invalid employee ID
    @Test
    void testInvalidEmployeeId() {

        Employee employee = new Employee(
                "EMP006",
                "John",
                25,
                "Finance",
                "Full-Time",
                "Active",
                3,
                false
        );

        String result =
                EmployeeAccessSystem.checkEligibility(
                        employee, 2);

        assertTrue(
                result.contains(
                        "Employee ID is invalid"));
    }


    // Test 7: Insufficient security clearance
    @Test
    void testInsufficientSecurityClearance() {

        Employee employee = new Employee(
                "EMP007",
                "Meena",
                30,
                "IT",
                "Full-Time",
                "Active",
                1,
                true
        );

        String result =
                EmployeeAccessSystem.checkEligibility(
                        employee, 3);

        assertTrue(
                result.startsWith(
                        "Conditionally Eligible"));
    }


    // Test 8: Multiple failures
    @Test
    void testMultipleFailures() {

        Employee employee = new Employee(
                "EMP008",
                "John",
                18,
                "Sales",
                "Full-Time",
                "Inactive",
                1,
                false
        );

        String result =
                EmployeeAccessSystem.checkEligibility(
                        employee, 3);

        assertTrue(
                result.contains(
                        "21 years old"));

        assertTrue(
                result.contains(
                        "authorized department"));

        assertTrue(
                result.contains(
                        "active employment status"));

        assertTrue(
                result.contains(
                        "Employee ID is invalid"));

        assertTrue(
                result.contains(
                        "Security clearance level is insufficient"));
    }


    // Test 9: Invalid input - null employee
    @Test
    void testNullEmployee() {

        assertThrows(
                IllegalArgumentException.class,
                () -> EmployeeAccessSystem
                        .checkEligibility(null, 2));
    }


    // Test 10: Invalid input - negative clearance
    @Test
    void testNegativeClearance() {

        Employee employee = new Employee(
                "EMP009",
                "Arun",
                25,
                "IT",
                "Full-Time",
                "Active",
                3,
                true
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> EmployeeAccessSystem
                        .checkEligibility(employee, -1));
    }
}

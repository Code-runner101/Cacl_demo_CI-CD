package com.example.calculator_demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorDemoApplicationTests {

    @Test
    void testAddition() {
        double result = calculate(10, 5, "add");
        assertEquals(15.0, result);
    }

    @Test
    void testSubtraction() {
        double result = calculate(10, 5, "sub");
        assertEquals(5.0, result);
    }

    @Test
    void testMultiplication() {
        double result = calculate(10, 5, "mul");
        assertEquals(50.0, result);
    }

    @Test
    void testDivision() {
        double result = calculate(10, 5, "div");
        assertEquals(2.0, result);
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculate(10, 0, "div"));
        assertEquals("Division by zero", exception.getMessage());
    }

    double calculate(double a, double b, String op) {
        switch (op) {
            case "add":
                return a + b;
            case "sub":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }
}

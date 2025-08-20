package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {

        @Test
        @DisplayName("Should add two positive numbers")
        void shouldAddTwoPositiveNumbers() {
            int result = calculator.add(5, 3);
            assertEquals(8, result);
        }

        @Test
        @DisplayName("Should add negative numbers")
        void shouldAddNegativeNumbers() {
            int result = calculator.add(-5, -3);
            assertEquals(-8, result);
        }

        @ParameterizedTest
        @DisplayName("Should add zero to any number")
        @ValueSource(ints = {0, 1, -1, 100, -100})
        void shouldAddZeroToAnyNumber(int number) {
            assertEquals(number, calculator.add(number, 0));
            assertEquals(number, calculator.add(0, number));
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {

        @Test
        @DisplayName("Should subtract two positive numbers")
        void shouldSubtractTwoPositiveNumbers() {
            int result = calculator.subtract(10, 3);
            assertEquals(7, result);
        }

        @ParameterizedTest
        @DisplayName("Should handle various subtraction scenarios")
        @CsvSource({
            "10, 5, 5",
            "0, 0, 0",
            "-5, -3, -2",
            "5, -3, 8"
        })
        void shouldHandleVariousSubtractionScenarios(int a, int b, int expected) {
            assertEquals(expected, calculator.subtract(a, b));
        }
    }

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {

        @Test
        @DisplayName("Should multiply two positive numbers")
        void shouldMultiplyTwoPositiveNumbers() {
            int result = calculator.multiply(6, 7);
            assertEquals(42, result);
        }

        @Test
        @DisplayName("Should return zero when multiplying by zero")
        void shouldReturnZeroWhenMultiplyingByZero() {
            assertEquals(0, calculator.multiply(5, 0));
            assertEquals(0, calculator.multiply(0, 5));
        }
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {

        @Test
        @DisplayName("Should divide two positive numbers")
        void shouldDivideTwoPositiveNumbers() {
            double result = calculator.divide(10, 2);
            assertEquals(5.0, result, 0.001);
        }

        @Test
        @DisplayName("Should handle decimal results")
        void shouldHandleDecimalResults() {
            double result = calculator.divide(10, 3);
            assertEquals(3.333, result, 0.001);
        }

        @Test
        @DisplayName("Should throw exception when dividing by zero")
        void shouldThrowExceptionWhenDividingByZero() {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0)
            );
            assertEquals("Division by zero is not allowed", exception.getMessage());
        }
    }
}
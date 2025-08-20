package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

// fibonacci
// 0 1 2 3 4 5 6 7
// 0 1 1 2 3 5 8 13
class FibonacciTest {

    int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    @ParameterizedTest
    @MethodSource("fibonacciProvider")
    void testFibonacci(int input, int expected) {
        assertEquals(expected, fib(input));
    }

    static List<Integer[]> fibonacciProvider() {
        return Arrays.asList(new Integer[][] {
                { 0, 0 },
                { 1, 1 },
                { 2, 1 },
                { 3, 2 },
                { 4, 3 }
        });
    }

}

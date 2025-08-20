package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

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

    @Test
    void testFibonacci() {
        int cases[][] = { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 } };
        Arrays.stream(cases).forEach(c -> assertEquals(c[1], fib(c[0])));
    }
}

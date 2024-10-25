package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    @DisplayName("Test if number is identified as prime correctly")
    public void testIsPrime() {
        assertAll(
                () -> assertTrue(Prime.isPrime(2)),
                () -> assertTrue(Prime.isPrime(31)),
                () -> assertFalse(Prime.isPrime(1)),
                () -> assertFalse(Prime.isPrime(64))
        );
    }

    @Test
    @DisplayName("Test if prime numbers in interval is added to array")
    public void testIdentifyPrime() {
        int[] expected = new int[]{101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181};
        ArrayList<Integer> results = Prime.identifyPrime(100, 190);
        assertEquals(Arrays.toString(expected), results.toString());
    }

    @Test
    @DisplayName("Test if sum of all prime numbers is correct")
    public void testSumOfNumbers() {
        ArrayList<Integer> primeArray = new ArrayList<Integer>(Arrays.asList(23, 29, 31, 37, 41, 43, 47, 53, 59, 61));
        assertEquals(424, Prime.sumOfNumbers(primeArray));
    }
}
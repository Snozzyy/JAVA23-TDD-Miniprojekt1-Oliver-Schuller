package org.example;

import java.util.ArrayList;

public class Prime {

    public static ArrayList<Integer> identifyPrime(int start, int end) {
        ArrayList<Integer> primeArray = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primeArray.add(i);
            }
        }

        return primeArray;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int sumOfNumbers(ArrayList<Integer> primeArray) {
        int sum = 0;
        for (int i : primeArray) {
            sum += i;
        }

        return sum;
    }
}

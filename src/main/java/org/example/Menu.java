package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int startInterval;
        int endInterval;

        while (true) {
            System.out.print("Ange startinterval (heltal mellan 0 och 1000): ");
            if (sc.hasNextInt()) {
                startInterval = sc.nextInt();
                if (isValidStartInterval(startInterval)) {
                    break;
                } else {
                    System.out.print("Felaktig input! ");
                }
            } else {
                System.out.print("Felaktig input! ");
                sc.next();
            }
        }

        while (true) {
            System.out.print("Ange slutinterval (heltal mellan " + startInterval + " och 1000): ");
            if (sc.hasNextInt()) {
                endInterval = sc.nextInt();
                if (isValidInterval(startInterval, endInterval)) {
                    break;
                } else {
                    System.out.print("Felaktig input! ");
                }
            } else {
                System.out.print("Felaktig input! ");
                sc.next();
            }
        }

        ArrayList<Integer> primeArray = Prime.identifyPrime(startInterval, endInterval);

        printCount(primeArray);
        printSum(primeArray);

    }

    public static boolean isValidStartInterval(int start) {
        // Start interval can maximum be 999 in order for end interval to exist
        return (start >= 0 && start < 1000);
    }

    public static boolean isValidInterval(int start, int end) {
        return start >= 0 && end <= 1000 && start < end;
    }

    public static void printCount(ArrayList<Integer> primeArray) {
        System.out.println("Antalet primtal är: " + primeArray.size());
    }

    public static void printSum(ArrayList<Integer> primeArray) {
        System.out.println("Summan av primtalen är: " + Prime.sumOfNumbers(primeArray));
    }
}

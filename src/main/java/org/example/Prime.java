package org.example;

import java.util.Scanner;

public class Prime {

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int startInterval;
        int endInterval;

        while (true) {
            System.out.print("Ange startinterval (0 - 1000): ");
            if (sc.hasNextInt()) {
                startInterval = sc.nextInt();
                if (isValidStartInterval(startInterval))
                    break;
                else {
                    System.out.print("Felaktig input! ");
                }
            } else {
                System.out.print("Felaktig input! ");
                sc.next();
            }
        }

        while (true) {
            System.out.print("Ange slutinterval (" + startInterval + " - 1000): ");
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
    }

    public static boolean isValidStartInterval(int start) {
        // Start interval can maximum be 999 in order for end interval to exist
        return (start >= 0 && start < 1000);
    }

    public static boolean isValidInterval(int start, int end) {
        return start > 0 && end <= 1000 && start < end;
    }
}

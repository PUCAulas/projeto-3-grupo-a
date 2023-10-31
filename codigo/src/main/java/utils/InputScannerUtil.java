package main.java.utils;

import java.util.Scanner;

public class InputScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);
    public static Scanner getScanner() {
        return scanner;
    }

    public static void close() {
        scanner.close();
    }
}

package main.java.utils;

import java.util.Scanner;

public class InputScannerUtil {
    public static final Scanner scanner = new Scanner(System.in);

    public static void close() {
        scanner.close();
    }
}

package org.training.samples.functions;

import java.util.regex.Pattern;

public class Parameters {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~.-]+@[a-zA-Z0-9.-]+$";

    public static void main(String[] args) {

    }

    // 0 Param functions
    public static String getEmailPattern() {
        return EMAIL_PATTERN;
    }

    public static void close() {
        // ...
    }

    // 1 Param functions
    private static int square(int number) {
        return number * number;
    }

    private static boolean isValidEmail(String email) {
        return Pattern.matches(EMAIL_PATTERN, email);
    }

    // 2 Param functions / bad
    private static void log(String message, boolean isError) {
        if (isError) {
            System.err.println(message);
        } else {
            System.out.println(message);
        }
    }

    // 2 param good
    private static void login(String email, String password) {
        // Log a user in
        // ...
    }

    // 3 or more param
    private static String getConnection(String host, String user, String password, String driverName, int timeOut) {
        return "";
    }

    // Dynamic number
    private static int sum(int... numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}

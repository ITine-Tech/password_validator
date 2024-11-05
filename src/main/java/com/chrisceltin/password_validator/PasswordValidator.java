package com.chrisceltin.password_validator;

import java.util.Scanner;

public class PasswordValidator {
    static final int NUM_UPPER_LETTERS = 1;
    static final int NUM_LOWER_LETTERS = 5;
    static final int NUM_DIGITS = 1;
    static final String[] PETS = { "dog", "cat", "hamster", "rabbit", "turtle", "snake", "mouse", "fish", "shrimp",
            "bird" };

    public static boolean validatePassword(String input) {
        /** check for whitespace, and prompt for password again, if necessary **/
        if (input.matches(".*\\s.*")) {
            System.out.println("Password may not contain whitespace.");
            return false;
        }

        /** check for pet **/
        boolean containsPet = false;
        String inputLowerCase = input.toLowerCase(); // Convert input to lower case

        for (String pet : PETS) {
            if (inputLowerCase.contains(pet)) {
                containsPet = true;
                break; // Stop once the pet is found
            }
        }

        if (!containsPet) {
            System.out.println("Password must contain your favourite pet.");
            return false;
        }

        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;

        int inputLength = input.length();

        /** check for the necessary amount of letters and digits **/
        for (int i = 0; i < inputLength; i++) {
            char ch = input.charAt(i);

            if (Character.isUpperCase(ch)) {
                upperCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else {
                System.out.println("Please type in a valid sequence of upper or lower case letters or digits.");
                return false;
            }
        }

        if (upperCount < NUM_UPPER_LETTERS) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }
        if (lowerCount < NUM_LOWER_LETTERS) {
            System.out.println("Password must contain at least 5 lowercase letters.");
            return false;
        }
        if (digitCount < NUM_DIGITS) {
            System.out.println("Password must contain at least one digit.");
            return false;
        }

        return true;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Welcome to the password validator. These are the password rules:\n * 1 uppercase letter\n * 5 lowercase lettters\n * 1 digit\n * your favourite pet");
        System.out.println("Please enter a password: ");
        String input = scanner.nextLine();

        if (validatePassword(input)) {
            System.out.println(" _  _   __   __    __  ____    ____   __   ____  ____  _  _   __  ____  ____ ");
            System.out
                    .println("/ )( \\ / _\\ (  )  (  )(    \\  (  _ \\ / _\\ / ___)/ ___)/ )( \\ /  \\(  _ \\(    \\");
            System.out.println(
                    "\\ \\/ //    \\/ (_/\\ )(  ) D (   ) __//    \\\\___ \\\\___ \\\\ /\\ /(  O ))   / ) D (");
            System.out
                    .println(" \\__/ \\_/\\_/\\____/(__)(____/  (__)  \\_/\\_/(____/(____/(_/\\_) \\__/(__\\_)(____/");

        } else {
            System.out.println("Password is invalid");
        }
        scanner.close();
    }

}

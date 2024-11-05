package com.chrisceltin.password_validator;

import java.util.Scanner;

public class PasswordValidator implements PasswordValidatorInterface {
    static final int NUM_UPPER_LETTERS = 1;
    static final int NUM_LOWER_LETTERS = 5;
    static final int NUM_DIGITS = 1;
    static final String[] PETS = { "dog", "cat", "hamster", "rabbit", "turtle", "snake", "mouse", "fish", "shrimp",
            "bird" };

    @Override
    public ValidationResult validatePassword(String input) {
        /** check for whitespace, and prompt for password again, if necessary **/
        if (input.matches(".*\\s.*")) {

            return new ValidationResult(false, "Password may not contain whitespace.");
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
            return new ValidationResult(false, "Password must contain your favourite pet.");
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
                return new ValidationResult(false,
                        "Please type in a valid sequence of upper or lower case letters or digits.");

            }
        }

        if (upperCount < NUM_UPPER_LETTERS) {
            return new ValidationResult(false, "Password must contain at least one uppercase letter.");
        }
        if (lowerCount < NUM_LOWER_LETTERS) {
            return new ValidationResult(false, "Password must contain at least 5 lowercase letters.");
        }
        if (digitCount < NUM_DIGITS) {
            return new ValidationResult(false, "Password must contain at least one digit.");
        }

        String validPassword = """
         _  _   __   __    __  ____    ____   __   ____  ____  _  _   __  ____  ____ 
        / )( \\ / _\\ (  )  (  )(    \\  (  _ \\ / _\\ / ___)/ ___)/ )( \\ /  \\(  _ \\(    \\
        \\ \\/ //    \\/ (_/\\ )(  ) D (   ) __//    \\\\___ \\\\___ \\\\ \\/ /(  O ))   / ) D (
         \\__/ \\_/\\_/\\____/(__)(____/  (__)  \\_/\\_/(____/(____/\\_/\\_) \\__/(__\\_)(____/
        """;

        return new ValidationResult(true, validPassword); // If all checks pass, return true



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordValidator passwordValidator = new PasswordValidator();
        ValidationResult result;
        System.out.println(
                "Welcome to the password validator. These are the password rules:\n * 1 uppercase letter\n * 5 lowercase letters\n * 1 digit\n * your favourite pet");

        do {
            System.out.println("Please enter a password: ");

            String input = scanner.nextLine();
            result = passwordValidator.validatePassword(input);
            System.out.println(result.message());
        } while (!result.isValid());
        scanner.close();
    }
}



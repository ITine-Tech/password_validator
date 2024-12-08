package com.chrisceltin.password_validator;

import java.util.Scanner;
import com.cthiebaud.passwordvalidator.*;

/**
 * The {@code MyPasswordValidator} class validates passwords based on specific
 * rules defined in the {@link PasswordValidator}.
 * The password must meet conditions such as containing a certain number of
 * uppercase and lowercase letters, digits and one of the specified pet names.
 * <p>
 * The validation process returns a {@link ValidationResult} object containing
 * the result of the validation and an appropriate message.
 * </p>
 * <p>
 * This class implements the {@link PasswordValidator}.
 * 
 * @author Christine Gundel, Celine Hager, Tina Ranft.
 * 
 * @version 1.0.
 */

public class MyPasswordValidator implements PasswordValidator {

    final int NUM_UPPER_LETTERS = 1; // minumum number of uppercase letters required in the password

    final int NUM_LOWER_LETTERS = 5; // minumim number of lowercase letters required in the password

    final int NUM_DIGITS = 1; // minumum number of digits required in the password

    final String[] PETS = { "dog", "cat", "hamster", "rabbit", "turtle", "snake", "mouse", "fish", "shrimp",
            "bird" }; // array of pet names that must be included in the password

    /**
     * Validates a given password according to specific rules. The rules include:
     * <ul>
     * <li>The password must not contain any whitespace.</li>
     * <li>The password must not contain any special characters.</li>
     * <li>The password must contain at least one of the specified pet names: dog, cat, hamster, rabbit, turtle, snake, mouse, fish, shrimp, bird.</li>
     * <li>The password must have at least one uppercase letter.</li>
     * <li>The password must have at least 5 lowercase letters.</li>
     * <li>The password must have at least one digit.</li>
     * </ul>
     * 
     * @param input Inputs the password string to be validated.
     * @return A ValidationResult object indicating whether the password is valid
     *         and providing a corresponding message.
     */
    @Override
    public ValidationResult validate(String input) {

        // check for null or empty password
        if (input == null || input.isEmpty()) {
            return new ValidationResult(false, "Password cannot be empty.");
        }

        // check for whitespace, and prompt for password again, if necessary
        if (input.matches(".*\\s.*")) {

            return new ValidationResult(false, "Password may not contain whitespace.");
        }

        // check for special characters
        if (!input.matches("[a-zA-Z0-9]+")) {
            return new ValidationResult(false, "Please use only letters and digits in your password, no special characters.");
        }

        // check for pet
        boolean containsPet = false;
        String inputLowerCase = input.toLowerCase(); // Convert input to lower case

        for (String pet : PETS) {
            if (inputLowerCase.contains(pet)) {
                containsPet = true;
                break; // Stop once the pet is found
            }
        }

        if (!containsPet) {
            return new ValidationResult(false, "Password must contain your favourite pet: " + String.join(", ", PETS));
        }

        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;

        int inputLength = input.length();

        // check for the necessary amount of letters and digits
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
                        "Please use in your password:\n * your favourite pet\n * at least 1 uppercase letter\n * at least 5 lower case letters \n * at least 1 digit \n * no special characters or white spaces");

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

    /**
     * The main method runs the password validator in an interactive mode, prompting
     * the user to enter a password and displaying the validation results.
     * 
     * @param args Takes command-line arguments.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // create a Scanner object for reading user input

        MyPasswordValidator passwordValidator = new MyPasswordValidator(); // create an instance of the
                                                                           // PasswordValidator
                                                                           // class
        ValidationResult result; // variable to store the result of password validation

        // print welcome message and password rules
        System.out.println(
                "Welcome to the password validator. These are the password rules:\n * 1 uppercase letter\n * 5 lowercase letters\n * 1 digit\n * your favourite pet");

        // loop until the user provides a valid password
        do {
            System.out.println("Please enter a password: ");

            String input = scanner.nextLine(); // read the user's password input
            result = passwordValidator.validate(input); // validate the input password and store the result
            System.out.println(result.message()); // print the result message
        } while (!result.isValid());

        scanner.close(); // close the scanner object to free up resources
    }
}

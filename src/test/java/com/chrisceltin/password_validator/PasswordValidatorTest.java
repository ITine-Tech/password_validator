package com.chrisceltin.password_validator;

import com.cthiebaud.passwordvalidator.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;


public class PasswordValidatorTest {

    private MyPasswordValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new MyPasswordValidator();
    }

    @Test
    public void testEmptyPassword() {
        ValidationResult result = validator.validate("");
        assertEquals(false, result.isValid());
        assertEquals("Password cannot be empty.", result.message());
    }

    @Test
    public void testPasswordWithWhitespace() {
        ValidationResult result = validator.validate("password with space");
        assertEquals(false, result.isValid());
        assertEquals("Password may not contain whitespace.", result.message());
    }

    @Test
    public void testPasswordWithoutPet() {
        ValidationResult result = validator.validate("Password123");
        assertEquals(false, result.isValid());
        assertEquals("Password must contain your favourite pet: dog, cat, hamster, rabbit, turtle, snake, mouse, fish, shrimp, bird", result.message());
    }

    @Test
    public void testPasswordWithSpecialCharacters() {
        ValidationResult result = validator.validate("Password123!");
        assertEquals(false, result.isValid());
        assertEquals("Please use only letters and digits in your password, no special characters.", result.message());
    }

    @Test
    public void testPasswordWithPet() {
        ValidationResult result = validator.validate("Password123dog");
        assertEquals(true, result.isValid());
    }

    @Test
    public void testPasswordWithoutUppercase() {
        ValidationResult result = validator.validate("password123mouse");
        assertEquals(false, result.isValid());
        assertEquals("Password must contain at least one uppercase letter.", result.message());
    }

    @Test
    public void testPasswordWithoutLowercase() {
        ValidationResult result = validator.validate("PASSWORD123BIRD");
        assertEquals(false, result.isValid());
        assertEquals("Password must contain at least 5 lowercase letters.", result.message());
    }

    @Test
    public void testPasswordWithoutDigit() {
        ValidationResult result = validator.validate("Passwordhamster");
        assertEquals(false, result.isValid());
        assertEquals("Password must contain at least one digit.", result.message());
    }

    @Test
    public void testValidPassword() {
        ValidationResult result = validator.validate("Turtle123password");
        assertEquals(true, result.isValid());
        String expectedString = """
                 _  _   __   __    __  ____    ____   __   ____  ____  _  _   __  ____  ____
                / )( \\ / _\\ (  )  (  )(    \\  (  _ \\ / _\\ / ___)/ ___)/ )( \\ /  \\(  _ \\(    \\
                \\ \\/ //    \\/ (_/\\ )(  ) D (   ) __//    \\\\___ \\\\___ \\\\ \\/ /(  O ))   / ) D (
                 \\__/ \\_/\\_/\\____/(__)(____/  (__)  \\_/\\_/(____/(____/\\_/\\_) \\__/(__\\_)(____/
                """;
        assertEquals(expectedString, result.message());
    }
}

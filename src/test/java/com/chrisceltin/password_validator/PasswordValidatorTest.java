package com.chrisceltin.password_validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    public void testPasswordWithWhitespace() {
        ValidationResult result = validator.validatePassword("password with space");
        assertEquals(false, result.isValid());
        assertEquals("Password may not contain whitespace.", result.message());
    }

    @Test
    public void testPasswordWithoutPet() {
        ValidationResult result = validator.validatePassword("Password123");
        assertEquals(false, result.isValid());
        assertEquals("Password must contain your favourite pet.", result.message());
    }

    @Test
    public void testPasswordWithPet() {
        ValidationResult result = validator.validatePassword("Password123cat");
        assertEquals(true, result.isValid());
    }

    @Test
    public void testPasswordWithoutUppercase() {
        ValidationResult result = validator.validatePassword("password123cat");
        assertEquals(false, result.isValid());
        assertEquals("Password must contain at least one uppercase letter.", result.message());
    }

    @Test
    public void testPasswordWithoutLowercase() {
        ValidationResult result = validator.validatePassword("PASSWORD123CAT");
        assertEquals(false, result.isValid());
        assertEquals("Password must contain at least 5 lowercase letters.", result.message());
    }

    @Test 
    public void testPasswordWithoutDigit() {
        ValidationResult result = validator.validatePassword("PasswordCat");
        assertEquals(false, result.isValid());
        assertEquals("Password must contain at least one digit.", result.message());
    }

    @Test
    public void testValidPassword() {
        ValidationResult result = validator.validatePassword("Cat123password");
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

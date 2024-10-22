package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    @DisplayName("Ensure start interval is between 0-1000")
    public void testIsValidStartInterval() {
        assertAll(
                () -> assertTrue(Prime.isValidStartInterval(0), "Test minimum value start interval can be"),
                () -> assertTrue(Prime.isValidStartInterval(999), "Test maximum value start interval can be"),
                () -> assertFalse(Prime.isValidStartInterval(1000), "Test too high value"),
                () -> assertFalse(Prime.isValidStartInterval(-1), "Test too low value"),
                () -> assertTrue(Prime.isValidStartInterval(500), "Test valid interval value")
        );
    }

    @Test
    @DisplayName("Ensure interval is between 0-1000") // This test also covers that end interval is valid
    public void testIsValidInterval() {
        assertAll(
                () -> assertTrue(Prime.isValidInterval(1, 1000), "Test valid interval"),
                () -> assertFalse(Prime.isValidInterval(-1, 1000), "Test too low start interval"),
                () -> assertFalse(Prime.isValidInterval(1, 1001), "Test too high end interval"),
                () -> assertFalse(Prime.isValidInterval(1000, 900), "Test start interval is higher than stop interval")
        );
    }

    @Test
    @DisplayName("Test valid input to menu")
    public void testMenuValidInput() {
        provideInput("10\n100");
        Prime.menu();
        String output = testOut.toString();
        assertFalse(output.contains("Felaktig input"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1\n1\n100", "100\n50\n500", "-1\n1\n1001\n1000"})
    @DisplayName("Test invalid interval input to menu")
    public void testMenuInvalidInput(String input) {
        provideInput(input);
        Prime.menu();
        String output = testOut.toString();
        assertTrue(output.contains("Felaktig input"), "Test with wrong input");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a\n1\n100", "100\na\n500", "1.5\n2\n10", "5\n10.5\n11", "a\n1.5\n1\nb\n9.5\n10"})
    @DisplayName("Test invalid data type input to menu")
    public void testMenuInvalidDataType(String input) {
        provideInput(input);
        Prime.menu();
        String output = testOut.toString();
        assertTrue(output.contains("Felaktig input"), "Test with wrong input");
    }
}
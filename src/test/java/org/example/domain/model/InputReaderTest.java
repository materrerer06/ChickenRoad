package org.example.domain.model;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void readBetAmount_ValidInput_ReturnsCorrectAmount() {
        String input = "500\n";
        InputReader reader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        double balance = 1000.0;
        double bet = reader.readBetAmount(balance);
        assertEquals(500.0, bet);
    }

    @Test
    void readBetAmount_InvalidInputs_ShouldPromptAgain() {
        String input = "abc\n-10\n2000\n100\n"; // 4 próby, tylko ostatnia jest poprawna i w zasięgu salda
        InputReader reader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        double balance = 1000.0;
        double bet = reader.readBetAmount(balance);
        assertEquals(100.0, bet);

        String output = outContent.toString();
        assertTrue(output.contains("Wpisz poprawną liczbę") || output.contains("Kwota musi być większa niż 0") || output.contains("Nie masz wystarczających środków"));
    }

    @Test
    void readMultiplier_ValidInput_ReturnsCorrectMultiplier() {
        String input = "2.5\n";
        InputReader reader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        double multiplier = reader.readMultiplier();
        assertEquals(2.5, multiplier);
    }

    @Test
    void readMultiplier_InvalidInputs_ShouldPromptAgain() {
        String input = "abc\n1.0\n3.0\n";
        InputReader reader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        double multiplier = reader.readMultiplier();
        assertEquals(3.0, multiplier);

        String output = outContent.toString();
        assertTrue(output.contains("Wpisz poprawną liczbę") || output.contains("Minimalny mnożnik to 1.1x"));
    }

    @Test
    void askContinue_ValidYesInputs_ReturnsTrue() {
        String input = "tak\n";
        InputReader reader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        assertTrue(reader.askContinue());

        input = "t\n";
        reader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        assertTrue(reader.askContinue());
    }

    @Test
    void askContinue_ValidNoInputs_ReturnsFalse() {
        String input = "nie\n";
        InputReader reader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        assertFalse(reader.askContinue());

        input = "n\n";
        reader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        assertFalse(reader.askContinue());
    }

    @Test
    void askContinue_InvalidInputs_ShouldPromptAgain() {
        String input = "maybe\nhello\ntak\n";
        InputReader reader = new InputReader(new ByteArrayInputStream(input.getBytes()));
        assertTrue(reader.askContinue());

        String output = outContent.toString();
        assertTrue(output.contains("Wpisz 'tak' lub 'nie'"));
    }
}

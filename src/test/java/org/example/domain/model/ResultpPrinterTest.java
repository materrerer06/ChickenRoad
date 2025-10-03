package org.example.domain.model;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ResultPrinterTest {

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
    void printResult_ShouldPrintWinMessage_WhenWinIsTrue() {
        Bet bet = new Bet(100, 2.5);  // potencjalna wygrana = 250
        ResultPrinter printer = new ResultPrinter();

        printer.printResult(bet, 3.0, true);  // gracz wygrał

        String output = outContent.toString();
        assertTrue(output.contains("🎲 Wylosowany mnożnik: 3.00x"));
        assertTrue(output.contains("✅ Wygrałeś! Wygrana: 250.00 zł"));
        assertTrue(output.contains("--------------------------------"));
    }

    @Test
    void printResult_ShouldPrintLossMessage_WhenWinIsFalse() {
        Bet bet = new Bet(100, 2.5);
        ResultPrinter printer = new ResultPrinter();

        printer.printResult(bet, 1.5, false);  // gracz przegrał

        String output = outContent.toString();
        assertTrue(output.contains("🎲 Wylosowany mnożnik: 1.50x"));
        assertTrue(output.contains("❌ Przegrałeś! Strata: 100.00 zł"));
        assertTrue(output.contains("--------------------------------"));
    }
}

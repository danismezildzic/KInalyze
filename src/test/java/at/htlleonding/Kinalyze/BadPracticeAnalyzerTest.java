package at.htlleonding.Kinalyze;

import at.htlleonding.Kinalyze.Service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadPracticeAnalyzerTest {

    @Test
    void analyzeCode_WithIfStatementsAndForLoops_ShouldReturnCorrectResult() {
        String code = "if (x == true) {\n" +
                "    // Some code here...\n" +
                "} else if (y != false) {\n" +
                "    // Another code block...\n" +
                "}\n" +
                "for (int i = 0; i < 10; i++) {\n" +
                "    // Loop body...\n" +
                "}";

        String expectedResult = "Potenzielle schlechte Praxis in if-Bedingung gefunden: if (x == true) {\n" +
                "Potenzielle schlechte Praxis in if-Bedingung gefunden: } else if (y != false) {\n" +
                "Potenzielle schlechte Praxis in for-Schleife gefunden: for (int i = 0; i < 10; i++) {\n" +
                "Anzahl der potenziellen schlechten Praktiken in if-Bedingungen gefunden: 2\n" +
                "Anzahl der potenziellen schlechten Praktiken in for-Schleifen gefunden: 1\n";

        String actualResult = BadPracticeAnalyzer.analyzeCode(code);

        assertEquals(expectedResult, actualResult, "The analysis result should match the expected result");
    }

    @Test
    void analyzeCode_WithNoMatches_ShouldReturnEmptyResult() {
        String code = "public class Sample {\n" +
                "    public void method() {\n" +
                "        // No if or for statements in this code\n" +
                "    }\n" +
                "}";

        String expectedResult = "Anzahl der potenziellen schlechten Praktiken in if-Bedingungen gefunden: 0\n" +
                "Anzahl der potenziellen schlechten Praktiken in for-Schleifen gefunden: 0\n";

        String actualResult = BadPracticeAnalyzer.analyzeCode(code);

        assertEquals(expectedResult, actualResult, "The analysis result should be empty");
    }
}

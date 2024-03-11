package at.htlleonding.Kinalyze;

import at.htlleonding.Kinalyze.Service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ComplexityAnalyzerTest {

    @Test
    void analyzeCodeComplexity_EmptyCode() {
        String code = "";

        String result = ComplexityAnalyzer.analyzeCodeComplexity(code);

        assertEquals("Anzahl der Funktionen: 0\n" +
                "Maximale Verschachtelungstiefe: 0\n" +
                "Anzahl der Schleifen: 0\n" +
                "Anzahl der Entscheidungspunkte: 0\n" +
                "Anzahl der Operatoren: 0\n" +
                "Komplexitätsbewertung: 0.00", result);
    }

    @Test
    void analyzeCodeComplexity_SimpleCode() {
        String code = "public class Sample {\n" +
                "    public void method() {\n" +
                "        int x = 10;\n" +
                "        if (x > 5) {\n" +
                "            System.out.println(\"x is greater than 5\");\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String result = ComplexityAnalyzer.analyzeCodeComplexity(code);

        assertEquals("Anzahl der Funktionen: 1\n" +
                "Maximale Verschachtelungstiefe: 0\n" +
                "Anzahl der Schleifen: 0\n" +
                "Anzahl der Entscheidungspunkte: 1\n" +
                "Anzahl der Operatoren: 6\n" +
                "Komplexitätsbewertung: 2.00", result);
    }

    @Test
    void analyzeCodeComplexity_ComplexCode() {
        String code = "public class Sample {\n" +
                "    public void method() {\n" +
                "        for (int i = 0; i < 5; i++) {\n" +
                "            if (i % 2 == 0) {\n" +
                "                System.out.println(\"Even number: \" + i);\n" +
                "            } else {\n" +
                "                System.out.println(\"Odd number: \" + i);\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String result = ComplexityAnalyzer.analyzeCodeComplexity(code);

        assertEquals("Anzahl der Funktionen: 1\n" +
                "Maximale Verschachtelungstiefe: 1\n" +
                "Anzahl der Schleifen: 1\n" +
                "Anzahl der Entscheidungspunkte: 2\n" +
                "Anzahl der Operatoren: 10\n" +
                "Komplexitätsbewertung: 5.02", result);
    }
}

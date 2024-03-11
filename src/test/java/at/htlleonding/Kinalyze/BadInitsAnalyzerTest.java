package at.htlleonding.Kinalyze;

import at.htlleonding.Kinalyze.Service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadInitsAnalyzerTest {

    @Test
    void analyzeCode_WithUnusedVariables_ShouldReturnCorrectResult() {
        String code = "int x;\n" +
                "int y;\n" +
                "int z;\n" +
                "int a;\n" +
                "System.out.println(x);\n" +
                "System.out.println(y);\n";

        int actualResult = BadInitsAnalyzer.analyzeCode(code);

        assertEquals(2, actualResult, "The analysis result should match the expected result");
    }

    @Test
    void analyzeCode_WithNoUnusedVariables_ShouldReturnCorrectResult() {
        String code = "int x;\n" +
                "int y;\n" +
                "System.out.println(x);\n" +
                "System.out.println(y);\n";

        int actualResult = BadInitsAnalyzer.analyzeCode(code);

        assertEquals(0, actualResult, "The analysis result should match the expected result");
    }

    @Test
    void analyzeCode_WithEmptyCode_ShouldReturnCorrectResult() {
        String code = "";

        int actualResult = BadInitsAnalyzer.analyzeCode(code);

        assertEquals(0, actualResult, "The analysis result should match the expected result");
    }
}

package at.htlleonding.Kinalyze;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import at.htlleonding.Kinalyze.Service.*;

class PerformanceAnalyzerTest {

    @Test
    void shortAnalyze_WithPoorPerformance_ShouldReturnPoorRating() {
        String fileContent = "for (int i = 0; i < 15; i++) {\n" +
                "    // Some inefficient code\n" +
                "}\n" +
                "void recursiveMethod() {\n" +
                "    recursiveMethod();\n" +
                "}\n" +
                "for (int i = 0; i < 3; i++) {\n" +
                "    for (int j = 0; j < 2; j++) {\n" +
                "        // Nested loops\n" +
                "    }\n" +
                "}\n" +
                "List<String> myList = new ArrayList<>();\n" +
                "String result = \"\";\n" +
                "for (int i = 0; i < 12; i++) {\n" +
                "    result += i;\n" +
                "}\n";

        String expectedResult = "Poor";
        String actualResult = PerformanceAnalyzer.shortAnalyze(fileContent);

        assertEquals(expectedResult, actualResult, "The performance rating should be 'Poor'");
    }

    @Test
    void shortAnalyze_WithFairPerformance_ShouldReturnFairRating() {
        String fileContent = "for (int i = 0; i < 8; i++) {\n" +
                "    // Some code\n" +
                "}\n" +
                "void recursiveMethod() {\n" +
                "    recursiveMethod();\n" +
                "}\n" +
                "for (int i = 0; i < 2; i++) {\n" +
                "    // Nested loops\n" +
                "}\n" +
                "List<String> myList = new ArrayList<>();\n" +
                "String result = \"\";\n" +
                "for (int i = 0; i < 6; i++) {\n" +
                "    result += i;\n" +
                "}\n";

        String expectedResult = "Fair";
        String actualResult = PerformanceAnalyzer.shortAnalyze(fileContent);

        assertEquals(expectedResult, actualResult, "The performance rating should be 'Fair'");
    }

    @Test
    void shortAnalyze_WithGoodPerformance_ShouldReturnGoodRating() {
        String fileContent = "for (int i = 0; i < 5; i++) {\n" +
                "    // Some code\n" +
                "}\n" +
                "void recursiveMethod() {\n" +
                "    // Limited recursive calls\n" +
                "}\n" +
                "for (int i = 0; i < 1; i++) {\n" +
                "    // Limited nested loops\n" +
                "}\n" +
                "List<String> myList = new ArrayList<>();\n" +
                "String result = \"\";\n" +
                "for (int i = 0; i < 4; i++) {\n" +
                "    result += i;\n" +
                "}\n";

        String expectedResult = "Good";
        String actualResult = PerformanceAnalyzer.shortAnalyze(fileContent);

        assertEquals(expectedResult, actualResult, "The performance rating should be 'Good'");
    }
}
package at.htlleonding.Kinalyze;

import at.htlleonding.Kinalyze.Service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NamingConventionAnalyzerTest {

    @Test
    void analyzeCodeNamingConventions_AllVariablesFollowConvention() {
        String code = "public class Sample {\n" +
                "    private int variableName;\n" +
                "    public void methodName() {\n" +
                "        int anotherVariable;\n" +
                "    }\n" +
                "}";

        String result = NamingConventionAnalyzer.analyzeCodeNamingConventions(code);

        assertTrue(result.contains("All variables follow naming conventions"), "All variables should follow conventions");
    }

    @Test
    void analyzeCodeNamingConventions_NonConformingVariablesExist() {
        String code = "public class Sample {\n" +
                "    private int VariableName; // Not following conventions\n" +
                "    public void methodName() {\n" +
                "        int Another_Variable; // Not following conventions\n" +
                "    }\n" +
                "}";

        String result = NamingConventionAnalyzer.analyzeCodeNamingConventions(code);

        assertTrue(result.contains("Variable 'VariableName' does not follow conventions."), "Variable 'VariableName' should not follow conventions");
        assertTrue(result.contains("Variable 'Another_Variable' does not follow conventions."), "Variable 'Another_Variable' should not follow conventions");
        assertFalse(result.contains("All variables follow naming conventions"), "All variables should not follow conventions");
    }

    @Test
    void analyzeCodeNamingConventions_EmptyCode() {
        String code = "";

        String result = NamingConventionAnalyzer.analyzeCodeNamingConventions(code);

        assertTrue(result.contains("All variables follow naming conventions"), "All variables should follow conventions");
    }
}

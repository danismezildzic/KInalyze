package at.htlleonding.Kinalyze;
import org.junit.jupiter.api.Test;
import at.htlleonding.Kinalyze.Service.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VariableAnalyzerTest {

    @Test
    public void testVariableParsing() {
        // Test case for variable parsing
        String codeLine = "int num = 10;";
        VariableAnalyzer.Variable variable = new VariableAnalyzer.Variable(codeLine);

        assertEquals("int", variable.getDataType());
        assertEquals("num", variable.getName());
        assertEquals("10", variable.getValue());
    }
}


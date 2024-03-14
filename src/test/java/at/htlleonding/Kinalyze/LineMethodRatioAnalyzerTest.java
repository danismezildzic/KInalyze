package at.htlleonding.Kinalyze;

import at.htlleonding.Kinalyze.Service.LineMethodRatioAnalyzer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineMethodRatioAnalyzerTest {

    @Test
    public void testCalculateLineMethodRatio() {
        String code = "public class MyClass {\n" +
                "    public void method1() {\n" +
                "        // Method body\n" +
                "    }\n" +
                "    public void method2() {\n" +
                "        // Method body\n" +
                "    }\n" +
                "}\n";

        double ratio = LineMethodRatioAnalyzer.calculateLineMethodRatio(code);

        // Expected ratio: totalLines / totalMethods = 8 / 2 = 4.0
        assertEquals(4.0, ratio);
    }
}

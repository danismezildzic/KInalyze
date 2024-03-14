package at.htlleonding.Kinalyze;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import at.htlleonding.Kinalyze.Service.*;

public class LiteralsAndConstantsAnalyzerTest {

    @Test
    public void testFindLiteralsAndConstants() {
        String code = "int x = 10; double y = 3.14; boolean flag = true; String text = \"Hello\";";
        Tuple<Integer, Integer> counts = LiteralsAndConstantsAnalyzer.countLiteralsAndConstants(code);

        assertEquals(4, counts.getFirst());
        assertEquals(1, counts.getSecond());
    }
}



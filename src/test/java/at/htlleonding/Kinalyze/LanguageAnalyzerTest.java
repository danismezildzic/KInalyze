package at.htlleonding.Kinalyze;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import at.htlleonding.Kinalyze.Service.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguageAnalyzerTest {

    @Test
    void testCalculateEnglishPercentage() throws ExecutionException, InterruptedException {
        String input = "Beispieltext BuenosLang45 TheQuickBrownFoxJumpsOverTheLazyDog";
        // Assuming "TheQuickBrownFoxJumpsOverTheLazyDog" is the only English part
        int expectedPercentage = 100;

        int result = LanguageAnalyzer.analyzeLanguage(input);
        assertEquals(expectedPercentage, result);
    }

    @Test
    void testCalculateEnglishPercentage_NoEnglishParts() throws ExecutionException, InterruptedException {
        String input = "Beispieltext BuenosLang45";
        // No English parts in the input
        int expectedPercentage = 0;

        int result = LanguageAnalyzer.analyzeLanguage(input);
        assertEquals(expectedPercentage, result);
    }

    @Test
    void testCalculateEnglishPercentage_MixedLanguages() throws ExecutionException, InterruptedException {
        String input = "Beispieltext BuenosLang45 TheQuickBrownFoxJumpsOverTheLazyDog EnEspanol";
        // Assuming "TheQuickBrownFoxJumpsOverTheLazyDog" is the only English part
        int expectedPercentage = 33; // One out of three parts is English

        int result = LanguageAnalyzer.analyzeLanguage(input);
        assertEquals(expectedPercentage, result);
    }
}

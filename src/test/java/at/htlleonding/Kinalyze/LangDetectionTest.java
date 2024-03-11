package at.htlleonding.Kinalyze;

import at.htlleonding.Kinalyze.Service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LangDetectionTest {

    @Test
    void langDetect_ValidFileName() {
        String fileName = "example.txt";

        String result = LangDetection.LangDetect(fileName);

        assertEquals("txt", result, "File extension should be 'txt'");
    }

    @Test
    void langDetect_FileNameWithMultipleDots() {
        String fileName = "document.final.version.docx";

        String result = LangDetection.LangDetect(fileName);

        assertEquals("docx", result, "File extension should be 'docx'");
    }

    @Test
    void langDetect_NoExtension() {
        String fileName = "fileWithoutExtension";

        String result = LangDetection.LangDetect(fileName);

        assertEquals("", result, "No extension should result in an empty string");
    }

    @Test
    void langDetect_EmptyFileName() {
        String fileName = "";

        String result = LangDetection.LangDetect(fileName);

        assertEquals("", result, "Empty file name should result in an empty string");
    }
}

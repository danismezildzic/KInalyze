package at.htlleonding.Kinalyze.Service;
import at.htlleonding.Kinalyze.Entity.FileEntity;
import at.htlleonding.Kinalyze.Repository.FileEntityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class LangDetection{
    public static String LangDetect(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return ""; // Return empty string for null or empty file names
        }

        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex >= 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1); // Extract the file extension
        } else {
            return ""; // No dot found or dot is at the end, return empty string
        }
    }
}

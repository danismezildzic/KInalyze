package at.htlleonding.Kinalyze.Service;
import java.util.*;

public class LineMethodRatioAnalyzer {

    public static double calculateLineMethodRatio(String code) {
        String[] lines = code.split("\n");
        int totalLines = lines.length;
        int totalMethods = countMethods(code);

        if (totalMethods == 0) {
            return 0.0;
        }

        return (double) totalLines / totalMethods;
    }

    public static int countMethods(String code) {
        int count = 0;
        Scanner scanner = new Scanner(code);
        boolean inMethod = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.startsWith("public") || line.startsWith("private") || line.startsWith("protected")) {
                if (line.endsWith("{")) {
                    inMethod = true;
                } else {
                    inMethod = false;
                    count++;
                }
            } else if (line.equals("}")) {
                if (inMethod) {
                    count++;
                    inMethod = false;
                }
            }
        }

        scanner.close();
        return count;
    }
}
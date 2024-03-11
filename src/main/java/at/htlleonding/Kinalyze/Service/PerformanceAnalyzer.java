package at.htlleonding.Kinalyze.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PerformanceAnalyzer {
    public static String shortAnalyze(String fileContent){
        int loopCount = countLoops(fileContent);
        int recursiveCalls = countRecursiveCalls(fileContent);
        int nestedLoops = countNestedLoops(fileContent);
        int inefficientDataStructures = countInefficientDataStructures(fileContent);
        int stringConcatenations = countStringConcatenations(fileContent);
        int immutableStructures = countImmutableStructures(fileContent);
        int recursiveDepth = calculateRecursiveDepth(fileContent);
        int inefficientSorts = countInefficientSorts(fileContent);

        return calculatePerformanceRating(loopCount, recursiveCalls, nestedLoops, inefficientDataStructures, stringConcatenations, immutableStructures, recursiveDepth, inefficientSorts);
    }

    static int countLoops(String fileContent) {
        int loopCount = 0;
        loopCount += countOccurrences(fileContent, "\\bfor\\s*\\(");
        loopCount += countOccurrences(fileContent, "\\bwhile\\s*\\(");
        loopCount += countOccurrences(fileContent, "\\bforeach\\s*\\(");
        return loopCount;
    }

    static int countRecursiveCalls(String fileContent) {
        return countOccurrences(fileContent, "\\b(?:\\w+\\s+)*\\w+\\s*\\(.*\\)\\s*\\{\\s*(?!\\s*return\\s*\\w+\\s*\\().*\\b\\w+\\s*\\(.*\\)\\s*;");
    }


    static int countNestedLoops(String fileContent) {
        return countOccurrences(fileContent, "\\bfor\\s*\\(.*\\)\\s*\\{\\s*.*\\bfor\\s*\\(.*\\)\\s*\\{");
    }

    static int countInefficientDataStructures(String fileContent) {
        return countOccurrences(fileContent, "\\bList<\\w+>\\s+\\w+\\s*=\\s*new\\s*ArrayList<\\w+>\\(\\)\\s*;");
    }

    static int countStringConcatenations(String fileContent) {
        return countOccurrences(fileContent, "\\+");
    }

    static int countImmutableStructures(String fileContent) {
        return countOccurrences(fileContent, "\\b(?:final|immutable)\\s+(?:List|Map|Set)\\s*<\\w+>\\s+\\w+\\s*=\\s*.*;");
    }

    static int countInefficientSorts(String fileContent) {
        return countOccurrences(fileContent, "\\b(?:BubbleSort|InsertionSort|SelectionSort|GnomeSort|CocktailSort|CombSort|SlowSort|StoogeSort)\\s*\\(");
    }
    static int calculateRecursiveDepth(String fileContent) {
        int maxDepth = 0;
        int currentDepth = 0;
        for (char c : fileContent.toCharArray()) {
            if (c == '{') {
                currentDepth++;
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
            } else if (c == '}') {
                if (currentDepth > 0) {
                    currentDepth--;
                }
            }
        }
        return maxDepth;
    }

    static int countOccurrences(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    static String calculatePerformanceRating(int loopCount, int recursiveCalls, int nestedLoops, int inefficientDataStructures, int stringConcatenations, int immutableStructures, int recursiveDepth, int inefficientSorts) {
        if (loopCount > 10 || recursiveCalls > 5 || nestedLoops > 3 || inefficientDataStructures > 0 || stringConcatenations > 10 || immutableStructures > 0 || recursiveDepth > 100 || inefficientSorts > 0)
            return "Poor";
        else if (loopCount > 5 || recursiveCalls > 2 || nestedLoops > 1 || inefficientDataStructures > 0 || stringConcatenations > 5 || immutableStructures > 0 || recursiveDepth > 50 || inefficientSorts > 0)
            return "Fair";
        else
            return "Good";
    }
}

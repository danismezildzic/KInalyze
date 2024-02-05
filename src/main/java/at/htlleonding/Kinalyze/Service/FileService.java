package at.htlleonding.Kinalyze.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class FileService{

    public static class NamingConventionAnalyzer {
        public static String analyzeCodeNamingConventions(String code) {
            return analyzeCode(code);
        }
        private static String[] keywords = { "int", "double", "String", "if", "else", "for", "while", "return", "class", "package", "public", "private", "protected", "static", "import", "Random", "System" };

        private static String analyzeCode(String code) {
            StringBuilder result = new StringBuilder();

            // Remove comments to analyze only the code
            String cleanedCode = removeComments(code);

            // Analyze variable names
            String variablesResult = analyzeVariableNames(cleanedCode);
            result.append(variablesResult);

            result.append("Naming conventions analysis completed.");
            return result.toString();
        }

        private static String removeComments(String code) {
            // Remove line comments
            code = code.replaceAll("//.*", "");
            // Remove block comments
            code = code.replaceAll("/\\*.*?\\*/", "");
            return code;
        }

        private static String analyzeVariableNames(String code) {
            Pattern pattern = Pattern.compile("\\b[a-zA-Z_]\\w*\\b");
            Matcher matcher = pattern.matcher(code);
            StringBuilder nonConformingVariables = new StringBuilder();

            while (matcher.find()) {
                String variableName = matcher.group();

                if (!Arrays.asList(keywords).contains(variableName.toLowerCase())) { // Exclude keywords
                    if (!isLoopVariable(variableName) && !isCamelCase(variableName)) {
                        nonConformingVariables.append("Variable '").append(variableName).append("' does not follow conventions.\n");
                    }
                }
            }

            if (nonConformingVariables.length() == 0) {
                nonConformingVariables.append("All variables follow naming conventions.\n");
            }

            return nonConformingVariables.toString();
        }

        private static boolean isLoopVariable(String variableName) {
            // Check if the variable name is i, j, or k
            return variableName.length() == 1 && "ijk".contains(variableName);
        }

        private static boolean isCamelCase(String variableName) {
            // Check if the variable name follows CamelCase convention
            return Pattern.matches("^[a-z]+(?:[A-Z][a-z]*)*$", variableName);
        }
    }
    public static class ComplexityAnalyzer {
        private static int functionCount = 0;
        private static int loopCount = 0;
        private static int decisionPoints = 0;
        private static int operatorCount = 0;
        private static int maxNestingDepth = 0; // Diese Implementierung behandelt die Verschachtelungstiefe nicht wirklich.
        private static int currentDepth = 0; // Diese Implementierung behandelt die aktuelle Tiefe nicht wirklich.

        public static String analyzeCodeComplexity(String code) {
            return analyzeCode(code);
        }
        private static String analyzeCode(String code) {
            resetCounters();
            analyzeFunctions(code);
            analyzeLoops(code);
            analyzeDecisionPoints(code);
            analyzeOperators(code);
            double score = calculateComplexityScore();
            return buildResultString(score);
        }

        private static void resetCounters() {
            functionCount = loopCount = decisionPoints = operatorCount = maxNestingDepth = currentDepth = 0;
        }

        private static void analyzeFunctions(String code) {
            Matcher matcher = Pattern.compile("\\bpublic\\s+\\w+\\s+\\w+\\s*\\(").matcher(code);
            while (matcher.find()) {
                functionCount++;
            }
        }

        private static void analyzeLoops(String code) {
            Matcher forMatcher = Pattern.compile("\\bfor\\s*\\(").matcher(code);
            while (forMatcher.find()) {
                loopCount++;
                decisionPoints++;
            }

            Matcher whileMatcher = Pattern.compile("\\bwhile\\s*\\(").matcher(code);
            while (whileMatcher.find()) {
                loopCount++;
                decisionPoints++;
            }
        }

        private static void analyzeDecisionPoints(String code) {
            Matcher ifMatcher = Pattern.compile("\\bif\\s*\\(").matcher(code);
            while (ifMatcher.find()) {
                decisionPoints++;
            }
        }

        private static void analyzeOperators(String code) {
            Matcher operatorMatcher = Pattern.compile("[+\\-*/]").matcher(code);
            while (operatorMatcher.find()) {
                operatorCount++;
            }
        }

        private static double calculateComplexityScore() {
            return Math.sqrt(Math.sqrt(decisionPoints + 1) * Math.sqrt(loopCount + 1) * Math.sqrt(functionCount + 1) * Math.sqrt(operatorCount + 1)) - 1;
        }

        private static String buildResultString(double score) {
            return String.format("Anzahl der Funktionen: %d\n" +
                            "Maximale Verschachtelungstiefe: %d\n" +
                            "Anzahl der Schleifen: %d\n" +
                            "Anzahl der Entscheidungspunkte: %d\n" +
                            "Anzahl der Operatoren: %d\n" +
                            "Komplexitätsbewertung: %.2f",
                    functionCount, maxNestingDepth, loopCount, decisionPoints, operatorCount, score);
        }
    }
}

package at.htlleonding.Kinalyze.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class FileService{
    static String analyzeCodeNamingConventions(String code) {
        String[] keywords = { "int", "double", "String", "if", "else", "for", "while", "return", "class", "package", "public", "private", "protected", "static", "import", "Random", "System" };
        StringBuilder result = new StringBuilder();

        // Remove comments to analyze only the code
        code = removeComments(code);

        // Analyze variable names
        String variablesResult = analyzeVariableNames(code, keywords);
        result.append(variablesResult);

        result.append("Naming conventions analysis completed.");
        return result.toString();
    }

    static String removeComments(String code) {
        // Remove line comments
        code = code.replaceAll("//.*", "");

        // Remove block comments
        code = code.replaceAll("/\\*.*?\\*/", "");

        return code;
    }

    static String analyzeVariableNames(String code, String[] keywords) {
        // Find all variable names
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

    static boolean isLoopVariable(String variableName) {
        // Check if the variable name is i, j, or k
        return variableName.length() == 1 && "ijk".contains(variableName);
    }

    static boolean isCamelCase(String variableName) {
        // Check if the variable name follows CamelCase convention
        return Pattern.matches("^[a-z]+(?:[A-Z][a-z]*)*$", variableName);
    }
}

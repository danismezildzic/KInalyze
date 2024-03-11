package at.htlleonding.Kinalyze.Service;
import java.util.HashSet;
import java.util.Set;

public class BadInitsAnalyzer {
    public static int analyzeCode(String code) {
        Set<String> declaredVariables = new HashSet<>();
        Set<String> referencedVariables = new HashSet<>();

        String[] lines = code.split("\n");

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("int") || line.startsWith("String") || line.startsWith("float") /* add more types as needed */) {
                // Variable declaration
                String[] parts = line.split("\\s+");
                if (parts.length > 1) {
                    declaredVariables.add(parts[1].replace(";", ""));
                }
            } else {
                // Variable reference
                for (String variable : declaredVariables) {
                    if (line.contains(variable)) {
                        referencedVariables.add(variable);
                    }
                }
            }
        }

        Set<String> unusedVariables = new HashSet<>(declaredVariables);
        unusedVariables.removeAll(referencedVariables);

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Total number of unused variables: ").append(unusedVariables.size()).append("\n");

        return unusedVariables.size();
    }
}

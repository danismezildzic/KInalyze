package at.htlleonding.Kinalyze.Service;
import java.util.HashSet;
import java.util.Set;

public class BadInitsAnalyzer {
    public static int analyzeCode(String code) {
        Set<String> declaredVariables = new HashSet<>();
        Set<String> referencedVariables = new HashSet<>();
        Set<String> bigVariables = new HashSet<>();

        String[] lines = code.split("\n");

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("int") || line.startsWith("String") || line.startsWith("float") /* add more types as needed */) {
                // Variable declaration
                String[] parts = line.split("\\s+");
                if (parts.length > 1) {
                    String variableName = parts[1].replace(";", "");
                    declaredVariables.add(variableName);
                    if (isSuitableDataType(Double.parseDouble(parts[2]), parts[0])) {
                        bigVariables.add(variableName);
                    }
                    /* es soll diese ganzen nummern datatypen checken und dann guckt es ob es klüger gewesen
                     wäre eine kleinere variable zu verwenden falls ja added es die variable in den hashset big variables
                      mit switch case durchgucken und halt die types checken also int, double, float, long
                      und dann deren byte sizes checken und schauen ob man andere hätte benutzen können
                      */
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
    private static boolean isSuitableDataType(Number value, String dataType) {
        double doubleValue = value.doubleValue();
        switch (dataType.toLowerCase()) {
            case "byte":
                if (doubleValue >= Byte.MIN_VALUE && doubleValue <= Byte.MAX_VALUE) {
                    return true;
                }
                break;
            case "short":
                if (doubleValue >= Short.MIN_VALUE && doubleValue <= Short.MAX_VALUE) {
                    return true;
                }
                break;
            case "int":
                if (doubleValue >= Integer.MIN_VALUE && doubleValue <= Integer.MAX_VALUE) {
                    return true;
                }
                break;
            case "long":
                if (doubleValue >= Long.MIN_VALUE && doubleValue <= Long.MAX_VALUE) {
                    return true;
                }
                break;
            case "float":
                if (doubleValue >= Float.MIN_VALUE && doubleValue <= Float.MAX_VALUE) {
                    return true;
                }
                break;
            case "double":
                // Der double-Datentyp kann jeden Wert aufnehmen, daher wird hier immer true zurückgegeben
                return true;
            default:
                // Für unbekannte Datentypen wird keine Aktion ausgeführt
                break;
        }
        return false;
    }
}

package at.htlleonding.Kinalyze.Service;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableAnalyzer {

    public static int analyzeVariables(LinkedList<Variable> variables) {
        int urValidFr = 0;

        for (Variable variable : variables) {
            if (variable.getValue().isEmpty()) {
                urValidFr++;
            }

            switch (variable.getDataType()) {
                case "int":
                    int n = Integer.parseInt(variable.getValue());
                    if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
                        printRecommendation(variable, "short");
                    } else if (n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
                        printRecommendation(variable, "byte");
                    } else {
                        urValidFr++;
                    }
                    break;
                case "string":
                    if (variable.getValue().length() == 1) {
                        printRecommendation(variable, "char");
                    } else {
                        urValidFr++;
                    }
                    break;
                case "float":
                    if (!variable.getValue().isEmpty()) {
                        Float.parseFloat(variable.getValue());
                    }
                    urValidFr++;
                    break;
                case "double":
                    if (!variable.getValue().isEmpty()) {
                        Double.parseDouble(variable.getValue());
                    }
                    urValidFr++;
                    break;
                case "short":
                    short num = Short.parseShort(variable.getValue());
                    if (num >= Byte.MIN_VALUE && num <= Byte.MAX_VALUE) {
                        printRecommendation(variable, "byte");
                    } else {
                        urValidFr++;
                    }
                    break;
                default:
                    urValidFr++;
                    break;
            }
        }

        return urValidFr;
    }

    private static void printRecommendation(Variable variable, String recommendedDataType) {
        System.out.println("[INEFFICIENT VARIABLE ON " + variable + "] Recommended datatype: " + recommendedDataType);
    }

    public static class Variable {
        private String dataType;
        private String name;
        private String value;

        public Variable(String codeLine) {
            Pattern pattern = Pattern.compile("(\\w+\\s*?\\[?\\]?)\\s+(\\w+)\\s*(=\\s*([^;]+))?;");
            Matcher matcher = pattern.matcher(codeLine.trim());

            if (matcher.find()) {
                dataType = matcher.group(1).trim();
                name = matcher.group(2).trim();
                value = matcher.group(4) != null ? matcher.group(4).trim() : "";

                if (value.contains("\"")) {
                    value = value.replace("\"", "");
                }
            } else {
                throw new IllegalArgumentException("Invalid code line format.");
            }
        }

        public String getDataType() {
            return dataType;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            if ("string".equals(dataType)) {
                return dataType + " " + name + " = \"" + value + "\";";
            } else if (value.isEmpty()) {
                return dataType + " " + name + ";";
            } else {
                return dataType + " " + name + " = " + value + ";";
            }
        }
    }

    public static class VariableFilter {
        private String filePath;

        public VariableFilter(String filePath) {
            this.filePath = filePath;
        }

        public List<String> getVariableDeclarations() {
            List<String> variableLines = new LinkedList<>();
            try {
                File file = new File(filePath);
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String codeLine = scanner.nextLine().trim();
                    if (codeLine.matches("(int|string|float|double|char|bool|byte|short)\\s+.*")) {
                        variableLines.add(codeLine);
                    }
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return variableLines;
        }
    }
}

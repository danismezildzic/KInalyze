package at.htlleonding.Kinalyze.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LiteralsAndConstantsAnalyzer {

    public static Tuple<Integer, Integer> countLiteralsAndConstants(String code) {
        String literalPattern = "\\b(0[xX][0-9a-fA-F]+|\\d+(\\.\\d+)?([eE][+-]?\\d+)?[fFdDmM]?)" +
                "|\"([^\"\\\\]|\\\\.)*\"" +
                "|@\"([^\"\\\\]|\"\")*\"" +
                "|\\b(true|false|null)\\b" +
                "|'(\\\\'|[^'])'";

        String constantPattern = "\\bfinal\\s+[A-Za-z_]\\w*\\s*=\\s*" +
                "(0[xX][0-9a-fA-F]+|\\d+(\\.\\d+)?([eE][+-]?\\d+)?[fFdDmM]?)" +
                "|\"([^\"\\\\]|\\\\.)*\"" +
                "|@\"([^\"\\\\]|\"\")*\"" +
                "|\\b(true|false|null)\\b" +
                "|'(\\\\'|[^'])'" +
                "|(\\$\"[^\"\"]*\")";

        Pattern literalPatternCompiled = Pattern.compile(literalPattern);
        Pattern constantPatternCompiled = Pattern.compile(constantPattern);

        Matcher literalsMatcher = literalPatternCompiled.matcher(code);
        Matcher constantsMatcher = constantPatternCompiled.matcher(code);

        int literalCount = 0;
        while (literalsMatcher.find()) {
            literalCount++;
        }

        int constantCount = 0;
        while (constantsMatcher.find()) {
            constantCount++;
        }

        return new Tuple<>(literalCount, constantCount);
    }
}


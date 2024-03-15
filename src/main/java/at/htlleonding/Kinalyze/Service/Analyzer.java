package at.htlleonding.Kinalyze.Service;

import javax.xml.stream.events.Comment;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Analyzer {
    public static HashMap<String, Object> analyze(String fileName, String fileContent) {
        HashMap<String, Object> responses = new HashMap<>();

        // TODO: user_uid (String)
        responses.put("file_name", fileName);
        // TODO: file_type (String)
        responses.put("file_size", fileContent.length());
        responses.put("file_content", fileContent);
        responses.put("file_lang", LangDetection.LangDetect(fileName));
        responses.put("var_eng", LanguageAnalyzer.analyzeLanguage(fileContent));
        responses.put("indents", IndentationAnalyzer.checkIndentation(fileContent));
        responses.put("complex", ComplexityAnalyzer.analyzeCodeComplexity(fileContent));
        // TODO: data_type (int)
        responses.put("bad_inits", BadInitsAnalyzer.analyzeCode(fileContent));
        responses.put("bad_pracs", BadPracticeAnalyzer.analyzeCode(fileContent));
        responses.put("comments", CommentAnalyzer.analyzeComments(fileContent));
        // TODO: constructs (String)
        // TODO: unreadables (String)
        responses.put("naming_convs", NamingConventionAnalyzer.analyzeCodeNamingConventions(fileContent));
        responses.put("performance", PerformanceAnalyzer.shortAnalyze(fileContent));

        return responses;
    }
}

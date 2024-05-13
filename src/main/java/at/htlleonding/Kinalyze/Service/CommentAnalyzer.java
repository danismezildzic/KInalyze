package at.htlleonding.Kinalyze.Service;
import at.htlleonding.Kinalyze.Entity.FileEntity;
import at.htlleonding.Kinalyze.Repository.FileEntityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class CommentAnalyzer{
    public static String analyzeComments(String code){
        int count = 0;
        boolean isWhole = true;
        int wholeCount = 0;
        float rate = 0;
        int totalCount = 0;

        List<String> lines = List.of(code.split("\n"));

        for (String line: lines){
            line = line.trim();
            if(!line.equals("")){
                if(line.charAt(0) == '/' && line.charAt(1) == '*'){
                    isWhole = true;
                    count = wholeCount;
                    totalCount += count;

                }else if (line.charAt(0) == '/' && line.charAt(1) == '/' && line.charAt(2) == '/' && line.charAt(4) != '<'){
                    isWhole = false;
                    count = countChars(lines, isWhole, line);
                    totalCount += count;

                }else if(line.charAt(0) == '/' && line.charAt(1) == '/' && line.charAt(2) != '/'){
                    isWhole = false;
                    count = countChars(lines, isWhole, line);
                    totalCount += count;
                }
            }
        }

        rate = ((float) totalCount / (float) wholeCount) * 100;
        int intRate = (int) (rate * 100);
        rate =  (float) intRate / 100;
        return String.format("%d \n", totalCount);
    }

    private static int countChars(List<String> lines, boolean whole, String line){
        int count = 0;

        if(whole){
            for(String s: lines){
                count += s.length();
            }
        }else{
            count = line.length();
        }
        return count;
    }
}

package intuit.OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class txtJustification {
    public static void main(String[] args){
        List<String> words = new ArrayList<>();
        words.add("abcdefgdgsd");
        words.add("was the best was");
        words.add("the most of");
        words.add("abcdefgdgsd");
        words.add("time.");
        justifySolution solution = new justifySolution();
        List<String> res = solution.fullJustify(words, 12);
        System.out.println(res);
    }
}
class justifySolution{
    public List<String> fullJustify(List<String> words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words == null || words.size() == 0) return res;
        List<String> wordsSplit = new ArrayList<>();
        for(String sentence : words)
            wordsSplit.addAll(Arrays.asList(sentence.split("\\s+")));
        int index = 0;
        while (index < wordsSplit.size()){
            index = getWordForCurLevel(wordsSplit, index, maxWidth, res);
        }
        return res;
    }
    private int getWordForCurLevel(List<String> words, int start, int maxWidth, List<String> res){
        int total = 0;
        //wordLength = maxWidth - space;
        int end = start;
        while (total <= maxWidth && end < words.size()){
            if(total + words.get(end).length() > maxWidth)
                break;
            total += words.get(end++).length();
            //this is for one space
            total++;
        }
        //build the word
        res.add(buildLevel(words, maxWidth, start, end, total - 1));
        //new start
        return end;
    }
    private String buildLevel(List<String> words, int maxWidth, int start, int end, int count){
        int wordCount = end - start;
        StringBuilder res = new StringBuilder();
        //one word
        if(wordCount == 1) {
            res.append(words.get(start));
            //add space/-
           for (int i = words.get(start).length(); i < maxWidth; i++) {
                res.append("-");
            }
            return res.toString();
        }
        //if last level
        if(end == words.size()){
            for(int i = start; i < end; i++){
                res.append(words.get(i));
                if(i != end - 1){
                    res.append(" ");
                }
            }
            for(int j = res.length(); j < maxWidth; j++)
                res.append(" ");
            return res.toString();
        }
        int spaceCount = wordCount - 1;
        int wordLength = count - spaceCount;
        int spaceToBeAdd = (maxWidth - wordLength) / spaceCount;
        int diff = (maxWidth - wordLength) % spaceCount;
        //more than one
        for(int i = start; i < end; i++){
            res.append(words.get(i));
            if(i != end - 1){
                for(int j = 0; j < spaceToBeAdd; j++)
                    res.append(" ");
                if(diff-- >0)
                    res.append(" ");
            }
        }
        //add space for trailing part
        for(int i = res.length(); i < maxWidth; i++)
            res.append("-");
        return res.toString();
    }
}
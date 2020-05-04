package stringAndArray;

import java.util.ArrayList;
import java.util.List;

public class LC68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        int index = 0;
        while (index < words.length){
            index = getWordForCurLevel(words, index, maxWidth, res);
        }
        return res;
    }
    private int getWordForCurLevel(String[] words, int start, int maxWidth, List<String> res){
        int total = 0;
        //wordLength = maxWidth - space;
        int end = start;
        while (total <= maxWidth && end < words.length){
            if(total + words[end].length() > maxWidth)
                break;
            total += words[end++].length();
            //this is for one space
            total++;
        }
        //build the word
        res.add(buildLevel(words, maxWidth, start, end, total - 1));
        //new start
        return end;
    }
    private String buildLevel(String[] words, int maxWidth, int start, int end, int count){
        int wordCount = end - start;
        StringBuilder res = new StringBuilder();
        //one word
        if(wordCount == 1) {
            res.append(words[start]);
            //add space
            for (int i = words[start].length(); i < maxWidth; i++) {
                res.append(" ");
            }
            return res.toString();
        }
        //if last level
        if(end == words.length){
            for(int i = start; i < end; i++){
                res.append(words[i]);
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
            res.append(words[i]);
            if(i != end - 1){
                for(int j = 0; j < spaceToBeAdd; j++)
                    res.append(" ");
                if(diff-- >0)
                    res.append(" ");
            }
        }
        return res.toString();
    }
}

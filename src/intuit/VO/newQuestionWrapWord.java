package intuit.VO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class newQuestionWrapWord {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] words1 = { "The", "day", "began", "as", "still", "as", "the", "night", "abruptly", "lighted", "with", "brilliant", "flame" };
        int maxLen1=13;
        System.out.println(wrap(words1,maxLen1));
        String[] words2= {"Hello","world"};
        int maxLen2=5;
        System.out.println(wrap(words2,maxLen2));
    }
    public static List<String> wrap(String[] words, int maxLen){
        List<String> res=new ArrayList<>();
        res.add(words[0]);
        for(int i=1;i<words.length;i++) {
            String lastWord=res.get(res.size()-1);
            if(lastWord.length()+words.length+1<=maxLen) {
                lastWord += "-" + words[i];
                res.set(res.size()-1, lastWord);
            }else {
                res.add(words[i]);
            }
        }
        return res;
    }

}
class solutionWrapWord{


}

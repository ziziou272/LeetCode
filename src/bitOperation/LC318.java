package bitOperation;

public class LC318 {
    public int maxProduct(String[] words) {
        //corner case
        if(words == null || words.length <= 1) return 0;
        int[] val = new int[words.length];
        //build bit
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                val[i] = val[i] | (1 << words[i].charAt(j) - 'a');
            }
        }
        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if((val[i] & val[j]) == 0)
                    max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }
}

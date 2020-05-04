package stringAndArray;

import java.util.ArrayList;
import java.util.List;

public class LC273 {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder res = new StringBuilder();
        List<String> list = new ArrayList<>();
        int count = 0;
        while(num != 0){
            int r = num % 1000;
            getWords(r, res, list, count);
            num /= 1000;
            count++;
        }
        for(int i = list.size() - 1; i >= 0; i--){
            res.append(list.get(i));
            if(i != 0)
                res.append(" ");
        }
        return res.toString();
    }
    private void getWords(int num, StringBuilder sb, List<String> list, int count){
        if(num == 0) return;
        //first two digit
        if(count != 0)
            list.add(THOUSANDS[count]);
        int r = num % 100;
        int last = num /100;
        if(r < 20){
            if(r != 0)
                list.add(LESS_THAN_20[r]);
        }
        else{
            int first = r % 10;
            int second = r / 10;
            String temp = TENS[second];
            if(first != 0){
                temp += " ";
                temp += LESS_THAN_20[first];
            }
            list.add(temp);
        }
        if(last != 0){
            String temp = LESS_THAN_20[last];
            temp += " Hundred";
            list.add(temp);
        }
    }
}

package stringAndArray;

public class LC8 {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        boolean negative = false;
        int val = 0;
        boolean meetInt = false;
        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);
            if(cur == ' '){
                if(meetInt) return negative ? -1 * val : val;
            }
            else{
                if(cur == '+'){
                    if(meetInt)  return negative ? -1 * val : val;
                    meetInt = true;
                }
                else if(cur == '-'){
                    if(meetInt)  return negative ? -1 * val : val;
                    meetInt = true;
                    negative = true;
                }
                else if(cur >='0' && cur <='9'){
                    meetInt = true;
                    if(negative){
                        if(-1 * val < (Integer.MIN_VALUE) / 10 || (-1 * val == (Integer.MIN_VALUE) / 10 && cur - '0' > 8)){
                            return Integer.MIN_VALUE;
                        }
                    }
                    else{
                        if(val > Integer.MAX_VALUE / 10){
                            return Integer.MAX_VALUE;
                        }
                        else if(val == Integer.MAX_VALUE / 10  && cur - '0' >= 8){
                            return Integer.MAX_VALUE;
                        }
                    }
                    val = val * 10 + cur - '0';
                }
                else
                    break;
            }
        }
        if(negative) return -1 * val;
        return val;
    }
}

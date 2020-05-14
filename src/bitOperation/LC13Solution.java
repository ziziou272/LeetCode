package bitOperation;

public class LC13Solution {
    public int romanToInt(String s) {

        int [] values = new int [s.length()];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            switch(c){
                case 'M': values[i] = 1000;break;
                case 'D' : values[i] = 500; break;
                case 'C' : values[i] = 100; break;
                case 'L': values[i] = 50;break;
                case 'X' : values[i] = 10; break;
                case 'V' : values[i] = 5; break;
                case 'I' : values[i] = 1; break;
            }
        }
        int res = 0;
        for(int j = 0; j< values.length; j++){
                if(j == values.length - 1)
                    res = res + values[j];
                    else if(values[j] < values[j + 1]){
                        res = res - values[j];
                }
                    else{
                        res = res + values[j];
                    }
        }
        return res;
    }
}

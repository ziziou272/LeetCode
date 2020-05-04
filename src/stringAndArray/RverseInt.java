package stringAndArray;

public class RverseInt {
    public int reversInteger(int n ){
        int res = 0;

        int index = 0;
        while(n != 0){

            res = res + n%10;
            n = n /10;
            index++;
        }
        return res;
    }
}

package bitOperation;

public class LC29DivideTwoNumbers {
    public int divide(int dividend, int divisor) {
        int sign = (dividend < 0) ^ (divisor < 0) ? -1:1;
        long longDividend = Math.abs((long)dividend);
        long longDivisor = Math.abs((long)divisor);
        long res = 0;
        while(longDividend >= longDivisor){
            long temp = longDivisor;
            // '<< 1' means multiply 2
            long num = 1;
            while(temp<<1 <= longDividend){
                temp <<= 1;
                num <<= 1;
            }
            //subtract the temp
            longDividend -= temp;
            res += num;
        }
        //set sign
        if(sign == -1){
            //res = (~res) + 1; 也可取反加1
            res = -res;
        }
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }
}

package DP;

public class LC1137 {
    public int tribonacci(int n) {
        if(n <= 1)
            return n;
        if(n == 2)
            return 1;
        int preprepre = 0;
        int prepre = 1;
        int pre = 1;
        for(int i = 3; i <= n; i++){
            int temp = pre + prepre + preprepre;
            preprepre = prepre;
            prepre = pre;
            pre = temp;
        }
        return pre;
    }
}

package Possibility;

import java.util.Random;

public class LC528randomPickWithWeight {
}
class randomPickWithWeight {
    private int[] w;
    private int[] sum;
    private Random rand;
    private int total;

    public randomPickWithWeight(int[] w) {
        this.w = w;
        this.sum = new int[w.length];
        rand = new Random();
        int prevSum = -1;
        total = 0;
        for(int i = 0; i < w.length; i++){
            sum[i] = prevSum + w[i];
            prevSum = sum[i];
            total += w[i];
        }
    }

    public int pickIndex() {
        int fakeIndex = rand.nextInt(total);
        return bs(fakeIndex);
    }

    private int bs(int i){
        int left = 0, right = sum.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(sum[mid] == i)
                return mid;
            else if(sum[mid] > i)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
/*
1 2 1 4 5 ->13
0 2 3 7 12


1 1 2 2 4 4 4 4 5 5 5 5 5


8




value -> index

debug:
3 4 1 7
2 6 7 14
  l
r
5


*/
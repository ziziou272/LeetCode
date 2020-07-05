package DP;

public class LC264UglyNumber2 {
    public int nthUglyNumber(int n) {
        int i = 1;
        int[] memo = new int[n];
        memo[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        while(i < n){
            int ugly = Math.min(Math.min(2*memo[p2], 3*memo[p3]),5*memo[p5]);
            if(ugly == 2*memo[p2]) p2++;
            if(ugly == 3*memo[p3]) p3++;
            if(ugly == 5*memo[p5]) p5++;
            memo[i++] = ugly;
        }
        return memo[n-1];
    }
}
/*
1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers

prime factor:
prime: 1 2 3 5 7 11 13 17...
         2 3 5

2/3/5

hashset:

2 3 5

3 pointer:
1  2   3  4  5
       p2
   p3
p5

num: 1 2

heap:
2 3 5





*/
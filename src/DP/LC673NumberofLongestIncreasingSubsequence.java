package DP;

import java.util.Arrays;

public class LC673NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] longestLen = new int[len];
        int[] countOfLongestLen = new int[len];
        Arrays.fill(countOfLongestLen, 1);
        for(int i = 0; i < len; i++){
            longestLen[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    int curLen = longestLen[j] + 1;
                    if(curLen > longestLen[i]){
                        longestLen[i] = curLen;
                        countOfLongestLen[i] = countOfLongestLen[j];
                    }else if(curLen == longestLen[i]){
                        countOfLongestLen[i] += countOfLongestLen[j];
                    }
                }
            }
        }
        int max = 0;
        //find max length
        for(int length : longestLen){
            max = Math.max(max, length);
        }
        int count = 0;
        for(int i = 0; i < len; i++){
            if(longestLen[i] == max){
                count += countOfLongestLen[i];
            }
        }
        return count;
    }
}
/*
1 2 4 3 5 4 7 2 8 9
1 2 3 3 4 4 5 2 6 7
1 1 1 1 2 1 3 1 3 3

0 1 2 3 4 5 6 7 8
0 3 1


int[] count

9 1 6 3 3 7 0 8 9 0
1 1 2 2 2 3 0 4 5 0

*/

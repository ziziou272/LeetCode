package stringAndArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class LC525ContiguousArray {

}
/*
similar to LC325. Maximum Size Subarray Sum Equals k
为了处理第一次出现0的情况： map.put(0, -1);
    0 1 1 0 1 0 1 1 1 0
   -1 0 1 0 1 0 1 2 3 2

    1 1 1 0 0
    1 2 3 2 1

    0  0  1  0
   -1 -2 -1 -2

    1  0  1
    1  0 -1

     0 1
    -1 0

  -1  0 1 1 0
   0 -1 0 1 0
*/

class Solution {
    public int findMaxLength(int[] nums) {
        //map0 to store current sum of 0 <sum, index>
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, curMax = 0, sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0 ? -1 : 1);
            if(map.containsKey(sum))
                curMax = i - map.get(sum);
            else{
                map.put(sum, i);
            }
            max = Math.max(curMax, max);
        }
        return max;
    }
}
//change hashMap to 2n+1 size array 要更快
//since the sum from n to -n
//3: -3 -2 -1 0
class solution2{
    public int findMaxLength(int[] nums) {
        //map0 to store current sum of 0 <sum, index>
        int n = nums.length;
        int[] map = new int[2 * n + 1];
        Arrays.fill(map, -2);
        map[n] = -1;
        int max = 0, curMax = 0, sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0 ? -1 : 1);
            if(map[sum + n] != -2)
                curMax = i - map[sum + n];
            else{
                map[sum + n] = i;
            }
            max = Math.max(curMax, max);
        }
        return max;
    }
}

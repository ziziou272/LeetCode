package Possibility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LC398randomPickIndex {
}
class Solution398 {
    private final int[] nums;
    Random rand;
    public Solution398(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                list.add(i);
                int size = list.size();
                int index = rand.nextInt(size);
                Collections.swap(list, index, size - 1);
            }
        }
        return list.get(0);
    }
}
//optimize to o(1) guarantee
class Solution398op {
    private final int[] nums;
    Random rand;
    public Solution398op(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    public int pick(int target) {
        int size = 0;
        int res = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                size++;
                int index = rand.nextInt(size);
                if(index == 0)
                    res = i;
            }
        }
        return res;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);

 reservoir sampling:
 1 2 3 4 5 3 2 1 3 4 3 2 1 3 4 3 2 1 2 3
 i
 pick(1)

 [0, j, k]
 renadom()
 swap(rand, i)


 */
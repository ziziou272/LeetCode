package bitOperationDuplicate;

import java.util.HashSet;

public class LC136 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            if (set.contains(nums[i]))
                set.remove(nums[i]);
            else
                set.add(nums[i]);
        }
        for(int i: set)
            return i;
        return -1;
    }
}

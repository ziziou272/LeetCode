package bitOperationDuplicate;

import java.util.HashSet;

public class LC217HashSet {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i))
                return true;
            else
                set.add(i);
        }
        return false;
    }
}

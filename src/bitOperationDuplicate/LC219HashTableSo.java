package bitOperationDuplicate;

import java.util.HashSet;
//this is the best one
public class LC219HashTableSo {
    public boolean containsNearbyDuplicate(int nums [], int k){
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i < len; i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if(set.size() > k)//can't be k+1,因为出去还会加
                set.remove(nums[i - k]);
        }
        return false;
    }
}


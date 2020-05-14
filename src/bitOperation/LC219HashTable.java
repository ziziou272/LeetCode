package bitOperation;

import java.util.HashSet;

public class LC219HashTable {//Time Limit Exceeded.
    public boolean containsNearbyDuplicate(int nums [], int k){
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i < len; i++){
            set.add(nums[i]);
            for(int j =i + 1; j < i + 1 + k; j++ ){
                if(j > len - 1)
                    break;
                if(set.contains(nums[j]))
                    return true;
            }
            set.remove(nums[i]);
        }
        return false;
    }
}

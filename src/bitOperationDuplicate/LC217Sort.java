package bitOperationDuplicate;

import java.util.Arrays;

public class LC217Sort {
    public boolean containsDuplicate(int [] nums){
        if(nums == null || nums.length == 0) return false;
        //sort the array
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}

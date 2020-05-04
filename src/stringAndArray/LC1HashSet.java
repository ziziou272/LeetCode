package stringAndArray;

import java.util.HashMap;

//return index need use HashMap
public class LC1HashSet  {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[0];
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i]))
                return new int[]{i,map.get(target - nums[i])};
            else
                map.put(nums[i],i);
        }
        return new int[0];
    }
}

package bitOperation;
//balanced tree
//完全不会*
import java.util.TreeSet;

public class LC220BalacnedTree {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i< nums.length; i++){
            Integer l = set.ceiling(nums[i]);
            if(l != null && l - t <= nums[i]) return true;

            Integer s = set.floor(nums[i]);
            if(s != null && s + t >= nums[i]) return true;

            set.add(nums[i]);
            if(set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}

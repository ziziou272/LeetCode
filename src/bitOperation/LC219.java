package bitOperation;

public class LC219 {
    public boolean containsNearbyDuplicate(int nums [], int k){
        if(nums == null || nums.length ==0) return false;
        int size = nums.length;
        for (int i =0; i < size; i++){
                for(int j = i + 1; j < k + i + 1; j++){
                    if(j > size - 1)
                        break;
                    if(nums[i] == nums[j])
                        return true;
                }
        }
        return false;
    }
}

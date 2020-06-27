package Tree;

import java.util.HashMap;
import java.util.TreeSet;

public class LC220ContainsDuplicateIII {
    /*
k == 0 false
k + 1
k = 3 t = 1
9 1 6 3 3 7 0 8 9 2 4
s
      f
size: k
bst: 1 6 9       3 + t   upLimit ->          floor(3+t) >= 3 - t
                || 3 - t     lower limit ->  ceiling(3-t) <= 3 + t
[s + 1, k + s]
*/
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> bst = new TreeSet<Integer>();
        for(int s = 0, f = 0; f < nums.length; f++){
            if(bst.size() > k){
                bst.remove(nums[s++]);
            }
            //check
            Integer low = bst.floor(nums[f] + t);
            Integer high = bst.ceiling(nums[f] - t);
            //防止越界
            if( low != null && (long)low >= (long) nums[f] - t || high != null && (long) high <= (long)nums[f] + t){
                return true;
            }
            bst.add(nums[f]);
        }
        return false;
    }
}
class brutalForceTimeExceed{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int s = 0; s < nums.length; s++){
            for(int f = s + 1; f <= k + s && f < nums.length; f++){
                if(Math.abs((long) nums[s] - (long) nums[f]) <= t)
                    return true;
            }
        }
        return false;
    }
}
class CleanBucketSolution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;
        HashMap<Integer, Integer> map  = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int id = getId(nums[i], t);
            if(map.containsKey(id)) return true;
            if(map.containsKey(id - 1) && Math.abs(nums[map.get(id - 1)] - nums[i]) <= t)
                return true;
            if(map.containsKey(id + 1) && Math.abs(nums[map.get(id + 1)] - nums[i]) <= t)
                return true;
            map.put(id,i);
            if(map.size() > k)
                map.remove(getId(nums[i - k], t));
        }
        return false;
    }

    private int getId(int num , int t){
        if(t == 0) return num;
        return num < 0 ? (num + 1) /t - 1 : num / t;
    }
}
/*

Math.abs(nums[i] - nums[j]) <= t

Math.abs(i-j) <= k

9 1 6 3 7 0 8 9 1 2 6 5
  i
        j

9+t && 9 -t

1. k*n
2. bst -> build o(k),    log(k) ->

k + n * (log(k) + min/max-> log(k))
3. bucket sort

t = 3
[0,3),[3,6)
n/3=0  n/3=1

2 5

if nums < 0

-2 /3 = -1
[-3,0) -1
[-6,-3) -2

(-5/3)-1

*/

class bucketSortSolution{
    /*
    *  t = 2, k = 3        map.size() <= 3
    *  bucket:    -2     -1
    *           [-6,-4][-3,-1][0,2][3,4][5,6]
    *  bucket id:   nums[i] / (t + 1) -> negative     we want -1 / 3 = 0 -> -1
    *   nums[i] < 0 ? nums[i] + 1 / (t + 1) + 1 :nums[i] / (t + 1)
    *   HashMap<Long, Long> the value used to check almost duplicate
    *  9 1 6 3 3 7 0 8 9 0
    *  注意long 型的转换
    * */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t< 0) return false;
        HashMap<Long, Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            //get bucket id
            long id = nums[i] < 0 ? (long)nums[i] + 1 / (t + 1 ) - 1 : (long)nums[i] / (t + 1);
            if(map.containsKey(id))
                return true;
            //check almost duplicate
            if(map.containsKey(id - 1) && Math.abs(map.get(id - 1) - (long)nums[i]) <= t)
                return true;
            if(map.containsKey(id + 1) && Math.abs(map.get(id + 1) - (long)nums[i]) <= t)
                return true;
            map.put((long)id, (long)nums[i]);
            if(map.size() > k){
                long key = nums[i - k] < 0 ? nums[i - k] + 1 / (t + 1 ) - 1 : nums[i - k] / (t + 1);
                map.remove(key);
            }
        }
        return false;
    }
}

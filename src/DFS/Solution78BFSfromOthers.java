package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution78BFSfromOthers
{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList();
        out.add(new ArrayList());

        for(int i=0; i<nums.length; i++) {
            // create a new subset
            List<List<Integer>> newList = new ArrayList();

            // walking through all subsets and add current number from num to each item
            for(int n=0; n < out.size(); n ++) {//只加上个i没有的
                List<Integer> c = new ArrayList(out.get(n));
                c.add(nums[i]);

                newList.add(c);
            }
            //每次不回重复的加，所以这个就是结果
            out.addAll(newList);
        }

        return out;
    }
}

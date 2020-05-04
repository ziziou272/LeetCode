package stringAndArray;

import java.util.Arrays;
import java.util.Comparator;

public class LC179 {
    public String largestNumber(int[] nums) {
        if(nums == null)
            return "";
        Integer [] array = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            array[i] = nums[i];
        }

        Arrays.sort(array,new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                String s1 = String.valueOf(a) + String.valueOf(b);
                String s2 = String.valueOf(b) + String.valueOf(a);
                //升序所以是S2.
                return s2.compareTo(s1);
            }
        });
        if (array[0] == 0) return "0";
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            res.append(array[i]);
        }

        return res.toString();
    }

}

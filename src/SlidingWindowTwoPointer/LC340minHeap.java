
package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LC340minHeap {
    /*
    * k = 3
        count 2
        max = 4
    d e h l o w
      4 3 6
    0 1 2 3 4 5 6 7 8 9 10 11 12
    e h h h e l l o o w  o r  d
          s
                f
    */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null) return 0;
        if(s.length() <= k) return s.length();
        int slow = 0, fast = 0, max = 0, count = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        while (fast < s.length()){
            map.put(s.charAt(fast++), fast);
            if(map.size() > k){
                Character leftMost = map.entrySet().iterator().next().getKey();
                slow = map.get(leftMost) + 1;
                map.remove(leftMost);
            }
            max = Math.max(max, fast - slow);
        }
        return max;
    }

    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        //corner case
        if(s == null) return 0;
        if(s.length() <= k) return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        TreeMap<Integer, Character> treeMap = new TreeMap<>();
        char[] arr = s.toCharArray();
        int i = 0, j = 0;
        int max = 0;
        while(j < arr.length){
            if(map.containsKey(arr[j]))
                treeMap.remove(map.get(arr[j]));
            map.put(arr[j], j);
            treeMap.put(j, arr[j]);
            while(map.size() > k){
                int index = treeMap.firstKey();
                char c = treeMap.get(index);
                map.remove(c);
                treeMap.remove(index);
                i = index + 1;
            }
            j++;
            max = Math.max(max, j - i);
        }
        return max;
    }
}


package Kproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LC347mostK {
    private class Cell{
        int val;
        int count;
        public Cell(int val, int count){
            this.val = val;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
        k size minHeap
        compare top with current
        [1,1,1,2,2,3,4,5,5,5,5,5], k = 2
        HashMap<value, count>
        1->3   2->2  3->1 4->1 5->5
        minHeap[3,5]     size 2
        */
        //cc
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length < k) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        //put value and count into hashmap
        for(int i = 0; i < nums.length; i++){
            //map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int value = nums[i];
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                map.put(value, count + 1);
            }
            else
                map.put(value, 1);
        }
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.count - b.count);
        for(int key : map.keySet()){
            if(minHeap.size() < k){
                minHeap.offer(new Cell(key, map.get(key)));
            }
            else if(minHeap.peek().count < map.get(key)){
                minHeap.poll();
                minHeap.offer(new Cell(key, map.get(key)));
            }
        }
        while(!minHeap.isEmpty()){
            res.add(minHeap.poll().val);
        }
        return res;
    }

}

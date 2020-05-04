package Kproblem;

import java.util.*;

public class LC378minHeap {
    public List<String> topKFrequent(String[] words, int k) {
        /*
        HashMap <String, count>
        nlogn
        minHeap add String to minheap compare count
        size == k compare count poll the one that smaller than top
        nlogk:
        quick selection
        n
        */
        //cc
        List<String> res = new ArrayList<>();
        if(words == null || words.length < k) return res;
        //int count
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> {
            if(map.get(a).equals(map.get(b)))
                return b.compareTo(a);
            else
                return map.get(a) - map.get(b);
        });
        for(String word : map.keySet()){
            if(minHeap.size() < k){
                minHeap.offer(word);
            }
            else{
                if(map.get(minHeap.peek()) <= map.get(word)){
                    minHeap.offer(word);
                    minHeap.poll();
                }
            }
        }
        while(!minHeap.isEmpty()){
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}

package Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LC218maxHeap {
    class endPoint implements Comparable<endPoint>{
        int val, height;
        boolean isStart;
        endPoint(int value, int height, boolean isStart){
            val = value;
            this.height = height;
            this.isStart = isStart;
        }
        @Override
        public int compareTo(endPoint that){
            if(this.val != that.val)
                return this.val - that.val;
            else{
                if(this.isStart && that.isStart)
                    return that.height - this.height;
                else if(!this.isStart && !that.isStart)
                    return this.height - that.height;
                else{
                    return this.isStart ? -1 : 1;
                }
            }
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {


        List<List<Integer>> res = new ArrayList<>();
        List<endPoint> toSort = new ArrayList<>();
        for(int i = 0; i < buildings.length; i++){
            toSort.add(new endPoint(buildings[i][0], buildings[i][2], true));
            toSort.add(new endPoint(buildings[i][1], buildings[i][2], false));
        }
        //sort
        Collections.sort(toSort);
        //maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);

        for(endPoint ep : toSort){
            if(ep.isStart){
                int maxH = maxHeap.isEmpty() ? 0 : maxHeap.peek();
                maxHeap.offer(ep.height);
                if(maxH < ep.height){
                    List<Integer> level = new ArrayList<>();
                    level.add(ep.val);
                    level.add(ep.height);
                    res.add(new ArrayList<>(level));
                }
            }
            else{
                maxHeap.remove(ep.height);
                int maxH = maxHeap.isEmpty() ? 0 : maxHeap.peek();
                if(maxH < ep.height){
                    List<Integer> level = new ArrayList<>();
                    level.add(ep.val);
                    level.add(maxH);
                    res.add(new ArrayList<>(level));
                }
            }
        }
        return res;
    }
}

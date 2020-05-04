package Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
//不用这个
public class LC218maxHeapSimple {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        //cc
        List<List<Integer>> res = new ArrayList<>();
        List<ArrayList<Integer>> endPoints = new ArrayList<>();
        for(int[] building : buildings){
            ArrayList<Integer> point1 = new ArrayList<>();
            point1.add(building[0]);
            point1.add(-1 * building[2]);
            endPoints.add(point1);
            ArrayList<Integer> point2 = new ArrayList<>();
            point2.add(building[1]);
            point2.add(building[2]);
            endPoints.add(point2);
        }
        endPoints.sort((c1, c2) -> {
            if (!c1.get(0).equals(c2.get(0)))
                return c1.get(0) - c2.get(0);
            else {
                return c1.get(1) - c2.get(1);
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((c1, c2) -> c2 - c1);
        for(ArrayList ep : endPoints){

            int point = (int)ep.get(0);
            int height = (int)ep.get(1);
            if(height < 0){//left
                int maxH = maxHeap.isEmpty() ? 0 : maxHeap.peek();
                maxHeap.offer(Math.abs(height));
                if(maxH < Math.abs(height)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(point);
                    temp.add(Math.abs(height));
                    res.add(new ArrayList<>(temp));
                }
            }
            else{
                maxHeap.remove(height);
                int maxH = maxHeap.isEmpty() ? 0 : maxHeap.peek();
                if(height > maxH){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(point);
                    temp.add(maxH);
                    res.add(new ArrayList<>(temp));
                }
            }
        }
        return res;
    }
}

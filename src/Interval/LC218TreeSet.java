package Interval;

import java.util.*;
//为了避免重复treeSet放的index
public class LC218TreeSet {
    class endPoint implements Comparable<endPoint>{
        int val, height, index;
        boolean isStart;
        endPoint(int value, int height, int index, boolean isStart){
            val = value;
            this.height = height;
            this.isStart = isStart;
            this.index = index;
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
            toSort.add(new endPoint(buildings[i][0], buildings[i][2], i , true));
            toSort.add(new endPoint(buildings[i][1], buildings[i][2], i, false));
        }
        //sort
        Collections.sort(toSort);
        //maxHeap

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if(buildings[i1][2] != buildings[i2][2])
                    return buildings[i2][2] - buildings[i1][2];
                else
                    return i1 - i2;
            }
        };

        TreeSet<Integer> maxHeap = new TreeSet<>(comparator);

        for(endPoint ep : toSort){
            if(ep.isStart){
                int maxH = maxHeap.isEmpty() ? 0 : buildings[maxHeap.first()][2];
                maxHeap.add(ep.index);
                if(maxH < ep.height){
                    List<Integer> level = new ArrayList<>();
                    level.add(ep.val);
                    level.add(ep.height);
                    res.add(new ArrayList<>(level));
                }
            }
            else{
                maxHeap.remove(ep.index);
                int maxH = maxHeap.isEmpty() ? 0 : buildings[maxHeap.first()][2];
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

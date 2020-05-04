package Kproblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

//hashSet去重

public class LC373 {
    private class Cell{
        int sum;
        int x;
        int y;
        public Cell(int sum, int x, int y){
            this.sum = sum;
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode(){
            return this.x + 31 * this.y;
        }

        @Override
        public boolean equals(Object o){
            if(o instanceof Cell){
                Cell that = (Cell) o;
                return this.x == that.x && this.y == that.y;
            }
            else
                return false;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((c1, c2) -> c1.sum - c2.sum);
        HashSet<Cell> set = new HashSet<>();


        Cell c = new Cell(nums1[0] + nums2[0], 0, 0);
        minHeap.offer(c);
        set.add(c);

        while(k-- > 0){
            if(minHeap.isEmpty())
                break;

            Cell cur = minHeap.poll();
            List<Integer> level = new ArrayList<>();
            level.add(cur.x);
            level.add(cur.y);
            res.add(new ArrayList<>(level));

            if(cur.x + 1 < nums1.length){
                Cell c1 = new Cell(nums1[cur.x + 1] + nums2[cur.y], cur.x + 1, cur.y);
                if(!set.contains(c1)){
                    minHeap.offer(c1);
                    set.add(c1);
                }
            }

            if(cur.y + 1 < nums2.length){
                Cell c2 = new Cell(nums1[cur.x] + nums2[cur.y + 1], cur.x, cur.y + 1);
                if(!set.contains(c2)){
                    minHeap.offer(c2);
                    set.add(c2);
                }
            }

        }
        return res;
    }
}

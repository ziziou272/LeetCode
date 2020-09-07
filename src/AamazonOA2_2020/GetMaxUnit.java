package AamazonOA2_2020;

import java.util.*;

//test case 跑过了
public class GetMaxUnit {
    public static void main(String[] args) {
        System.out.println(getMaxUnit(3, new ArrayList<>(Arrays.asList(1,2,3)), 3, new ArrayList<>(Arrays.asList(3, 2, 1)), 3));

    }
    public static long getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox,
                                  long truckSize){
        //int[]{numberOfBox, unitPerBox}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for(int i = 0; i < boxes.size(); i++){
            maxHeap.offer(new int[]{boxes.get(i), unitsPerBox.get(i)});
        }
        long maxUnit = 0L;
        while (truckSize > 0 && !maxHeap.isEmpty()){
            if(truckSize >= maxHeap.peek()[0]){
                int[] pair = maxHeap.poll();
                maxUnit += pair[0] * pair[1];
                truckSize -= pair[0];
            }else{
                int[] pair = maxHeap.peek();
                pair[0] -= truckSize;
                maxUnit += truckSize * pair[1];
                truckSize = 0;
            }
        }
        return maxUnit;
    }
}
class Test1 {
    static class Pair {
        int unit;
        int boxNum;
        public Pair(int unit, int boxNum) {
            this.unit = unit;
            this.boxNum = boxNum;
        }
    }
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        int num = 10;
        ArrayList<Integer> boxes = new ArrayList<>();
        boxes.add(1);
        boxes.add(2);
        boxes.add(3);
        int unitSize = 3;
        ArrayList<Integer> unitPerBox = new ArrayList<>();
        unitPerBox.add(3);
        unitPerBox.add(2);
        unitPerBox.add(1);
        long truckSize = 3;
        long res = t1.getMax(num, boxes, unitSize, unitPerBox, truckSize);
        System.out.println(res);
    }

    long getMax(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitPerBox, long truckSize) {
        long res = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> (b.unit - a.unit));
        for (int i = 0; i < boxes.size(); i++) {
            pq.offer(new Pair(unitPerBox.get(i), boxes.get(i)));
        }

        while (truckSize > 0) {
            Pair cur = pq.poll();
            int unit = cur.unit;
            int boxNum = cur.boxNum;
            if (boxNum < truckSize) {
                res += boxNum * unit;
                truckSize -= boxNum;
            } else {
                res += boxNum * truckSize;
                truckSize = 0;
            }
        }

        return res;
    }
}



class Solution1 {

    public static void main(String[] args) {

        // ===================================================
        int num = 2;
        ArrayList<Integer> boxes = new ArrayList<>(List.of(2, 2));
        int unitSize = 2;
        ArrayList<Integer> unitsPerBox = new ArrayList<>(List.of(3, 1));
        int truckSize = 3;

        // ===================================================

        System.out.println(getMaxUnit(num,boxes,unitSize,unitsPerBox,truckSize));

    }

    public static int getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize){
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i=0;i<num;i++){
            int n= boxes.get(i);
            for(int j=0;j<n;j++){
                PQ.add(unitsPerBox.get(i));
                if(PQ.size()>truckSize) PQ.remove();
            }
        }
        int max=0;
        while(!PQ.isEmpty()){
            max += PQ.remove();
        }
        return max;
    }

}

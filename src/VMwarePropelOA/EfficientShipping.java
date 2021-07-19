package VMwarePropelOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class EfficientShipping {
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
                int[] arr = maxHeap.peek();
                arr[0] -= truckSize;
                maxUnit += truckSize * arr[1];
                truckSize = 0;
            }
        }
        return maxUnit;
    }
}

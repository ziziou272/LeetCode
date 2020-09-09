package Kproblem;

import java.util.PriorityQueue;

public class LC295FindMedianFromDataStream {

}
class MedianFinder {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum(int num) {
        //
        /*

        empty   empty
        1, 2,    3,4,7
        */
        int leftMax = maxHeap.isEmpty() ? Integer.MAX_VALUE : maxHeap.peek();
        int rightMax = minHeap.isEmpty() ? Integer.MIN_VALUE : minHeap.peek();
        if(num < leftMax){
            maxHeap.offer(num);
            if(maxHeap.size() - minHeap.size() > 1){
                minHeap.offer(maxHeap.poll());
            }
        }else{
            minHeap.offer(num);
            if(minHeap.size() - maxHeap.size() > 1){
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
            return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2;
        return maxHeap.size() > minHeap.size() ?  ((double) maxHeap.peek()) : ((double) minHeap.peek());
    }
}

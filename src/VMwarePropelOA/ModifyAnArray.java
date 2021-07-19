package VMwarePropelOA;

import java.util.PriorityQueue;
import java.util.Queue;

public class ModifyAnArray {
    public static void main(String[] args) {
        int[] nums1 = { 0, 1, 2, 5, 6, 5, 7 };
        int[] nums2 = { 9847, 3752, 5621, 7012, 1986, 3090, 1383, 6257, 9501, 7004, 6181, 9387, 9137, 9305, 7795, 9310,
                3904, 8328, 6656, 8123, 1796, 2754, 4372, 5200, 3893, 8568, 4436, 3973, 8498, 1879, 2731, 4651, 4388,
                453, 2465, 2669, 6384, 819, 8565, 1952, 7219, 4362, 3012, 9380, 2645, 4800, 2945, 5778, 1993, 1170,
                1356, 8557, 1497, 8921, 670, 5155, 9115, 1095, 9400, 9451, 9344, 4393, 4201, 8167, 8129, 2004, 8839,
                1457, 7682, 1881, 9266, 6366, 9889, 242, 5318, 5248, 3670, 7381, 6567, 2317, 2162, 6670, 5876, 1179,
                2482, 9270, 4326, 4166, 6122, 2016, 3008, 5349, 1723, 5816, 4030 };
        System.out.println(getMinCost(nums1));
        System.out.println(getMinCost(nums2));
    }

    private static int getMinCost(int[] nums) {
        return Math.min(increasing(nums, nums.length), decreasing(nums, nums.length));
    }
/*
* 9 1 2 3 3 6 4 5
                i
* 8
* heap: 1 2 3 4 5
*
* 1 1 2 3 3 3 4
i:9 9 9 9 9 9 9
d:9 1 1 1 1 1 1
*
* */
    public static int increasing(int[] nums, int n) {
        int sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            if (!maxHeap.isEmpty() && maxHeap.peek() > nums[i]) {
                sum += maxHeap.peek() - nums[i];
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
            maxHeap.add(nums[i]);
        }
        return sum;
    }

    private static int decreasing(int[] nums, int n) {
        int sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() < nums[i]) {
                sum += (nums[i] - minHeap.element());
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
            minHeap.add(nums[i]);
        }
        return sum;
    }
}

/*
* 9 1 7 2 0 3 2 10
* i
*       j
* 1 1 2 7
* 9
*
* size:8
* min: 0
* max: 10
* sum: 34
* average = 34/8= 4.
*
* */

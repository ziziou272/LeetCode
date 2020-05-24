package SlidingWindowTwoPointer;

public class LC11 {
}
class SolutionLC11 {
    public int maxArea(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int i = 0, j = height.length - 1;
        int max = 0;
        while(i + 1 <= j){
            int w = j - i;
            int area = w * Math.min(height[i], height[j]);
            max = Math.max(area, max);
            int move = height[i] < height[j] ? i++ : j--;
        }
        return max;
    }
}
/*
i = 0
j = 1
    0 1 2 3 4 5 6 7 8 9 10 11
    1 9 1 6 3 3 7 1 8 1 3 7
    i
                          j
[i, j]
area: 11, 70

the width between 2 lines i and j is w =  (j - i) * 1.
max
area = min(hi, hj) * w

n^2 -> n
*/
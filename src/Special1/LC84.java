package Special1;
//brutal force
//Time O(n*n) Space O(1)
public class LC84 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        if (heights == null)
            return max;
        for(int i = 0; i < heights.length; i++){
            int count = 0;
            int left = i - 1;
            int right = i + 1;
            while(left >= 0){
                if(heights[i] <= heights[left]){
                    left--;
                    count++;
                }
                else
                    break;
            }
            while (right < heights.length){
                if(heights[i] <= heights[right]){
                    right++;
                    count++;
                }
                else
                    break;
            }
            max = Math.max(max, heights[i] + heights[i] * count);
        }
        return max;
    }
}

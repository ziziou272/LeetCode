package Special1;

public class LC42best {
    public int trap(int[] height) {
        if(height == null || height.length <=2)
            return 0;
        int res = 0, left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while(left + 1 <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(leftMax < rightMax){
                res += leftMax - height[left];
                left++;
            }
            else{
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}

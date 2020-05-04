package Special1;
//o(n^2)
public class LC42Brutalforce {
    public int trap(int[] height) {
        if(height == null || height.length <= 2)
            return 0;
        int res = 0;
        for(int i = 0; i < height.length; i++){
            int leftMax = 0, rightMax = 0;
            for(int j = i; j < height.length; j++){
                leftMax = Math.max(height[j], leftMax);
            }
            for(int k = 0; k < i; k++){
                rightMax = Math.max(height[k], rightMax);
            }
            res += Math.max(0, Math.min(leftMax, rightMax) - height[i]);
        }
        return res;
    }
}

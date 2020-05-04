package BinarySearch;

public class LintCode183 {
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0){
            return 0;
        }
        int maxLen = 0;
        for(int i = 0; i < L.length; i++){
            maxLen = Math.max(maxLen, L[0]);
        }
        int left = 1;
        int right = maxLen;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canCut(L, k, L[mid])){
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return right;

    }

    private boolean canCut(int[] L, int k, int len){
        int sum = 0;
        for(int i = 0; i < L.length; i++){
            sum += L[i] / len;
        }
        return sum >= k;
    }
}

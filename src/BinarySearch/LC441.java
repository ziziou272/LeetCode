package BinarySearch;

public class LC441 {
}
class Solution441 {
    public int arrangeCoins(int n) {
        if(n <= 0) return 0;
        long left = 1, right = n;
        while(left <= right){
            long mid = left + (right - left) / 2;
            long sum = (mid + 1) * mid /2;
            //bs
            if(sum == n)
                return (int)mid;
            else if(sum < n)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return (int)right;
    }
}

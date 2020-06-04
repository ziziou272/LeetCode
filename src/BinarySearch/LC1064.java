package BinarySearch;

public class LC1064 {
}
class Solution1064 {
    public int fixedPoint(int[] A) {
        if(A == null || A.length == 0)
            return -1;
        int left = 0, right = A.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(A[mid] < mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        if(left < 0 || left >= A.length)
            return -1;
        return A[left] == left ? left : -1;
    }
}
/*



-1 -2 -3 -5 2 3 6 10 23 24
              l
              m
            r

0 1 2
l
  m
 r


A[mid] < mid
    go right
else if >=
    go left
else ==
    go left



*/
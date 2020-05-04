package bitOperationDuplicate;
//Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Two.
//Memory Usage: 33.6 MB, less than 7.32% of Java online submissions for Power of Two.
public class LC213BitSolution {
    public boolean isPowerOfTwo(int n) {
        long mask = 1;//防止 2^30 overflow
        while(mask < n){
            mask *= 2;// mask <<= 1;
        }
        return mask == n;
    }
}

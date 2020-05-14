package bitOperation;

public class LC190BitSolution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int temp = ((n >> i) & 1);
            res |= temp <<(31 - i);
        }
        return res;
    }
}

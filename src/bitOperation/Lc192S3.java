package bitOperation;

public class Lc192S3 {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n >>>i & mask) != 0)
                count++;
        }
        return count;
    }
}

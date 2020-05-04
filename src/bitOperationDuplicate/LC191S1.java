package bitOperationDuplicate;
//mask 1 左移
public class LC191S1 {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for(int i =0; i < 32; i++){
            if((n & mask << i) != 0)
                count++;
        }
        return count;
    }
}

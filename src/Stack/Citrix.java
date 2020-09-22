package Stack;

public class Citrix {

}
class Result {

    /*
     * Complete the 'maxXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER lo
     *  2. INTEGER hi
     *  3. INTEGER k
     */

    public static int maxXor(int lo, int hi, int k) {
        // Write your code here
        int max = Integer.MIN_VALUE;
        for(int b = lo; b <= hi; b++){
            for(int a = lo; a < b; a++){
                int xor = a ^ b;
                if(xor <= k)
                    max = Math.max(xor, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxXor(2,4,8));
        System.out.println(maxXor(1,3,3));
    }

}

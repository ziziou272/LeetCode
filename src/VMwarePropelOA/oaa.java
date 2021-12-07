package VMwarePropelOA;

import java.util.List;

public class oaa {
    public static long maxValue(int n, List<List<Integer>> rounds) {
        // Write your code here
        long[] arr = new long[n];
        long max = 0L;
        for(List<Integer> round : rounds){
            int left = round.get(0);
            int right = round.get(1);
            int val = round.get(2);
            for(int i = left-1; i <= right-1; i++){
                arr[i] += val;
                max = Math.max(max, arr[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        try{
            int x = 0;
            for(x=1;x<4;x++);
            System.out.println(x);
        }catch (Exception e){}
        finally {
            System.out.println("Error");
        }
    }
}
/*
*
*
*
* */

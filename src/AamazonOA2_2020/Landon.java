package AamazonOA2_2020;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Landon {
    public static void main(String[] args) {
        System.out.println(digitsManipulations(1000000000));
        System.out.println(digitsManipulations(1010));
    }

    public static int digitsManipulations(int n) {
        long product = 1;
        long sum = 0;
        while (n != 0) {
            product = product * (n % 10);
            sum = sum + n % 10;
            n = n / 10;
        }
        return (int) (product -sum);
    }











/*
    public static long[][][] fileUploadingProgress2(long[][] chunks) {
        List<long[][]> list = new ArrayList<>();
        for(long[] chunk : chunks){
            long a = chunk[0];
            long b = chunk[1];
            if (list.size() == 0){
                list.add(new long[][]{{a, b}});
                continue;
            }
            long[][] matrix = list.get(list.size() - 1);
            List<long[]> copy = copyMatrix(matrix);
            for(int i = 0; i < matrix.length; i++){
                long l = matrix[i][0];
                long r = matrix[i][1];
                if(a >= l){
                    if(a <= r || a + 1 == r){
                        copy.add(new long[]{l, Math.max(r,b)});
                    }
                }else{
                    if(b + 1>= l){
                        copy.add(new long[]{a, Math.max(r,b)});
                    }else{
                        copy.add(new long[]{a, b});
                        i--;
                    }
                }
            }

        }
    }*/
}
/*
[a,b]
* binary search:
* [l,r] :
  if l <= a
        if a < b --> merge
        else(a >= b) search right side --> mid = left + 1
  else(a<l)
        if(b<=r) merge
        else
            mid = left + 1




*
* */

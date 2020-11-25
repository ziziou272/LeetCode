package byteDance;

import java.util.Scanner;

public class incrementalMemoryLeak {
    double[] sum = new double[Integer.MAX_VALUE];
    public static double[] memory(double m1, double m2){
        for(int i = 0; ; i++){
            double diff = Math.abs(m2 - m1);

            if(m1 >= m2){
                if(m1 < i){
                    return new double[]{i, m1, m2};
                }
                m1 -= i;
            }else{
                if(m2 < i)
                    return new double[]{i, m1, m2};
                m2 -= i;
            }
        }
    }

    private void getSum(){
        for(int i = 1; i < Integer.MAX_VALUE; i++){
            sum[i] = sum[i - 1] + i;
        }
    }

    public static void main(String[] args) {
        System.out.println(printArr(memory(2.0,2.0)));
        System.out.println(printArr(memory(8,11)));
        System.out.println(printArr(memory(234234232,343284902)));
        System.out.println(printArr(memory(845,11234)));
        System.out.println(printArr(memory(845236,153611)));
        System.out.println(printArr(memory(Math.pow(10,18),Math.pow(10,18))));
    }

    public static void getInput(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[][] input = new double[n][];
        for(int i = 0; i < n; i++){
            input[i][0] = scanner.nextDouble();
            input[i][1] = scanner.nextDouble();
        }
        for(double[] arr : input){
            memory(arr[0], arr[1]);
        }
    }
    private static String printArr(double[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(double num : arr) {
            sb.append(num);
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}

package VMwarePropelOA;

public class BalancedArray {
    public static void main(String[] args) {
        System.out.println(balancedSum(new int[]{3,1,2,2,3,2,1}));
    }

    public static int balancedSum(int[] arr){
        int[] prevSum = new int[arr.length];
        for(int i = 0; i < prevSum.length; i++){
            prevSum[i] = (i >= 1 ? prevSum[i-1] : 0) + arr[i];
        }
        int sum = 0;
        for(int j = prevSum.length - 1; j >= 0; j--){
            sum += arr[j];
            if(sum == prevSum[j]) return j;
        }
        return -1;
    }
}

/*
* 3 1 2 2 3  2  1
* 3 4 6 8 11 13 14
*       8
*
* */
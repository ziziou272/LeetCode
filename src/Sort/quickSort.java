package Sort;

import java.util.Arrays;

public class quickSort {
    private static void sort(int[] arr){
        //cc
        qSort(0, arr.length - 1, arr);
    }
    private static void qSort(int left, int right, int[] arr){
        if(left >= right) return;
        int p = partition(left, right, arr);
        qSort(left, p - 1, arr);
        qSort(p + 1, right, arr);
    }
    private static int partition(int left, int right, int[] arr){
        /*
        [1,6,3,7,0,8,9]
                     p
                 s
                     f

        small   large   uncheck
        -1       0      0
        []      ()      [)
        0 - s
        s + 1 swap p
         */
        int pivot = arr[right];
        int slow = left - 1;
        for(int fast = left; fast < right; fast++){
            if(arr[fast] < pivot){
                swap(++slow, fast, arr);
            }
        }
        swap(slow + 1, right, arr);
        return slow + 1;
    }
    private static void swap(int left, int right, int[] arr){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static void main(String[] args){
        int[] arr = new int[]{999,1,6,3,31,7,0,8,9,0,-1,21};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

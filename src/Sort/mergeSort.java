package Sort;


import java.util.Arrays;

public class mergeSort {
    public static void sort(int[] arr){
        //todo:cc
        if(arr == null) return;
        int[] helper = new int[arr.length];
        for(int i = 0; i < arr.length; i++) helper[i] = arr[i];
        mergeSort(arr, 0, arr.length - 1, helper);
    }
    private static void mergeSort(int[] arr, int left, int right, int[] helper){
        //base case
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, helper);
        mergeSort(arr, mid + 1, right, helper);

        merge(arr, left, right, mid, helper);
    }
    private static void merge(int[] arr, int left, int right, int mid, int[] helper){
        //[left -> mid]
        //(mid, right]
        int first = left, second = mid + 1;
        int i = first;
        for (int j = left; j <= right; j++) helper[j] = arr[j];
        while (first <= mid && second <= right){
            if(helper[first] < helper[second]){
                arr[i++] = helper[first];
                first++;
            }
            else {
                arr[i++] = helper[second];
                second++;
            }
        }
        while (first <= mid) arr[i++] = helper[first++];
    }
    public static void main(String[] arg){
        int[] arr = new int[]{9,1,6,3,31,7,0,8,9,0,-1,21};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}



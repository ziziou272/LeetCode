package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        temp test = new temp();
        int[] arr = new int[]{-1,0,0,1,0,12,2,1,-2,-3,0,2,0,-7,-9,11,0,-2};
        test.dancingArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
class temp{
    public void dancingArray(int[] A){
        for(int i = -1, j = 0; j < A.length; j++){
            if(A[j] < 0){
                swap(A, i+1, j);
                i++;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

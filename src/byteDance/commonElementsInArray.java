package byteDance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class commonElementsInArray {
    public static List<Integer> getCommonArray(List<Integer> arr1, List<Integer> arr2){
        int[] countOfA = new int[1001];
        int[] countOfB = new int[1001];
        if(arr1 == null || arr2 == null || arr1.size() == 0 || arr2.size() == 0) return null;
        for(int num : arr1){ countOfA[num]++; }
        for(int num : arr2) countOfB[num]++;
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i <= 1000; i++){
            while(countOfA[i] > 0 && countOfB[i] > 0) {
                res.add(i);
                countOfA[i]--;
                countOfB[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
/*
* int[] countOfA = new int[1001];
* int[] countOfB = new int[1001];
*
*
* */

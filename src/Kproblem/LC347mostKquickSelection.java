package Kproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC347mostKquickSelection {
    public class Cell{
        int val;
        int count;
        public Cell(int val, int count){
            this.val = val;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
        [1,1,1,2,2,3,4,4,5,5,5,5,5,6]
        HashMap<num, count>: 1->3  2-2  3-1  4-2  5-5  6-1
        cell{
        int val
        int count
        }
        Cell[] res :
        5-5   1->3  2-2         4-2         3-1             6-1
                    p

        increasing order:
        (5,5)(1,3) 4,2  2,2  3,1  6,1
                                    p
        index = partition()
        */
        //cc
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length < k) return res;
        // nums -> count
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(!map.containsKey(num))
                map.put(num,1);
            else
                map.put(num,map.get(num) + 1);
        }
        //build a array of cell
        Cell[] frequency = new Cell[map.size()];
        int i = 0;
        for(int key : map.keySet()){
            frequency[i++] = new Cell(key, map.get(key));
        }
        //quickSelect
        quickSelect(frequency, k, 0, frequency.length - 1);
        for(int j = 0; j < k; j++){
            res.add(frequency[j].val);
        }
        return res;
    }
    private void quickSelect(Cell[] arr, int k, int left, int right){
        if(left >= right) return;
        int index = partition(arr, k, left, right);
        int rank = index - left + 1;
        if(rank < k){
            quickSelect(arr, k - rank, index + 1, right);
        }
        else if(rank == k) return;
        else{//index > k
            quickSelect(arr, k, left, index - 1);
        }
    }
    private int partition(Cell[] arr, int k, int left, int right){
        /*
        increasing array
        greater  [0,slow]
        smller(slow, right - 1)
        [9,1,7,3]
        */
        int slow = left - 1;
        int pivot = arr[right].count;
        for(int fast = left; fast < right; fast++){
            if(arr[fast].count > pivot)
                swap(++slow, fast, arr);
        }
        swap(slow + 1, right, arr);
        return slow + 1;
    }
    private void swap(int left, int right, Cell[] arr){
        Cell temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

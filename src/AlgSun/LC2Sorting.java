package AlgSun;

import java.util.Arrays;

public class LC2Sorting {
    public static void main(String[] args) {
        int[] arr = new int[]{9,1,6,3,31,7,0,8,9,0,-1,21};
        MergeSort ms = new MergeSort();
        ms.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
//todo: buggy
class MergeSort{
    public void sort(int[] arr){
        //make copy, will make the merge function easier
        int[] copy = new int[arr.length];
        for(int i = 0; i < arr.length; i++) copy[i] = arr[i];
        mergeSort(arr, 0, arr.length - 1, copy);
    }
    private void mergeSort(int[] a, int left, int right, int[] copy){
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid, copy);
        mergeSort(a, mid + 1, right, copy);
        merge(a, left, mid, right, copy);
    }
    private void merge(int[] a, int left, int mid, int right, int[] copy){
        //important to include
        for (int j = left; j <= right; j++) copy[j] = a[j];
        //left part size
        int i = left, j = mid + 1, k = left;
        while(i <= mid && j <= right){
            if(copy[i] < copy[j]){
               a[k++] = copy[i++];
            }else{
                a[k++] = copy[j++];
            }
        }
        while(i <= mid){
            a[k++] = copy[i++];
        }
        while(j <= right){
            a[k++] = copy[j++];
        }
    }
}
class QuickSort{
    public void sort(int[] a){
        quickSort(a, 0, a.length - 1);
    }
    private void quickSort(int[] a, int l, int r){
        if(r <= l) return;
        int index = partition(a, l, r);
        quickSort(a, l, index - 1);
        quickSort(a, index + 1, r);
    }
    //return pivot index
    /*[2,1,6,3,7,0,8]
                   p
     i
       cur
       [l,i] smaller
       [i + 1, cur] larger
    * */
    private int partition(int[] a, int l, int r){
        //base case
        //pivot: pick last index(r)
        int i = l - 1, cur = l;
        while(cur < r){
            //case 1 a[cur] < pivot. swap cur with i+1, i++, cur++
            if(a[cur] < a[r]){
                swap(i+1, cur, a);
                i++;
                cur++;
            }
            //case a[cur] >= pivot, cur++, can be simplified
            else{
                cur++;
            }
        }
        swap(i + 1, r, a);
        return i + 1;
    }
    private void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //todo: 3 way partition
}

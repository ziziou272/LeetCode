package BinarySearch;

public class BinarySearchRecursive {
    public static void main(String[] args){
        BS test = new BS();
        int[] array = new int[]{-11,1,2};
        System.out.println(test.binarySearch(array, 3));
        System.out.println(test.binarySearch(array, 9));
        System.out.println(test.binarySearch(array, -11));
    }
}
class BS{
    public int binarySearch(int[] array, int target){
            return search(target, 0, array.length - 1, array);
    }
    public int search(int target, int left, int right, int[] array){
        if(left > right) return -1;
        int mid = left + (right -left) / 2;
        if(array[mid] == target)
            return mid;
        if(array[mid] > target)
            return search(target, left, mid - 1, array);
        else
            return search(target, mid + 1, right, array);
    }

}

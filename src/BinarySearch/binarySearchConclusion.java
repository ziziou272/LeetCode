package BinarySearch;

public class binarySearchConclusion {

    public static void main(String[] args){
        System.out.println("Testing 1");

    }

}
/**
 * type 1
 * 找出第一个与key相等的元素的位置
 * target = 7
1 2 3 4 4 5 6 7 7 7 7 8 9 10
            r l
*/
class findFirstEqual{
    public int bs(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (left < arr.length && arr[left] == target) ? left : -1;
    }
}
/**
 * type 2
 * 找出最后一个与key相等的元素的位置
 * target = 7
 1 2 3 4 4 5 6 7 7 7 7 8 9 10
                       l
                     r
 */
class findLastEqual{
    public int bs(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return (right >= 0 && arr[right] == target) ? right : -1;
    }
}
/**
 * type 3
 * 找出小于key的最大的元素
 * target = -1
 1 2 3 4 4 5 6 7 7 7 7 8 9 10
 l
             r
 */
class findLargestSmaller{
    public int bs(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right >= 0 ? right : -1;
    }
}
/**
 * type 4
 * 找出大于key的最小的元素
 * target = 12
 1 2 3 4 4 5 6 7 7 7 7 8 9 10
                       l
               m
                     r
 */
class findSmallestLarger{
    public int bs(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left < arr.length ? left : -1;
    }
}
/**
 * type 5
 * 找出最接近key的index,
 * target = 12/-1/8
   1 2 3 4 4 5 6 7 7 7 7 8 10
                         l
                         m
                            r
 */
class findCloset{
    public int bs(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target)
                left = mid;
            else
                right = mid;
        }
        return Math.abs(arr[left] - target) <= Math.abs(arr[right] - target) ? left : right;
    }
}



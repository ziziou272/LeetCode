package SlidingWindowTwoPointer;

public class findLongest {
    public static void main(String[] args) {
                                    //
        System.out.print(findLongest(new int[]{1,1,0,0,1,1,1,0,0,1,1,0,1,0,1,0,0,0,1,0}));
    }

    public static int findLongest(int[] arr){
        int slow = 0, fast = 0;
        int index = -1, max = 0;
        for(; fast < arr.length; fast++){
            if(arr[fast] != 0){
                while (fast < arr.length && arr[fast] != 0){
                    fast++;
                }
                slow = fast;
            }
            if(fast - slow + 1 > max){
                index = slow;
                max = fast - slow + 1;
            }
        }
        return index;
    }
    /*
    * 1 1 0 0 1 1 1 0 0 1 1 1 0 0 0 1 0
    *               s
    *               f
    * if f == 0 update size
    * else
    *   f to find next 0
    *   s = f
    * */
}

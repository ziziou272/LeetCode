package SlidingWindow;

public class LC1052GrumpyBookstoreOwner {
    /*
 s = 1 , f = x;
 x = 3
    1 5 6 1 0 3 0 7 4 1
      s
          f
    0 1 0 1 0 1 1 1 0 1
           index
        5  10
    sum

*/
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //corner case
        int openTime = customers.length;
        if(customers.length != grumpy.length) return 0;
        int slow = 1, fast = X;
        int resIndex = 0, max = 0;
        int curRes = 0;
        for(int i = 0; i < X; i++){
            //grumpy
            if(grumpy[i] == 1)
                curRes += customers[i];
        }
        max = curRes;
        while(fast < openTime){
            if(grumpy[slow - 1] == 1){
                curRes -= customers[slow - 1];
            }
            if(grumpy[fast] == 1)
                curRes += customers[fast];
            if(max < curRes){
                resIndex = slow;
                max = curRes;
            }
            slow++;
            fast++;
        }
        for(int i = resIndex; i <= resIndex + X - 1; i++){
            grumpy[i] = 0;
        }
        int res = 0;
        for(int i = 0; i < openTime; i++){
            if(grumpy[i] == 0)
                res += customers[i];
        }
        return res;
    }
}
/*
*     1 5 6 1 0 3 0 7 4 1
      s
            f
     0 1 0 1 0 1 1 1 0 1
*
*
* */
class solutionV1{
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //corner case
        int openTime = customers.length;
        if(openTime != grumpy.length) return 0;
        int slow = 0, fast = 0;
        int maxChanged = 0;
        int noGrumpyCount = 0;
        int curChanged = 0;
        while(fast < openTime){
            if(grumpy[fast] == 1)
                curChanged += customers[fast];
            else
                noGrumpyCount += customers[fast];
            if(fast - slow == X){
                slow++;
                if(slow - 1 >= 0 && grumpy[slow - 1] == 1) {
                    curChanged -= customers[slow - 1];
                }
            }
            maxChanged = Math.max(curChanged, maxChanged);
            fast++;
        }
        return maxChanged + noGrumpyCount;
    }
}

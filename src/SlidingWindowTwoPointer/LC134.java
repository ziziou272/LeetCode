package SlidingWindowTwoPointer;

public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null)
            return -1;
        int start = gas.length;//start--
        int end = 0;//end++
        int gasLeft = 0;
        while(end < start){
            if(gasLeft >= 0){
                gasLeft += gas[end] - cost[end];
                end++;
            }
            else{
                start--;
                gasLeft += gas[start] - cost[start];
            }
        }
        return gasLeft >= 0 ? (start == gas.length ? 0 : start) : -1;
    }
}

package SlidingWindowTwoPointer;

/**
 * this is my solution easy to understand 54min
 */
class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
        if(gas.length != cost.length) return -1;
        int len = gas.length;
        int i = len - 1, j = len - 1;
        int shortage = cost[j] - gas[j];
        do{
            //can't move j, don't have enough gas
            if(shortage > 0){
                i--;
                if(i == -1){
                    return -1;
                }
                shortage = shortage - (gas[i] - cost[i]);
            }
            else{
                j = (j + 1) % len;
                shortage = shortage - (gas[j] - cost[j]);
            }
        }while(i != j);
        return shortage <= 0 ? j : -1;
    }
}
/*
gas[i]
cost[i]
i to i + 1

gas:    1 2 8 4 1 5 6
cost:   2 5 2 1 3 4 5
                    i
                    j
i: len - 1
j = len - 1
if i < 0
    consumption <= 0  0:-1
if  i == j && not start
    return i;

new index: (j + 1) % len


consumption:
gas need to move j:              -5
                    if cost[j] - gas[j] + carryOut> 0
                        move i -> counterClock
                    else
                        move j


*/
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

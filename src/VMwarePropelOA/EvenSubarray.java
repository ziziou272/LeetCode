package VMwarePropelOA;

import java.util.HashSet;

public class EvenSubarray {
    public static void main(String[] args) {
        /*
        * 1
        * 2
        * 1
        * 2
        * 1 2
        * 1 2
        * 2
        * 2
        * 2 1 2
        * */
        System.out.println(evenSubarray(new int[]{1,2,1,2}, 1));
        System.out.println(evenSubarray(new int[]{1,2,3,4}, 1));
        System.out.println(evenSubarray(new int[]{6,3,5,8}, 1));
    }

    public static int evenSubarray(int[] numbers, int k){
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < numbers.length; i++){
            int odd = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < numbers.length; j++){
                //odd
                if(numbers[j] % 2 != 0){
                    odd++;
                    if(odd > k) break;
                }
                sb.append(numbers[j]);
                if(!set.contains(sb.toString())){
                    set.add(sb.toString());
                    count++;
                }
            }
        }
        return count;
    }
}
/*
k = 1
odd number
[1,2,4,1,2,4]
 i
     j
1,2,4


o(n^2)
*
* */

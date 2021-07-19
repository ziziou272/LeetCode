package VMwarePropelOA;

public class IntelligentSubstring {
    public static void main(String[] args) {
        System.out.println(getSpecialSubstring("abcdeabcaaacbbc",1,"10101111111111111111111111"));
    }

    /* b,d
       101011011111001
         i
               j
    *
    *
    * */
    public static int getSpecialSubstring(String s, int k, String charValue){
        int[] map = new int[26];
        int index = 0;
        for(char cur : charValue.toCharArray()){
            map[index++] = cur-'0';
        }
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = map[s.charAt(i) - 'a'];
        }
        //at most k 0s
        int count = 0;
        int max = 0;
        for(int i = 0, j = 0; j < arr.length; j++){
            if(arr[j] == 0) count++;
            while (count > k && i < j){
                if(arr[i] == 0){
                    count--;
                }
                i++;
            }
            if(count <= k)
                max = Math.max(max, j - i + 1);
        }
        return max;
    }
}

/*
* abcde
* 10101
*   i
*     j
*
*
* */

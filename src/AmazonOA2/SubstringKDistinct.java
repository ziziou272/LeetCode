package AmazonOA2;


public class SubstringKDistinct {
    public static int result(String s, int k){
        return SubstringWithKDistinctChars(s, k) - SubstringWithKDistinctChars(s, k - 1);
    }
    private static int SubstringWithKDistinctChars(String s, int k){
        //cc
        if(k == 0) return 0;
        int res = 0;
            int[] map = new int[256];
            int count = 0;
            int left = 0;
            for(int right = left; right < s.length(); right++){
                map[s.charAt(right)]++;
                if(map[s.charAt(right)] == 1) count++;
                while(left < right && count > k){
                    map[s.charAt(left)]--;
                    if(map[s.charAt(left)] == 0)
                        count--;
                    left++;
                }
                res += right - left + 1;
            }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("12134 k = 2 :" + result("12134",3));
        System.out.println("aabab k = 1 :" + result("aabab",1));
    }
}

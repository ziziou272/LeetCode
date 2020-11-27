package stringAndArray;

import java.util.*;

public class LC13RomanToInteger {
    private static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public int romanToInt(String s) {
        int sum = 0, i = 0;
        while(i < s.length()){
            int val = values.get(s.substring(i, i+1));
            if(i + 1 < s.length()){
                int nextVal = values.get(s.substring(i+1, i+2));
                if(nextVal > val){
                    sum += (nextVal - val);
                    i += 2;
                    continue;
                }
            }
            sum += val;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
    private static int[] userRatingSearch(int[] userRating, int[][] searchInfo){
        int[] res = new int[searchInfo.length];
        int i = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int j = 0; i < userRating.length; i++){
            map.putIfAbsent(userRating[j], new ArrayList<>());
            map.get(userRating[j]).add(j);
        }
        for(int[] info : searchInfo){
            //p
            int l = info[0] - 1;
            int r = info[1] - 1;
            int k = info[2];
            int count = 0;
            //log (k range) * 2
            while(l <= r){
                if(userRating[l++] == k){
                    count++;
                }
            }
            res[i] = count;
            i++;
        }
        return res;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        String s = strs[0];
        int count = Integer.parseInt(strs[1]);
        int len = s.length();
        int[][] record = new int[len][26]; //记录字符串s的每个位置和26个字母的关系
        int[] length = new int[26]; //记录每个字母在规定交换次数内最长的相同字母数量
        for(int i = 0; i < len; i++){
            record[i][s.charAt(i)-'a'] = 1;
        }
        for(int i = 0; i < 26; i++){
            int[] position = new int[len]; //对于每个字母，记录字符串s中出现该字母的位置
            int k = 0; //字符串s中出现该字母k次
            for(int j = 0; j < len; j++){
                if(record[j][i] == 1){
                    position[k] = j;
                    k += 1;
                }
            }
            if(k == 0){
                length[i] = 0;
            }else if(k == 1){
                length[i] = 1;
            }else{
                int answer = Integer.MIN_VALUE;
                for (int p = 0; p < k; p++){
                    for (int q = p+1; q < k; q++){
                        int res = dfsSwichCharacter(p, q, position);
                        if(res <= count){ //在规定交换次数内，更新连续的某个相同字母数量
                            answer = Math.max(answer, q-p+1);
                        }
                    }
                }
                length[i] = answer;
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i : length){
            result = Math.max(result, i);
        }
        System.out.println(result);
    }

    public static int dfsSwichCharacter(int i, int j, int[] position){
        if(i == j){
            return 0;
        }else if(i+1 == j){ //说明字符串s中position[i]和position[j]之间不可能再有该字母，所以移动次数就是坐标之差减一
            return position[j] - position[i] - 1;
        }else{ //移动次数相当于是把position[j]的字母移到position[i]隔壁的次数减去这两个位置之间该字母的个数
            return dfsSwichCharacter(i+1, j-1, position) + position[j]-position[i]-1 - (j-i-1);
        }
    }
}
//nSEb2LznGxNnbP3
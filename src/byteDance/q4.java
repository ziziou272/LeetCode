package byteDance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q4 {
    public static int transform(String source, String target){
        if(source == null && target == null) return 0;
        if(source == null || target == null) return -1;
        if(source.length() != target.length()) return -1;
        if(source.equals(target)) return 0;
        HashMap<Character, Character> map = new HashMap<>();
        char[] sourceCharArr = source.toCharArray();
        char[] targetCharArr = target.toCharArray();
        for(int i = 0; i < source.length(); i++){
            if(sourceCharArr[i] == targetCharArr[i]) continue;
            if(!map.containsKey(sourceCharArr[i])){
                map.put(sourceCharArr[i], targetCharArr[i]);
            }else{
                if(map.get(sourceCharArr[i]) != targetCharArr[i])
                    return -1;
            }
        }
        int sum = 0;
        //dfs
        Boolean[] visit = new Boolean[26];
        for(int i = 0; i < 26; i++){
            if(visit[i] == null && map.containsKey((char)('a' + i))){
                sum += dfs(map, visit, (char)('a' + i), 0);
                visit[i] = false;
            }
        }
        return sum;
    }

    private static int dfs(HashMap<Character, Character> map, Boolean[] visited, char cur, int count){
        if(visited[cur - 'a'] != null && visited[cur - 'a']) return count+1;
        if(visited[cur - 'a'] != null && !visited[cur - 'a']) return count;
        if(!map.containsKey(cur)) return count;
        visited[cur - 'a'] = true;
        int res = dfs(map, visited, map.get(cur), count + 1);
        visited[cur - 'a'] = false;
        return res;
    }

    public static void main(String[] args) {
       // System.out.println(transform("ababcc","cccccc"));
        //System.out.println(transform("ab","ba"));
        //System.out.println(transform("abac","wxyz"));
        //System.out.println(transform("abegafc","bafcbge"));
        //System.out.println(transform2("abegafc","bafcbge"));
        //System.out.println(transform("abegafcz","bafcbgeb"));
        //System.out.println(transform2("abegafcz","bafcbgeb"));
        System.out.println(transform("ac","de"));
    }

    public static int transform2(String source, String target){
        Map<Character, Character> tempMap = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            char c1 = source.charAt(i);
            char c2 = target.charAt(i);

            if (c1 == c2) continue;
            if (tempMap.containsKey(c1) && tempMap.get(c1) != c2) return -1;
            tempMap.put(c1, c2);
        }

        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            char c1 = source.charAt(i);
            char c2 = target.charAt(i);

            if (c1 == c2) continue;
            map.putIfAbsent(c2, new HashSet<>());

            map.get(c2).add(c1);
        }

        int res = 0;
        for (char key : map.keySet()) {
            Set<Character> set = map.get(key);
            res += set.size();
        }

        // Check mutual inclusive
        for (char key : map.keySet()) {
            for (char val : map.get(key)) {
                if (map.containsKey(val) && map.get(val).contains(key)) {
                    map.get(val).remove(key);
                    res += 1;
                }
            }
        }
        return res;
    }
}

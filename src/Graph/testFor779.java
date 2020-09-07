package Graph;

import java.util.*;

public class testFor779 {
    public static void main(String[] args) {
        HashMap<String, List<String>> graph = new HashMap<>();
        graph.put("a", Arrays.asList("b", "d", "c"));
        graph.put("d", Arrays.asList("a", "b", "f", "g"));
        graph.put("c", Arrays.asList("a"));
        graph.put("b", Arrays.asList("a", "d"));
        graph.put("g", Arrays.asList("d"));
        graph.put("f", Arrays.asList("d", "e"));
        graph.put("e", Arrays.asList("f"));
        test779 test = new test779();
        System.out.println(test.shortest(graph,"a","e", new HashSet<String>(), new HashMap<String, Integer>()));
    }
}
class test779{
    public int shortest(HashMap<String, List<String>> graph, String start, String end, HashSet<String> visiting, HashMap<String, Integer> memo){
        if(start.equals(end))
            return 0;
        if(!graph.containsKey(start))
            return -1;
        if(visiting.contains(start))
            return -1;
        if(memo.containsKey(start))
            return memo.get(start);
        visiting.add(start);
        int min = Integer.MAX_VALUE;
        for(String nei : graph.get(start)){
            int len = shortest(graph, nei, end, visiting, memo);
            if(len != -1){
                min = Math.min(min, len+1);
            }
        }
        visiting.remove(start);
        min = min == Integer.MAX_VALUE ? -1 : min;
        memo.put(start, min);
        return min;
    }
}



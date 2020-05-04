package intuit.OA;

import java.util.*;

public class findStartAndEndLocations {
    public static void main(String[] args){
        solutionFindLocation sl1 = new solutionFindLocation();
        String[][] input = new String[][]{
                {"F", "G"},
                {"F", "H"},
                {"G", "I"},
                {"G", "L"},
                {"H", "X"},
                {"I", "Z"},
                {"L", "Z"},
                {"A", "R"},
                {"A", "Q"},
                {"A", "B"},
                {"A", "S"},
                {"E", "W"}
        };
        sl1.findStartAndEndLocations(input);
    }
}
class solutionFindLocation{
    public void findStartAndEndLocations(String[][] input){
        HashMap<String, Integer> inDegree = new HashMap<>();
        HashMap<String, List<String>> graph = new HashMap<>();
        //build the graph
        for(String[] str : input){
            if(!inDegree.containsKey(str[1]))
                inDegree.put(str[1], 1);
            else
                inDegree.put(str[1], inDegree.get(str[1]) + 1);
            if(!inDegree.containsKey(str[0]))
                inDegree.put(str[0], 0);
            if(!graph.containsKey(str[0])){
                graph.put(str[0], new ArrayList<>());
            }
            graph.get(str[0]).add(str[1]);
        }
        //traverse from roots
        List<List<String> > res = new ArrayList<>();
        HashSet<String > visited = new HashSet<>();
        for(String node: inDegree.keySet()){
            if(inDegree.get(node) == 0){
               List<String> level = new ArrayList<>();
               level.add(node);
               findLeaf(level, node, graph, visited);
               res.add(level);
            }
        }
        res.sort((c1, c2) -> c1.get(0).compareTo(c2.get(0)));
        //PRINT THE RESULT
        for(List<String> level : res){
            System.out.print(level.get(0));
            System.out.print(": ");
            level.remove(0);
            Collections.sort(level);
            for(String node : level){
                System.out.print(node);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private void findLeaf(List<String> level, String node, HashMap<String, List<String>> graph, HashSet<String > visited){
        if(visited.contains(node))
            return;
        visited.add(node);
        if(!graph.containsKey(node)){
            level.add(node);
            return;
        }
        for(String neighbor: graph.get(node)){
            findLeaf(level, neighbor, graph, visited);
        }
    }
}

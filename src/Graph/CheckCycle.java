package Graph;

import java.util.HashSet;
import java.util.List;

public class CheckCycle {
    private static class vertex{
        int id;
        /*vertex(int id){
            this.id = id;
        }*/
        List<vertex> toVS;
    }
    public boolean containCycle(List<vertex> list){
        if(list == null||list.size() == 0)
            return false;
        for(vertex v : list){
            if(dfs(v,new HashSet<Integer>()))
                return true;
        }
        return false;
    }
    private boolean dfs(vertex cur, HashSet<Integer> visited){
        if(visited.contains(cur.id))
            return true;
        visited.add(cur.id);
        for(vertex next : cur.toVS){
            if(visited.contains(next.id))
                return true;
        }
        visited.remove(cur.id);
        return false;
    }
}

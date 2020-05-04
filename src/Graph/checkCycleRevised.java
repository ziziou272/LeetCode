package Graph;

import java.util.HashSet;
import java.util.List;

public class checkCycleRevised {

    private static class vertex{
        int id;
        /*vertex(int id){
            this.id = id;
        }*/
        status status;
        List<vertex> toVS;
    }

    private enum status{
        INITIAL,
        VISITING,
        VISITED
    }
    private boolean dfs(vertex cur){
        if(cur.status == status.VISITED)
            return false;
        if(cur.status == status.VISITING)
            return true;
        cur.status = status.VISITING;
        for(vertex next:cur.toVS){
            dfs(next);
        }
        cur.status = status.VISITED;
        return false;
    }

    public boolean checkCycle(List<vertex> list){
        for(vertex next:list){
            if(dfs(next))
                return true;
        }
        return false;
    }
}

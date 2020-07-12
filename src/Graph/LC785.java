package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC785 {
    /**
     * it may be several connected graphs
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        //color white -> true or red->false, initial -> null
        Boolean[] color = new Boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(color[i] == null){
                //color white
                color[i] = true;
                queue.offer(i);
            }
            while(!queue.isEmpty()){
                int cur = queue.poll();
                boolean curColor = !color[cur];
                for(int next : graph[cur]){
                    if(color[next] == null){
                        color[next] = curColor;
                        queue.offer(next);
                    }
                    else if(color[next] != curColor)
                        return false;
                }
            }
        }
        return true;
    }
}

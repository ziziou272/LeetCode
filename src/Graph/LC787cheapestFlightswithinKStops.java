package Graph;

import java.util.*;

public class LC787cheapestFlightswithinKStops {
}

class SolutionBFS {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //build graphs:city,[des,cost]
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        //min cost from src to other cites
        HashMap<Integer,Integer> costMap = new HashMap<>();
        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(new int[]{to, cost});
        }
        if(!map.containsKey(src))
            return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        costMap.put(src, 0);
        int res = Integer.MAX_VALUE;
        while(K-- >= 0 && !queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
                int[] pair = queue.poll();
                int cur = pair[0];
                int preCost = pair[1];
                if(map.containsKey(cur)){
                    for(int[] flight: map.get(cur)){
                        int des = flight[0];
                        int cost = flight[1] + preCost;
                        if(des ==dst)
                            res = Math.min(res, cost);
                        if(!costMap.containsKey(des) || cost < costMap.get(des)){
                            queue.offer(new int[]{des, cost});
                            costMap.put(des, cost);
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
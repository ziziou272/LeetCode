package Graph;

import java.util.*;

public class LC332recobstructIniteray {
    public static void main(String[] args) {

            List<List<String>> tickets = new ArrayList<>();


            List<String> ret = new SolutionLC332().findItinerary(tickets);

            System.out.print(ret);

    }
}
//没有利用欧拉回路的性质
class SolutionLC332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        //build graph
        HashMap<String, PriorityQueue<String>> graph= new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!graph.containsKey(from)){
                graph.put(from, new PriorityQueue<>());
            }
            graph.get(from).offer(to);
        }
        int total = tickets.size() + 1;
        //start from JFK
        List<String> res = new ArrayList<>();
        res.add("JFK");
        connect(graph, "JFK", res, total);
        return res;
    }

    private boolean connect( HashMap<String, PriorityQueue<String>> graph, String cur, List<String> res, int total){
        if(res.size() == total) {
            return true;
        }
        if(!graph.containsKey(cur)) return false;
        PriorityQueue<String> queue = graph.get(cur);
        int size = queue.size();
        for(int i = 1; i <= size; i++){
            int count = i;
            String next = null;
            List<String> tempList = new ArrayList<>();
            while(count-- > 0){
                next = queue.poll();
                if(count > 0)
                    tempList.add(next);
            }
            for(String str : tempList){
                queue.offer(str);
            }
            res.add(next);
            if(connect(graph, next, res, total))
                return true;
            res.remove(res.size() - 1);
            queue.offer(next);
        }
        return false;
    }
}
class solutionEulerian{
    public List<String> findItinerary(List<List<String>> tickets) {
        //build graph
        HashMap<String, PriorityQueue<String>> graph= new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!graph.containsKey(from)){
                graph.put(from, new PriorityQueue<>());
            }
            graph.get(from).offer(to);
        }
        int total = tickets.size() + 1;
        //start from JFK
        List<String> res = new LinkedList<>();
        connect(graph, "JFK", res);
        return res;
    }

    private void connect( HashMap<String, PriorityQueue<String>> graph, String cur, List<String> res){
        PriorityQueue<String> queue = graph.get(cur);
        if(queue == null) {
            res.add(0, cur);
            return;
        }
        while (!queue.isEmpty()){
            String next = queue.poll();
            connect(graph, next, res);
        }
        res.add(0, cur);
    }
}
/*
to build graph
//ordered
HashMap<String, Queue<String>>


*/

package Graph;

import java.util.*;

class Vertex{
     String id;
     String parent;
     int discoverTime;
     int lowTime;
     boolean visited;
     boolean colored;

    public Vertex(String id){
        this.id = id;
        visited = false;
        discoverTime = Integer.MAX_VALUE;
        lowTime = Integer.MAX_VALUE;
        parent = null;
    }
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) return false;
        Vertex vertex = (Vertex) obj;
        return id.equals(vertex.id);
    }
    @Override
    public String toString() {
        return id;
    }
}

public class FindArticulationPoints {
    public static void main(String[] args) {
        FindArticulationPointsSolution solution = new FindArticulationPointsSolution();
        HashMap<Vertex, LinkedList<Vertex>> graph = new HashMap<>();
        Vertex[] arr = new Vertex[23];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Vertex(Character.toString('a' + i));
        }
        //a0 b1 c2 d3 e4 f5 g6 h7 i8 j9 k10 l11 m12 n13 o14 p15 q16 r17 s18 t19 u20 v21 w22
        graph.put(arr[0], new LinkedList<Vertex>(Arrays.asList(arr[1],arr[2],arr[3])));
        graph.put(arr[1], new LinkedList<Vertex>(Arrays.asList(arr[0],arr[2],arr[3])));
        graph.put(arr[2], new LinkedList<Vertex>(Arrays.asList(arr[1],arr[3],arr[0], arr[6])));
        graph.put(arr[3], new LinkedList<Vertex>(Arrays.asList(arr[1],arr[2],arr[0])));
        graph.put(arr[4], new LinkedList<Vertex>(Arrays.asList(arr[5],arr[6])));
        graph.put(arr[5], new LinkedList<Vertex>(Arrays.asList(arr[4],arr[6])));
        graph.put(arr[6], new LinkedList<Vertex>(Arrays.asList(arr[4],arr[5],arr[7], arr[9], arr[2],arr[11])));
        graph.put(arr[7], new LinkedList<Vertex>(Arrays.asList(arr[6],arr[8],arr[9])));
        graph.put(arr[8], new LinkedList<Vertex>(Arrays.asList(arr[7])));
        graph.put(arr[9], new LinkedList<Vertex>(Arrays.asList(arr[6],arr[7])));
        //kl km
        graph.put(arr[10], new LinkedList<Vertex>(Arrays.asList(arr[11],arr[12])));
        //l-g l-k l-n
        graph.put(arr[11],new LinkedList<Vertex>(Arrays.asList(arr[6],arr[10],arr[13])) );
        //mk mn mo
        graph.put(arr[12], new LinkedList<Vertex>(Arrays.asList(arr[10],arr[13],arr[14])));
        //nl nm
        graph.put(arr[13], new LinkedList<Vertex>(Arrays.asList(arr[11],arr[12])));
        //om oq or
        graph.put(arr[14], new LinkedList<Vertex>(Arrays.asList(arr['r'-'a'],arr['q'-'a'])));
        // pr pq pw
        graph.put(arr[15], new LinkedList<Vertex>(Arrays.asList(arr['r'-'a'],arr['q'-'a'],arr['w'-'a'])));
        //q -> p, o w r
        graph.put(arr[16], new LinkedList<Vertex>(Arrays.asList(arr['p'-'a'],arr['w'-'a'],arr['o'-'a'],arr['r'-'a'])));
        //r-> o q u v
        graph.put(arr[17], new LinkedList<Vertex>(Arrays.asList(arr['o'-'a'],arr['q'-'a'],arr['u'-'a'],arr['v'-'a'])));
        //s -> t, u
        graph.put(arr[18], new LinkedList<Vertex>(Arrays.asList(arr['t'-'a'],arr['u'-'a'])));
        //t -> s u
        graph.put(arr[19],new LinkedList<Vertex>(Arrays.asList(arr['s'-'a'],arr['u'-'a'])) );
        //u -> s t r
        graph.put(arr[20], new LinkedList<Vertex>(Arrays.asList(arr['r'-'a'],arr['s'-'a'],arr['t'-'a'])));
        //v -> r
        graph.put(arr[21],new LinkedList<Vertex>(Arrays.asList(arr['r'-'a'])));
        //w -> q p
        graph.put(arr[22], new LinkedList<Vertex>(Arrays.asList(arr['p'-'a'],arr['q'-'a'])));
        System.out.println(solution.findAll(graph, arr));


    }

}

class FindArticulationPointsSolution{
    List<Vertex> res;
    ArrayList<String> bridges;
    HashMap<Vertex, LinkedList<Vertex>> graph;
    HashMap<Integer, HashSet<String>> biConnected = new HashMap<>();
    Stack<String> stack = new Stack<>();
    Vertex[] arr;
    int k = 1;
    int kk = 1;

    public List<Vertex> findAll(HashMap<Vertex, LinkedList<Vertex>> graph, Vertex[] arr){
        this.graph = graph;
        this.arr = arr;
        int[] count = new int[1];
        this.res = new ArrayList<>();
        this.bridges = new ArrayList<>();
        for(Map.Entry<Vertex, LinkedList<Vertex>> entry: graph.entrySet()){
            Vertex vertex = entry.getKey();
            if(!vertex.visited){
                dfs(vertex, graph, count, res, bridges);
            }
        }
        System.out.println(bridges);
        //remove bridge
        removeBridge();
        markK();
        //System.out.println(biConnected);
        return res;
    }

    /**
     * calculate v.low of each vertices
     */
    private void dfs(Vertex cur, HashMap<Vertex, LinkedList<Vertex>> graph, int[] count, List<Vertex> res, List<String> bridges){
        cur.discoverTime = count[0]++;
        cur.lowTime = cur.discoverTime;
        if(!graph.containsKey(cur)) return;
        List<Vertex> nexts = graph.get(cur);
        cur.visited = true;
        int numOfChildren = 0;
        boolean findOne = false;
        for(int i = 0; i < nexts.size(); i++){
            Vertex next = nexts.get(i);
            if(!next.visited){
                stack.push(cur.id+next.id);
                next.parent = cur.id;
                dfs(next, graph, count, res, bridges);
                //mark articulation point
                if(cur.discoverTime <= next.lowTime)
                    findOne = true;
                //add bridge
                if(cur.discoverTime < next.lowTime)
                    bridges.add(cur.id + "-" + next.id);
                if(cur.lowTime > next.lowTime)
                    cur.lowTime = next.lowTime;
                numOfChildren++;

            }
            else{
                if(!next.id.equals(cur.parent) && cur.lowTime > next.discoverTime){
                    cur.lowTime = next.discoverTime;
                    stack.push(cur.id+next.id);
                }
            }
        }
        //non-root
        if(findOne && numOfChildren != 0 && cur.parent != null){
            res.add(cur);

        }
        //root
        if(cur.parent == null && numOfChildren > 1){
            res.add(cur);
        }
    }

    private void removeBridge(){
        for(int i = 0; i < bridges.size(); i++){
            String bridge = bridges.get(i);
            Vertex from = arr[bridge.charAt(0) - 'a'];
            Vertex to = arr[bridge.charAt(2) - 'a'];
            this.graph.get(from).remove(to);
            this.graph.get(to).remove(from);
        }
    }

    private void markK(){
        int bcc = 0, k = 0;
        for(Map.Entry<Vertex, LinkedList<Vertex>> entry: graph.entrySet()){
            Vertex vertex = entry.getKey();
            if(!vertex.colored && graph.get(vertex).size() != 0){
                k++;
                dfs2(vertex, k);
            }
        }
    }

    private void dfs2(Vertex cur, int bcc){
        cur.colored = true;
        List<Vertex> nexts = graph.get(cur);
        for(int i = 0; i < nexts.size(); i++){
            if(!biConnected.containsKey(bcc)){
                biConnected.put(bcc, new HashSet<String>());
            }
            Vertex next = nexts.get(i);
            if(!biConnected.get(bcc).contains(cur.id+next.id) && !biConnected.get(bcc).contains(next.id+cur.id))
                biConnected.get(bcc).add(cur.id + next.id);
            if(!next.colored){
                dfs2(next, bcc);
            }
        }
    }
}

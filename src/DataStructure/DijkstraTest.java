package DataStructure;

import java.util.*;

public class DijkstraTest {
    public static void main(String[] args){
        //build up the graph
        GraphNode node1 = new GraphNode("1");
        GraphNode node2 = new GraphNode("2");
        GraphNode node3 = new GraphNode("3");
        GraphNode node4 = new GraphNode("4");
        GraphNode node5 = new GraphNode("5");
        GraphNode node6 = new GraphNode("6");
        //add neighbors for node1
        node1.addNeighbors(node2, 8);
        node1.addNeighbors(node3, 10);
        node1.addNeighbors(node6, 15);
        //add neighbors for node2
        node2.addNeighbors(node3, 11);
        node2.addNeighbors(node4, 16);
        //add neighbors for node3
        node3.addNeighbors(node6, 3);
        node3.addNeighbors(node4, 12);
        //add neighbors for node6
        node6.addNeighbors(node5, 10);
        //add neighbors for node5
        node5.addNeighbors(node4, 7);
        Dijkstra test = new Dijkstra();
        test.printShortestPath(node1);
        System.out.println("----------------------");
        System.out.println("Here is another test: ");
        System.out.println("----------------------");
        //build the graph2
        GraphNode testNode0 = new GraphNode("0");
        GraphNode testNode1 = new GraphNode("1");
        GraphNode testNode2 = new GraphNode("2");
        GraphNode testNode3 = new GraphNode("3");
        GraphNode testNode4 = new GraphNode("4");
        GraphNode testNode5 = new GraphNode("5");
        GraphNode testNode6 = new GraphNode("6");
        GraphNode testNode7 = new GraphNode("7");
        //add neighbors for node0
        testNode0.addNeighbors(testNode1, 5);
        testNode0.addNeighbors(testNode7, 8);
        testNode0.addNeighbors(testNode4, 9);
        //add neighbors for node1
        testNode1.addNeighbors(testNode3, 15);
        testNode1.addNeighbors(testNode2, 11);
        testNode1.addNeighbors(testNode7, 4);
        //add neighbors for node2
        testNode2.addNeighbors(testNode3, 3);
        testNode2.addNeighbors(testNode6, 11);
        //add neighbors for node3
        testNode3.addNeighbors(testNode6, 9);
        //add neighbors for node4
        testNode4.addNeighbors(testNode5, 4);
        testNode4.addNeighbors(testNode6, 20);
        testNode4.addNeighbors(testNode7, 5);
        //add neighbors for node5
        testNode5.addNeighbors(testNode2, 1);
        testNode5.addNeighbors(testNode6, 13);
        //add neighbors for node7
        testNode7.addNeighbors(testNode2, 7);
        testNode7.addNeighbors(testNode5, 6);
        Dijkstra test2 = new Dijkstra();
        test2.printShortestPath(testNode0);
    }
}
class Dijkstra{
    /**
     * this function is to print the shortest distance
     * @param start node of the graph
     */
    public void printShortestPath(GraphNode start){
        //overriding the comparator to compare the distance of each node
        PriorityQueue<GraphNode> minHeap = new PriorityQueue<>((a, b)-> a.getDistance() - b.getDistance());
        //set the distance of start node to 0
        start.setDistance(0);
        //offer start node to zero
        minHeap.offer(start);
        //add start node as the start node
        start.getShortestPath().addLast(start);
        //check duplicated
        HashSet<GraphNode> visited = new HashSet<>();
        while (!minHeap.isEmpty()){
            GraphNode cur = minHeap.poll();
            //set visited to avoid visit again
            visited.add(cur);
            printPath(cur);
            //traverse the neighbors of cur node
            for(GraphNode nei : cur.getNeighbors().keySet()){
                //if visited continue
                if(visited.contains(nei)) continue;
                //the min distance that has been marked from start to this node(nei)
                // if has not been marked the value would be initial value: Integer.MAX_VAlUE
                int neiDistance = nei.getDistance();
                //the distance from start node to this node(nei)
                int curDistance = cur.getDistance() + cur.getNeighbors().get(nei);
                //if neiDistance equals Integer.MAX_VAlUE it means it has not been marked before so it not in heap
                if(neiDistance == Integer.MAX_VALUE){
                    nei.setDistance(curDistance);
                    minHeap.offer(nei);
                    //update path
                    updateShortestPath(cur, nei);
                }
                //nei already in the heap
                //update the distance of node nei
                else if(neiDistance > curDistance) {
                    nei.setDistance(curDistance);
                    //update the minHeap
                    minHeap.remove(nei);
                    minHeap.offer(nei);
                    //update path
                    updateShortestPath(cur, nei);
                }
            }
        }
    }

    /**
     * this function do the print
     * @param node the shortest path from node to target node
     */
    private void printPath(GraphNode node){
        //print the shortest path
        System.out.println("The shortest path from start node " + node.getShortestPath().getFirst().name + " to node "+ node.name + " is: ");
        for (GraphNode graphNode : node.getShortestPath()) {
            System.out.print(graphNode.name);
            if(graphNode != node.getShortestPath().getLast())
                System.out.print("->");
            else
                System.out.println();
        }
        System.out.println("The distance is: " + node.getDistance());
    }

    /**
     * this function is to update the shortest path
     * @param prev previous
     * @param cur current node
     */
    private void updateShortestPath(GraphNode prev, GraphNode cur){
        cur.setShortestPath(prev.getShortestPath());
        cur.getShortestPath().addLast(cur);
    }
}

/**
 * this is the class of graph node
 */
class GraphNode{
    public String name;
    //distance from start node to current node
    private int distance;
    //shortest path from start to current node
    private LinkedList<GraphNode> shortestPath;
    //hash map to store distance to neighbors
    private Map<GraphNode, Integer> neighbors;

    //constructor
    public GraphNode(String name) {
        this.name = name;
        //the initial value would be set to Integer.MAX_VALUE so that we can now is the initial status
        this.distance = Integer.MAX_VALUE;
        neighbors = new HashMap<>();
        shortestPath = new LinkedList<>();
    }

    public void addNeighbors(GraphNode node, int distance){
        this.neighbors.put(node, distance);
    }

    public Map<GraphNode, Integer> getNeighbors() {
        return new HashMap<>(neighbors);
    }

    public void setNeighbors(Map<GraphNode, Integer> neighbors) {
        this.neighbors = new HashMap<>(neighbors);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        if(distance < 0){
            System.out.println("This algorithm can't calculate Negative Distance");
            System.exit(-1);
        }
        else
            this.distance = distance;
    }


    public LinkedList<GraphNode> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<GraphNode> shortestPath) {
        this.shortestPath = new LinkedList<>(shortestPath);
    }
}
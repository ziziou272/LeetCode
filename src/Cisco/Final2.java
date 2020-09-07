import java.util.*;

public class Final2 {

    private static class Node {
        int val;
        List<Node> children;

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    private static class Item {
        private Node node;
        private double prob;
        public Item(Node node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public static Map<Node, Double> leafProb(Node root) {
        // init queue
        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(root, 1));

        // init res
        Map<Node, Double> map = new HashMap<>();

        // bfs
        while (!queue.isEmpty()) {
            // poll out a item
            Item item = queue.poll();
            Node node = item.node;
            double prob = item.prob;

            // if this is leaf node, add to res
            if (node.children == null) map.put(node, prob);

            // if not leaf, then add children to queue
            else {
                for (Node child: node.children) {
                    queue.offer(new Item(child, prob / node.children.size()));
                }
            }
        }

        return map;
    }
}

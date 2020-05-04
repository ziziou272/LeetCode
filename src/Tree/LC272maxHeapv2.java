package Tree;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC272maxHeapv2 {

    /*

                    4
                   / \              k = 5  target = 3.7
                  2   5
                 / \
                1   3

    maxHeap<Value> when we traversing the tree offer number into heap if the diff is smaller the top of the heap or size of heap smaller than k
    after we traversed the tree, the values that remains in heap are the value that we need.
    we store value of node to heap but override the comparator to let them compare the differences

    time complexity: n * logn

    */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        //corner case
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (int) (Math.abs(b - target) - Math.abs(a - target)));
        //traverse the tree
        //recursion to traverse
        traverse(root, target, k, maxHeap);
        while(k-- > 0){
            res.add(maxHeap.poll());
        }
        return res;
    }
    private void traverse(TreeNode root, double target, int k, PriorityQueue<Integer> maxHeap){
        if(root == null) return;
        double difference = Math.abs(root.val - target);
        if(maxHeap.size() < k)
            maxHeap.offer(root.val);
        else if(difference < maxHeap.peek()){
            maxHeap.poll();
            maxHeap.offer(root.val);
        }
        traverse(root.left, target, k , maxHeap);
        traverse(root.right, target, k , maxHeap);
    }
}

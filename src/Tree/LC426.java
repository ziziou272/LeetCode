package Tree;

public class LC426 {
}
class SolutionLC426 {
    //todo: 1. no global variable
    // 2. stack?
    Tree.Node head = null, tail = null, prev = null;
    public Tree.Node treeToDoublyList(Tree.Node root) {
        if(root == null) return null;
        helper(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    private void helper(Tree.Node root){
        if(root == null) return;
        helper(root.left);
        if(prev != null){
            prev.right = root;
            root.left = prev;
        }else{
            head = root;
        }
        prev = root;
        tail = root;
        helper(root.right);
    }

    class Node {
        public int val;
        public Tree.Node left;
        public Tree.Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Tree.Node _left, Tree.Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}


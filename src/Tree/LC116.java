package Tree;

public class LC116 {
}
class SolutionLC116 {
    public Node connect(Node root) {
        Node cur = root;
        Node leftMost = null;
        Node prev = null;
        while(cur != null){
            while(cur != null){
                //check left child
                if(cur.left != null){
                    if(leftMost == null)
                        leftMost = cur.left;
                    if(prev != null)
                        prev.next = cur.left;
                    prev = cur.left;
                }
                //right child
                if(cur.right != null){
                    if(leftMost == null)
                        leftMost = cur.right;
                    if(prev != null)
                        prev.next = cur.right;
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = leftMost;
            leftMost = null;
            prev = null;
        }
        return root;
    }
}
/*
 cur                      1
 leftMost           2           3
              4           5         6
            7   8




*/
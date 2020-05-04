package Tree;

import com.main.TreeNode;

public class LC450 {

    /*
        case 1: one child or no child
        case 2: 2 children
        to reduce the modification of this tree
        we can find the samlleset node on the left or the largest value on the left   and replace root's value with it
        let's find the smallest value on the right node then replace the root with this value, and delted th node we found.
        we can use recursion to do this, since the node we found could possibly have right node, so recursion can helpe us deal with it
        then delete the node we found


*/
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(root.val == key){
            //no empty
            if(root.right != null && root.left != null){
                root.val = findMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
            else {
                root = root.left == null ? deleteNode(root.right, key): deleteNode(root.left, key);
            }

        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private int findMin(TreeNode root){
        int min = root.val;
        while (root.left != null)
        {
            root = root.left;
        }
        return root.val;
    }
}

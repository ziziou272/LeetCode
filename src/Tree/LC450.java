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

    /**
     * most updated solution
     1. it is possible the root will be deleted so, if it was,
     updated the root val to new val instead deleted root and deleted the node with that val
     2. there are 3 situations od deleting a node
     a. no child/leaf -> just delete it
     b. onde child -> let cur node = the child node
     c. 2 children -> find the max in the left subtree, select that node ass new root and deleted this max node from left subtree
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left != null && root.right != null){
                TreeNode maxNode = findMax(root.left);
                root.val = maxNode.val;
                root.left = deleteNode(root.left, root.val);
            }else{
                root = root.left == null ? root.right : root.left;
            }
        }
        return root;
    }
    private TreeNode findMax(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
}

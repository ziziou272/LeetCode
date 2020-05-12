package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class SortedBinaryTree {
    private static class BSTNode{
        int data;
        BSTNode left;
        BSTNode right;
        public  BSTNode(int data){
            this.data = data;
        }
    }
    // createNode(data) returns pointer to node
    public static BSTNode createNode(int data){
        return new BSTNode(data);
    }
    ////• insert(root,nodePtr) insert node pointed to by nodePtr into tree pointed to by root,
    // return true if successful, false otherwise
    public static boolean insert(BSTNode root, BSTNode newNode){
        if(root == null)
            return false;
        //find the right place to put new node
        BSTNode cur = root;
        BSTNode prev = null;
        while(cur != null){
            //go right
            prev = cur;
            if(cur.data < newNode.data)
                cur = cur.right;
            else if(cur.data > newNode.data)
                cur = cur.left;
            else{//equals insert to right
                BSTNode temp = cur.right;
                cur.right = newNode;
                newNode.right = temp;
                return true;
            }
        }
        if(prev.data < newNode.data)
            prev.right = newNode;
        else
            prev.left = newNode;
        return true;
    }
    //isEmpty(root) returns true if tree pointed to by root is empty
    public static boolean isEmpty(BSTNode root){
        return root == null;
    }

    // find(root,data)
    public static boolean find(BSTNode root, int data){
        while(root != null){
            if(root.data == data)
                return true;
            else if(root.data < data)
                root = root.right;
            else
                root = root.left;
        }
        return false;
    }
    //findAndDelete

    public static boolean findAndDelete(BSTNode root, int data){
        boolean[] find = new boolean[1];
        deleteNode(root, data, find);
        return find[0];
    }
    private static BSTNode deleteNode(BSTNode root, int key, boolean[] find) {
        if(root == null)
            return null;

        if(root.data == key){
            //no empty
            if(root.right != null && root.left != null){
                root.data = findMin(root.right);
                root.right = deleteNode(root.right, root.data, find);
            }
            else {
                root = root.left == null ? deleteNode(root.right, key, find): deleteNode(root.left, key, find);
            }
            find[0] = true;
        }
        else if(root.data < key){
            root.right = deleteNode(root.right, key, find);
        }
        else{
            root.left = deleteNode(root.left, key, find);
        }
        return root;
    }

    private static int findMin(BSTNode root){
        int min = root.data;
        while (root.left != null)
        {
            root = root.left;
        }
        return root.data;
    }

    public static void walkInOrder(BSTNode root){
        if(root == null) return;
        walkInOrder(root.left);
        System.out.print(root.data + " ");
        walkInOrder(root.right);
    }
    public static void walkPreOrder(BSTNode root){
        if(root == null) return;
        System.out.print(root.data + " ");
        walkPreOrder(root.left);
        walkPreOrder(root.right);
    }
    public static void walkPostOrder(BSTNode root){
        if(root == null) return;
        walkPostOrder(root.left);
        walkPostOrder(root.right);
        System.out.print(root.data + " ");
    }
    public static void walkBreadthFirst(BSTNode root){
        if(root == null) return;
        Queue<BSTNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            BSTNode cur = queue.poll();
            System.out.print(cur.data + " ");
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null) queue.offer(cur.right);
        }
    }
    public static boolean findAndDeleteAll(BSTNode root, int data){
        boolean find = false;
        while(findAndDelete(root, data)){
            find = true;
        }
        return find;
    }
    public static void main(String[] args) {
        int[] a = new int[]{15, 8, 53, 101, 4, 22, 3, 27, 1, 0, -3, 7, 12, 10, 5, 1, 8};

        // Test Empty Tree
        BSTNode root = null;
        System.out.println("Test isEmpty? " + isEmpty(root));
        // Walk and delete empty tree
        walkInOrder(root);
        System.out.println("Find and delete 5: " + findAndDeleteAll(root, 5));

        // create root node
        root = createNode(11);

        // build tree
        for (int anA : a) {
            BSTNode newNode = createNode(anA);
            insert(root, newNode);
        }

        // check traversal methods
        System.out.println("************** InOrder *****************");
        walkInOrder(root);
        System.out.println("************** PreOrder *****************");
        walkPreOrder(root);
        System.out.println("************** PostOrder *****************");
        walkPostOrder(root);
        System.out.println("************** BreadthFirst *****************");
        walkBreadthFirst(root);
        System.out.println("********** Test Other Methods *************");

        // check find and findAndDeleteAll
        System.out.println("Number 22 in tree?  " + find(root, 22) );
        System.out.println("Number 1 in tree?  " + find(root, 1));
        System.out.println("Deleting number 1");
        findAndDeleteAll(root, 1);
        System.out.println("Number 1 in tree?  " + find(root, 1));
        System.out.println("************** InOrder (No 1's)*****************");
        walkInOrder(root);

        System.out.println("********** More Test *************");

        // check find and findAndDeleteAll
        System.out.println("Number 27 in tree?  " + find(root, 100) );
        System.out.println("Inserting number 27");
        BSTNode newRoot = createNode(27);
        insert(root, newRoot);
        System.out.println("Number 27 in tree?  " + find(root, 27) );
        System.out.println("Deleting number 100");
        findAndDeleteAll(root, 27);
        System.out.println("Number 27 in tree?  " + find(root, 27));
        System.out.println("************** InOrder (No 27's)*****************");
        walkInOrder(root);
    }
}

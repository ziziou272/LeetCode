package Tree;

import com.main.ListNode;
import com.main.TreeNode;

public class convertSortedListToBinarySearchTreeLC109 {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //get size
        ListNode cur = head;
        ListNode[] root = new ListNode[1];
        root[0] = head;
        int size = 0;
        while(cur != null){
            cur = cur.next;
            size++;
        }
        return helper(0, size - 1, root);
    }
    public TreeNode helper(int left, int right, ListNode[] root){
        if(left > right)
            return null;
        int mid = left + (right - left) / 2;
        //go left
        TreeNode leftNode = helper(left, mid - 1, root);
        TreeNode curRoot = new TreeNode(root[0].val);
        root[0] = root[0].next;
        //go right
        TreeNode rightNode = helper(mid + 1, right, root);
        curRoot.left = leftNode;
        curRoot.right = rightNode;
        return curRoot;
    }
}
/*
//follow up of 108
108是个array
因为是个linked list没有对应的坐标，无法轻易地找到mid
所以可以通过按list上从左到右的顺序加TreeNode， 加完一个下个treenode就是listnode的next
这样就可以免去寻找mid的痛苦

m = l + (r - l) / 2

 1 3 4 5 7 9
     r
 1 3   5 7 9
  1      7
   3    5  9

    4
  3    7
1    5   9

*/

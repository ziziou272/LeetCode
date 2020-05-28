package SlidingWindowTwoPointer;

import com.main.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode i = head, j = head.next, d = dummy;
        while(i != null){
            if(j != null && i.val == j.val){
                while(j != null && i.val == j.val){
                    j = j.next;
                }
                //disconnect
                i.next = null;
                i = j;
                j = j == null ? null : j.next;
            }
            else{
                d.next = i;
                i.next = null;
                i = j;
                j = j == null ? null : j.next;
                d = d.next;
            }
        }
        return dummy.next;
    }
}
/*
cur = 1
d 3
1 1 1 3 4 4 5 6
            i
            j

i head
j head.next
while(i != null)
    if same
        while same and j not null{
            j = j.next;
        }
        i = j
        j = j.next
    else
        d.next = i;
        i = j
        j = j.next;
        d = d.next;
*/
public class LC82 {
}

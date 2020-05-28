package SlidingWindowTwoPointer;

import com.main.ListNode;

/**
 * 这个solution要简洁很多
 */
class Solution82Better {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode d = dummy, prev = head, cur = head.next;
        while(cur != null){
            while(cur != null && cur.val == prev.val){
                cur = cur.next;
            }
            if(prev.next == cur){
                d.next = prev;
                d = d.next;
            }
            prev = cur;
        }
        d.next = null;
        return dummy.next;
    }
}
/*
dummy.next = head
          d
d 1 1 1 2 2 3 4 4 5
              i
                  j
[i,j)
    while same
        j++
    if(i.next == j)
        dummy.next = j;
        dummy = dummy.next
    i = j
dummy.next = null
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

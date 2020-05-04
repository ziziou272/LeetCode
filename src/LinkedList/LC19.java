package LinkedList;

import com.main.ListNode;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(n-- > 0){
            //make sure n is valid
            if(fast == null)
                return null;
            fast = fast.next;
        }
        ListNode prev = null;
        while(fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        ListNode next = slow.next;
        if(prev != null){
            prev.next = next;
            slow.next = null;
            return head;
        }
        return next;
    }
}

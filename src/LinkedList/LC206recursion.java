package LinkedList;

import com.main.ListNode;
//先recursion call 再办事
public class LC206recursion {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
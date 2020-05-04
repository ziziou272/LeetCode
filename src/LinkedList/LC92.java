package LinkedList;

import com.main.ListNode;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode left = cur;
        ListNode right = null;
        for(int i = 1; i < m; i++){
            left = cur;
            cur = cur.next;
        }
        ListNode oldStart = cur;
        ListNode next = null;
        ListNode prev = null;
        for(int i = m; i <= n; i++){
            if(i == n){
                if(cur.next == null)
                    right = null;
                else
                    right = cur.next;
            }
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        oldStart.next = right;
        if(m != 1){
            left.next = prev;
            return head;
        }
        return prev;
    }
}

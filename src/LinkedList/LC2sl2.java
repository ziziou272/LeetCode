package LinkedList;

import com.main.ListNode;

public class LC2sl2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, temp = newNode;
        int carry = 0;
        while(cur1 != null || cur2 != null){
            int val1 = (cur1 == null) ? 0 : cur1.val;
            int val2 = (cur2 == null) ? 0 : cur2.val;
            int sum = (val1 + val2 + carry);
            int val = sum % 10;
            carry = sum / 10;
            temp.next = new ListNode(val);
            temp = temp.next;
            cur1 = cur1 != null ? cur1.next: null;
            cur2 = cur2 != null ? cur2.next: null;
        }
        if(carry > 0)
            temp.next = new ListNode(carry);
        return newNode.next;
    }
}

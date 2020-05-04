package LinkedList;

import com.main.ListNode;
//o(1) space
public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        while(cur1 != null && cur2 != null){
            int sum = cur1.val + cur2.val;
            if(sum >= 10){
                sum = sum - 10;
                if(cur1.next != null)
                    cur1.next.val += 1;
                else if(cur2.next != null)
                    cur2.next.val += 1;
                else
                    cur1.next = new ListNode(1);
            }
            cur1.val = sum;
            cur2.val = sum;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while(cur1 != null){
            if(cur1.val >= 10){
                if(cur1.next != null)
                    cur1.next.val += 1;
                else
                    cur1.next = new ListNode(1);
                cur1.val -= 10;
                cur1 = cur1.next;
            }
            else
                break;
        }
        while(cur2 != null){
            if(cur2.val >= 10){
                if(cur2.next != null)
                    cur2.next.val += 1;
                else
                    cur2.next = new ListNode(1);
                cur2.val -= 10;
                cur2 = cur2.next;
            }
            else
                break;
        }
        return cur1 == null ? l2 : l1;
    }
}

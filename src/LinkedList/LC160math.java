package LinkedList;

import com.main.ListNode;

public class LC160math {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        boolean flagA = false;
        boolean flagB = false;
        while(curA !=null && curB != null){
            if(curA == curB)
                return curA;
            if(curA.next == null){
                if(flagA)
                    return null;
                curA = headB;
                flagA = true;
            }
            else
                curA = curA.next;
            if(curB.next == null){
                if(flagB)
                    return null;
                curB = headA;
                flagB = true;
            }
            else
                curB = curB.next;
        }
        return null;
    }
}

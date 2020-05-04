/*
import com.main.ListNode;

public class LC2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return null;
       //assume return l1
        ListNode temp = l1;
        while (l1 != null && l2 != null){

           l1.val = l1.val + l2.val;
           if(l1.val >= 10)
           {
               l1.val = l1.val - 10;
               if(l1.next != null)
                   l1.next.val += 1;
               else
           }
           l1 = l1.next;
           l2 = l2.next;
       }
        if(l1.next == null){
            l1.next = l2.next;
        }
       return temp;
    }
}
*/

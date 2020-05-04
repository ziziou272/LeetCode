package Special1;

import com.main.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//brutal force
/*Time complexity : O(NlogN) where n is the total number of nodes.

Collecting all the values costs O(N) time.
A stable sorting algorithm costs O(NlogN) time.
Iterating for creating the linked list costs O(N) time.

Space complexity : O(N)
creating a new linked list costs O(N) space??????*/
public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(ListNode cur : lists){
            while(cur != null){
                list.add(cur.val);
                cur = cur.next;
            }
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        for(int val : list){
            dummy.next = new ListNode(val);
            dummy = dummy.next;
        }
        //dummy.next = null
        return res.next;
    }
}

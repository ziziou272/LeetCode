package Special1;

import com.main.ListNode;

import java.util.PriorityQueue;

public class LC23minHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((c1, c2) -> c1.val - c2.val);
        int k = lists.length;
        for(ListNode list : lists) {
            if (list != null)
                minHeap.offer(list);
        }
        dummy.next = minHeap.peek();
        ListNode cur = null;
        ListNode prev = null;
        while(!minHeap.isEmpty()){
            cur = minHeap.poll();
            if(prev != null)
                prev.next = cur;
            prev = cur;
            cur = cur.next;
            if(cur != null)
                minHeap.add(cur);
        }
        return dummy.next;
    }
}

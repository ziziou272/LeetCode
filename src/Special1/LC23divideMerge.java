package Special1;

import com.main.ListNode;

public class LC23divideMerge {//divide merge    nlogk  space:o(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        int k = lists.length;
        dividemerge(lists, 0, k - 1);
        return lists[0];
    }

    private void dividemerge(ListNode[] arr, int left, int right){
        if(left >= right)
            return;
        int mid = left + (right - left) / 2;
        dividemerge(arr, left, mid);
        dividemerge(arr, mid + 1, right);
        mergeTwo(arr[left], arr[mid + 1], left, right, arr);
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2, int left, int right, ListNode[] arr){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        arr[left] = dummy.next;
        return dummy.next;
    }
}

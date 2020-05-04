package LinkedList;

import com.main.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LC61rotateList {
    public ListNode rotateRight(ListNode head, int k) {
        //cc
        if(head == null) return head;
        ListNode cur = head;
        int size = 1;
        while(cur.next != null){
            cur = cur.next;
            size++;
        }
        if(k % size == 0) return head;
        //cur is tail now
        ListNode tail = cur;
        int step = size - (k % size) - 1;
        cur = head;
        while(step-- > 0){
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        tail.next = head;
        cur.next = null;
        return newHead;
    }
}


package Design;

import java.util.Arrays;

public class ArrayQueue {
    //size = 3
    //index: h
    // val : 1 2 3
    // t          t
    private int[] arr;
    int size;
    int head;
    int tail;
    int cap;
    public ArrayQueue(int capacity){
        this.size = 0;
        arr = new int[capacity];
        head = 0;
        tail = 0;
        cap = capacity;
    }
    public boolean offer(int value){
        if(size == arr.length) return false;
        arr[tail] = value;
        tail++;
        size++;
        if(tail > cap - 1){
            tail = 0;
        }
        return true;
    }
    public int poll() throws Exception {
        if(size == 0) return -1;
        int value = arr[head];
        size--;
        arr[head] = -1;
        head++;
        if(head > cap - 1)//head % head.length
            head = 0;
        return value;
    }
    public boolean isEmpty(){
        return head == tail;
    }
    public static void main(String[] args) throws Exception {
        ArrayQueue queue = new ArrayQueue(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.poll();
        queue.poll();
        queue.offer(5);
        queue.poll();
        queue.offer(6);
        queue.offer(7);
        queue.poll();
        queue.poll();
        queue.poll();
    }
}

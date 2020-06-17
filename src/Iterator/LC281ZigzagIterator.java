package Iterator;

import java.util.*;

public class LC281ZigzagIterator {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,3,5,7,9);
        List<Integer> list2 = Arrays.asList(2,4,6,8,10);
        List<Integer> list3 = Arrays.asList(11,13);
        List<Integer> list4 = Arrays.asList(21,23,25,27);
        List<Integer> list5 = Arrays.asList(91);
        List<List<Integer>> list = new ArrayList<>();
        Collections.addAll(list,list1,list2,list3,list4,list5);
        uIterator uI = new uIterator(list);
        while(uI.hasNext()){
            System.out.println(uI.next());
        }
    }




}
class ZigzagIterator {
    //用q是deal with k个list 或者是 List<List<Inteegr>>
    private Queue<ListIterator<Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if(v1 != null && v1.size() > 0){
            queue.offer(v1.listIterator());
        }
        if(v2 != null && v2.size() > 0){
            queue.offer(v2.listIterator());
        }
    }

    public int next() {
        ListIterator<Integer> iterator = queue.poll();
        int val = iterator.next();
        if(iterator.hasNext())
            queue.offer(iterator);
        return val;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
//follow up u型号 iterator
class uIterator{
    private Stack<ListIterator<Integer>> stack1;
    private Stack<ListIterator<Integer>> stack2;
    private Stack<ListIterator<Integer>> curStack;
    private Stack<ListIterator<Integer>> helpeStack;

    uIterator(List<List<Integer>> list) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        curStack = null;
        for(List<Integer> li : list){
            if(li != null && li.size() > 0)
                stack1.push(li.listIterator());
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        curStack = stack2;
        helpeStack = stack1;
    }

    public int next() {
        ListIterator<Integer> iterator = curStack.pop();
        int val = iterator.next();
        if(iterator.hasNext())
            helpeStack.push(iterator);
        //switch stack when one is empty
        if(curStack.isEmpty()){
            helpeStack = curStack;
            curStack = curStack == stack1 ? stack2 : stack1;
        }
        return val;
    }

    public boolean hasNext() {
        return !(stack1.isEmpty() && stack2.isEmpty());
    }



}
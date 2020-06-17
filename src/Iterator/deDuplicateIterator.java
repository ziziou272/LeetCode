package Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class deDuplicateIterator implements Iterator<Integer> {
    private Integer next;
    private ListIterator<Integer> iterator;
    boolean isStart = true;
    public deDuplicateIterator(List<Integer> list){
        next = null;
        iterator = list.listIterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || next != null;
    }

    @Override
    public Integer next() {
        Integer cur = null;
        if(next == null && isStart){
            cur = iterator.next();
            isStart = false;
        }
        else{
            cur = next;
            next = null;
        }
        while (iterator.hasNext()){
            Integer val = iterator.next();
            if(val != cur){
                next = val;
                break;
            }
        }
        return cur;
    }
}
/*
* 1 2 2 2 3 4 4
*
*
*
*
*
*
* */

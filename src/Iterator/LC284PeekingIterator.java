package Iterator;

import java.util.Iterator;

public class LC284PeekingIterator {
}
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer next ;
    private boolean peeked;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        next = null;
        peeked = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(next == null){
            next = iterator.next();
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(next == null){
            return iterator.next();
        }
        Integer temp = next;
        next = null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return next != null || iterator.hasNext();
    }
}

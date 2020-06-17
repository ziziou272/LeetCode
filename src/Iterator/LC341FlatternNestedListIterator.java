package Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class LC341FlatternNestedListIterator {
}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
class NestedIterator implements Iterator<Integer> {
    private Stack<ListIterator<NestedInteger>> stack;
    Integer value;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        if(nestedList.listIterator().hasNext())
            stack.push(nestedList.listIterator());
        peekNext();
    }

    @Override
    public Integer next() {
        Integer temp = value;
        peekNext();
        return temp;
    }

    private void peekNext(){
        value = null;
        if(stack.isEmpty())
            return;
        ListIterator<NestedInteger> it = stack.peek();
        NestedInteger ni = it.next();
        if(!it.hasNext())
            stack.pop();
        if(ni.isInteger()){
            value = ni.getInteger();
        }
        else{
            it = ni.getList().listIterator();
            if(it.hasNext())
                stack.push(it);
            peekNext();
        }
    }

    @Override
    public boolean hasNext() {
        return value != null || !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
/*

Stack<ListIterator<NestedInteger>>

[[[[2, [[[4],8],9],1,3],5],6],7,[10,11]]


[2,[[[4],8],9],1,3]
      i
[[2, [[[4],8],9],1,3],5]
                      i
[[[2, [[[4],8],9],1,3],5],6]
                           i
[[[[2, [[[4],8],9],1,3],5],6],7,[10,11]]
                              i










*/

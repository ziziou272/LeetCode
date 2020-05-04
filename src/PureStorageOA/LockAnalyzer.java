package PureStorageOA;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class LockAnalyzer {
    public int analysis(List<String> events){
        if(events == null || events.size() == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        for(String event : events){
            String[] eventArray = event.split(" ");
            String eventName = eventArray[0];
            int id = Integer.parseInt(eventArray[1]);
            if(eventName.equals("ACQUIRE")){
                if(set.contains(id))
                    return i;
                else{
                    set.add(id);
                    stack.push(id);
                }
            }
            else{
                if(stack.isEmpty() || stack.peek() != id){
                    return i;
                }
                else{
                    stack.pop();
                    set.remove(id);
                }
            }
        }
        return stack.isEmpty() ? 0 : events.size() + 1;
    }
}

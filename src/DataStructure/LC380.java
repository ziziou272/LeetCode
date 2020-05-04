package DataStructure;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LC380 {
    HashMap<Integer,Integer> valueToIndex = new HashMap<>();
    List<Integer> myList = new ArrayList<>();
    Random rand;


    /** Initialize your data structure here. */
    public LC380() {
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valueToIndex.containsKey(val)){
            return false;
        }
        myList.add(val);
        int index = myList.size() - 1;
        valueToIndex.put(val, index);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valueToIndex.containsKey(val)){
            return false;
        }
        int index = valueToIndex.get(val);
        valueToIndex.remove(val);
        myList.set(index, myList.get(myList.size() - 1));
        myList.remove(myList.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(myList.size() == 0)
            return -1;
        int index = rand.nextInt(myList.size());
        return myList.get(index - 1);
    }
}

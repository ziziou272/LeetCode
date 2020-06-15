package DataStructure;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
class RandomizedSet {
    private HashMap<Integer, Integer> valToIndex;
    private List<Integer> list;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valToIndex = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToIndex.containsKey(val))
            return false;
        valToIndex.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valToIndex.containsKey(val))
            return false;
        int index = valToIndex.get(val);
        list.set(index, list.get(list.size() -1));
        valToIndex.put(list.get(index), index);
        //remove after add to avoid bugs when size == 1
        valToIndex.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
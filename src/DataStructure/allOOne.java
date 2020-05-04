package DataStructure;

import java.util.*;

public class allOOne {
    public static void main(String[] args) {
        /*
        * ["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
            [[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]*/
        AllOne test = new AllOne();
        test.inc("a");
        test.inc("b");
        test.inc("b");
        test.inc("c");
        test.inc("c");
        test.inc("c");
        test.getMinKey();
        test.dec("b");
        test.dec("b");
        test.inc("a");
        test.getMinKey();
        test.getMaxKey();
    }
}
class AllOne {
    private HashMap<String, Integer> keyCountMap;
    private HashMap<Integer, Bucket> countBucketMap;
    private Bucket head;
    private Bucket tail;

    public AllOne(){
        keyCountMap = new HashMap<>();
        countBucketMap = new HashMap<>();
        head = new Bucket(0);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    class Bucket{
        //count
        private int val;
        private HashSet<String> set;
        private Bucket next;
        private Bucket prev;
        public Bucket(int val){
            this.val = val;
            set = new HashSet<>();
        }
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        //if not in the keyCountMap, add to map
        if(!keyCountMap.containsKey(key)){
            keyCountMap.put(key, 1);
            addToBucket(1, 0, key);
        }
        else{
            int count = keyCountMap.get(key);
            //put the new value to bucket
            addToBucket(count , 1, key);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(keyCountMap.containsKey(key)){
            int count = keyCountMap.get(key);
            if(count == 1){
                removeFromBucket(count, key);
            }
            else{
                addToBucket(count, - 1, key);
            }
        }
    }
    private void addToBucket(int count, int offset, String key){
        Bucket bucket = countBucketMap.get(count);
        //count == 1
        if(offset == 0){
            //if no such bucket
            if(bucket == null){
                //add bucket count == 1
                bucket = addBucket(head, head.next, count);
            }
            //add key to bucket
            bucket.set.add(key);
        }else if(offset == -1){
            //check left bucket == count
            Bucket prevBucket = bucket.prev;
            //new bucket is available
            if(prevBucket.val == count + offset){
                prevBucket.set.add(key);
            }else{
                Bucket newBucket = addBucket(prevBucket, bucket, count + offset);
                newBucket.set.add(key);
            }
            removeFromBucket(count, key);
            keyCountMap.remove(key);
            keyCountMap.put(key, count - 1);

        } else if (offset == 1) {
            //check right bucket == count
            Bucket nextBucket = bucket.next;
            //new bucket is available
            if(nextBucket != tail && nextBucket.val == count + offset){
                nextBucket.set.add(key);
            }else{
                Bucket newBucket = addBucket(bucket, bucket.next, count + offset);
                newBucket.set.add(key);
            }
            removeFromBucket(count, key);
            keyCountMap.remove(key);
            keyCountMap.put(key, count + 1);

        }
    }
    private Bucket addBucket(Bucket prev, Bucket next, int count){
        Bucket bucket = new Bucket(count);
        prev.next = bucket;
        bucket.prev = prev;
        bucket.next = next;
        next.prev = bucket;
        countBucketMap.put(count, bucket);
        return bucket;
    }
    private void removeFromBucket(int count, String key){
        //has this bucket and key is in this bucket
        if(countBucketMap.containsKey(count) && countBucketMap.get(count).set.contains(key)){
            Bucket curBucket = countBucketMap.get(count);
            curBucket.set.remove(key);
            keyCountMap.remove(key);
            if(curBucket.set.size() == 0){
                //remove the bucket
                removeBucket(curBucket, count);
            }
        }
    }

    private void removeBucket(Bucket cur, int count){
        //remove from map
        countBucketMap.remove(count);
        // head <-> 1 <-> cur <-> 2 <-> tail
        Bucket prev = cur.prev;
        Bucket next = cur.next;
        prev.next = next;
        next.prev = prev;
        cur.next = null;
        cur.prev = null;
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(tail.prev != head){
            return tail.prev.set.iterator().next();
        }else
            return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head.next != tail){
            return head.next.set.iterator().next();
        }
        else
            return "";
    }
}


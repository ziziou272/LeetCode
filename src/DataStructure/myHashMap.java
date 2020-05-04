package DataStructure;

import java.util.*;

public class myHashMap<K, V>{
    private Bucket<K, V> [] buckets;
    private int bucketSize;
    private int size;
    private static final double LOAD_FACTOR = 0.75;
    //constructor
    public myHashMap(){
        this.bucketSize = 256;
        this.size = 0;
        //todo:??????????????????
        //this.buckets = new Bucket<K, V>[bucketSize];
    }
    public myHashMap(int bucketSize){
        this.bucketSize = bucketSize;
        this.size = 0;
        //todo:??????????????????
        //this.buckets = new Bucket<K, V>[bucketSize];
    }
    private int hashFunction(K key){
        //handle null
        if(key == null)
            return 0;
        return key.hashCode() % bucketSize;
    }

    public V get(K key){
        //todo: check bucket null
        int index = hashFunction(key);
        return this.buckets[index].get(key);
    }

    public void put(K key, V value){
        //todo: check bucket null
        //check 是否是插入还是update
        int index = hashFunction(key);
        if(buckets[index].put(key, value)){
            if(++size >= bucketSize * LOAD_FACTOR)
                reHashing();
        }
    }

    public boolean remove(K key){
        Bucket<K, V> b = buckets[hashFunction(key)];
        //todo: check bucket null
        if(b == null)
            return false;
        int index = hashFunction(key);
        return buckets[index].remove(key);
    }
    //reHashing
    private void reHashing(){
        this.bucketSize *= 2;
        //todo:
        Bucket<K, V> newBuckets[] = new Bucket [this.bucketSize];
        for(Bucket<K, V> bucket : this.buckets){
            for(Cell<K, V> cell : bucket.getCells()){
                int index = hashFunction(cell.getKey());
                if(newBuckets[index] == null)
                    newBuckets[index] = new Bucket<>();
                newBuckets[index].put(cell.getKey(), cell.getValue());
            }
        }
        this.buckets = newBuckets;
    }
}
class Student{
    private int id;
    public Student(int id){
        this.id = id;
    }
    /**
     * hashcode和equals要一起重载: hashCode 是找bucket and equals是查桶里边有没有这个元素，所以逻辑要一致
     * hashFunction input 是 key -> 调用key.hashCode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student that = (Student) o;
        return id == that.id;
    }
    /**
     * 什么时候override：default hashCode 是个地址 -> 问题：HashMap<Student, Integer>
     *     Student st1 = new Student.Builder.setId(50)
     *     Student st2 = new Student.Builder.setId(50)
     *     两个 entry， 但是因为id相等 想把它俩视为一个相同的object 所以不能基于地址而是基于id hashing
     */
    @Override
    public int hashCode() {
        return this.id;
    }
}

//HashMap
//primitive 不行， 必须是object
class Cell<K, V>{
    private K key;
    private V value;

    public Cell(K key, V value){
        this.key = key;
        this.value = value;
    }

    /**
     * 基于key来比较的
     * @param o 爸爸类是object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell<?, ?> that = (Cell<?, ?>) o;
        return key.equals(that.key);
    }
    /**
     * 基于key的hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        if(this.key == null)
            return 0;
        return this.key.hashCode();
    }

    public boolean keyEquals(K key){
        if(key == null)
            return this.key == null;
        else{
            return this.key.equals(key);
        }
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
class Bucket<K, V>{
    public List<Cell<K, V>> getCells() {
        return cells;
    }

    public void setCells(List<Cell<K, V>> cells) {
        this.cells = cells;
    }

    private List<Cell<K, V>> cells;

    public Bucket(){
        //to easily swap fro remove
        cells = new ArrayList<>();
    }
    public V get(K key){
        for(Cell<K, V> cell : this.cells){
            if(cell.keyEquals(key))
                return cell.getValue();
        }
        return null;
    }
    public boolean put(K key, V value){
        Cell<K, V> insert = new Cell<>(key, value);
        for(Cell<K, V> cell : this.cells){
            if(cell.equals(insert)){
                cell.setValue(value);
                return false;
            }
        }
        this.cells.add(insert);
        return true;
    }
    public boolean remove(K key){
        //for each 不能对这个东西修改插入
        //因为是基于iterator while(hasNext)
        boolean isContained = false;
        for(Cell<K, V> cell : this.cells){
            if(cell.keyEquals(key)){
                Cell<K, V> lastCell = this.cells.get(this.cells.size() - 1);
                cell.setKey(lastCell.getKey());
                cell.setValue(lastCell.getValue());
                isContained = true;
                break;
            }
        }
        if(isContained)
            this.cells.remove(this.cells.remove(this.cells.size() - 1));
        return isContained;
    }
}

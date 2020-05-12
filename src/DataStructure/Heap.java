package DataStructure;

import java.util.Arrays;

/**
 * CS5006
 * HW4
 * Peng Hao
 *
 * Question1
 * This is a maxHeap
 * Data is integer, root is a pointer to node
 * We are using an array to implement it
 * Assume we have a node with index i
 * The index of his parent is (i -1) / 2
 * The index of left child is 2 * i + 1
 * right child is 2 * i + 2
 */
public class Heap {

    int[] array;
    int size;

    /**
     * this is the constructor of the heap
     * @param capacity is the capacity of the heap
     */
    public Heap(int capacity){
        if(capacity < 0)
            throw new IllegalArgumentException("Capacity should be positive");
        else{
            array = new int[capacity];
            size = 0;
        }
    }

    /**
     * another constructor
     * @param inputArray this the array which is a set of data that want to add to heap
     * copy the data first then heapify
     */
    public Heap(int[] inputArray){
        //copy the input array and expand the size twice
        array = Arrays.copyOf(inputArray, inputArray.length * 2);
        size = inputArray.length;
        heapify();
    }

    /**
     * createNode(data) returns index to node
     * @param data
     * @return the index of the new node
     */
    public int createNode(int data){
        if(size == array.length){
            array = Arrays.copyOf(array, size * 2);
        }
        array[size] = data;
        int index =percolateUp(size);
        size++;
        return index;
    }

    /**
     * method to do the heapify
     */
    private void heapify(){
        for(int i = (size - 2) / 2; i >= 0; i--){
            percolateDown(i);
        }
    }
    /**
     *
     * @param data will be add to the last of the array, then percolate up
     * @return returns true if successful, false otherwise
     */
    public boolean push(int data){
        if(size == array.length){
            array = Arrays.copyOf(array, size * 2);
        }
        array[size] = data;
        percolateUp(size);
        size++;
        return true;
    }

    /**
     * @return returns true if the heap is empty, false otherwise
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *
     * @return the data at the top of the heap/the largest value
     * and re-balance the heap – be careful
     * NOT to call pop if heap is empty
     */
    public int pop() {
        //if(this.isEmpty()) throw new Exception("The heap is empty");
        if(this.isEmpty()){
            System.out.println("This heap is empty now");
            return -1;
        }
        //swap the value of the last with the root
        int res = array[0];
        array[0] = array[size - 1];
        percolateDown(0);
        size--;
        return res;
    }

    /**
     * percolate down until found right position
     * @param index is the index or data need to percolate up
     */
    private void percolateDown(int index){
        //(size - 2) / 2 is the index of the last leaf node
        while(index <= (size - 2) /2){
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            //find the max value from left and right child
            int swapIndex = (right < size && array[left] < array[right]) ? right : left;
            if(array[swapIndex] > array[index]){
                swap(index, swapIndex);
                index = swapIndex;
            }
            else
                break;
        }
    }

    /**
     * percolate up until found a value that greater than the data in the index
     * @param index is the index or data need to percolate up
     */
    private int percolateUp(int index){
        int indexOfParent = (index - 1) / 2;
        while (indexOfParent >= 0){
            if(array[index] > array[indexOfParent]){
                swap(index, indexOfParent);
                index = indexOfParent;
                indexOfParent = (index - 1) / 2;
            }
            else
                break;
        }
        return index;
    }

    /**
     * swap the index i and j in the array
     */
    private void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * some tests of the heap
     * it can expand it size automatically after it reach the capacity
     * every time the max will pop out
     */
    public static void main(String[] args) {

        Heap maxHeap = new Heap(3);
        maxHeap.push(1);
        maxHeap.push(-10);
        maxHeap.push(6);
        maxHeap.push(21);
        maxHeap.push(5);
        maxHeap.push(11);
        maxHeap.push(-120);
        maxHeap.push(61);
        maxHeap.push(121);
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        System.out.println("Is the heap empty now? " + maxHeap.isEmpty());
        System.out.println(maxHeap.pop());
        System.out.println("Is the heap empty now? " + maxHeap.isEmpty());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
    }
}

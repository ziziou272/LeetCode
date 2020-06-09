package Possibility;

import java.util.Random;

public class ShuffleArrLC384 {
}
/*
The Fisher-Yates algorithm is remarkably similar to the brute force solution.
 On each iteration of the algorithm, we generate a random integer between the current index
 and the last index of the array. Then, we swap the elements at the current index and
 the chosen index - this simulates drawing (and removing) the element from the hat,
 as the next range from which we select a random index will not include the most recently processed one.

*/
class Solution {
    private int[] nums;
    private int[] shuffle;
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        shuffle = nums.clone();
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < nums.length;i++){
            int index = rand.nextInt(i + 1);
            //swap
            swap(i, index);
        }
        return shuffle;
    }
    private void swap(int i, int j){
        int temp = shuffle[i];
        shuffle[i] = shuffle[j];
        shuffle[j] = temp;
    }
}

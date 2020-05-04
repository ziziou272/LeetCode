package BinarySearch;

import java.util.List;

public class LeftmostColumnWithAtLeastAOne {

}
/**
 * https://leetcode.com/playground/oFDW7DqN
 * A binary matrix means that all elements are 0 or 1.
 * For each individual row of the matrix, this row is sorted in non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix,
 * return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 *
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 *
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.
 * Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */
//at least 1
// m * log n
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int m = dimensions.get(0), n = dimensions.get(1);
        int left = 0, right = n - 1;
        int res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int value = 0;
            for(int i = 0; i < m; i++){
                value += binaryMatrix.get(i, mid);
            }
            if(value >= 1){
                res = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return res;

    }
}
interface BinaryMatrix {
    public int get(int x, int y);
    public List<Integer> dimensions();
};
class solutionMPlusN{
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int m = dimensions.get(0), n = dimensions.get(1) - 1;
        int res = -1;
        //from each rows do bs to updated right boundary(n)
        for(int i = 0; i < m; i++){
            int left = 0, right = n;
            if(right < 0) return res;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                int value = binaryMatrix.get(i, mid);
                if(value == 1){
                    right = mid;
                    res = mid;
                }
                else
                    left = mid;
            }
            if(binaryMatrix.get(i, left) == 1){
                res = left;
                n = left - 1;
            }else if(binaryMatrix.get(i, right) == 1){
                res = right;
                n = right - 1;
            }
        }
        return res;
    }
}
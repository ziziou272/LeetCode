package BinarySearch;

public class LC274HIndexand274 {
}
/*

h paper >= h
n-h < h
h=n-i

max h is size n:
count sort

0 from n

0 1 2 3 4 5 6 7 8
9 1 6 3 3 7 0 5 2

0 1 2 3 4 5 6 7 8 9
1 1 1 2   1 1 1   1
        4

*/
class CountSortSolution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int[] count = new int[n + 1];
        for(int i = 0 ; i < n; i++){
            int cit = citations[i];
            if(cit >= n){
                count[n]++;
            }
            else
                count[cit]++;
        }
        //traverse
        int prevSum = 0;
        for(int i = n; i>= 0; i--){
            if(count[i] + prevSum >= i)
                return i;
            prevSum += count[i];
        }
        return 0;
    }
}
/*
n = 8
h paper >= h (1)
n-h < h      (2)

0 1 2 3 4 5   6   7
1 2 3 6 7 10 800 900
        l
        m
      r


h = right - mid + 1
nums[mid] >= h
and
num[mid - 1] < h

if nums[mid] < h{
    go right
}
else{
    go left
}

n=0
h=0
[]

n=1
h=1
[0]
n=1
h=1
[0]


*/
class BSSolution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int left = 0, right = citations.length - 1;
        int n = citations.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int h = n - mid;
            if(citations[mid] < h){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return n - left;
    }
}
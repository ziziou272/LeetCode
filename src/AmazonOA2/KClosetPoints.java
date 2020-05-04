package AmazonOA2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KClosetPoints {

    public static List<List<Integer>> kClosest(List<List<Integer>> points, int k) {
        //cc
        //find k
        int len = points.size();
        int left = 0, right = len - 1;
        while(left < right){
            int index = partition(left, right, points);
            if(index == k - 1)
                break;
            else if(index > k - 1)
                right = index - 1;
            else
                left = index + 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(points.get(i));
        }
        return res;
    }
    private static int partition(int left, int right, List<List<Integer>> points){
        int pivot = right;
        int i = left - 1;
        for(int j = left; j < right; j++){
            if(smaller(points.get(j), points.get(pivot)))
                Collections.swap(points, ++i, j);
        }
        Collections.swap(points, ++i, pivot);
        return i;
    }
    private static boolean smaller(List<Integer> a, List<Integer> b){
        int aX = a.get(0), aY = a.get(1);
        int bX = b.get(0), bY = b.get(1);
        return aX * aX + aY * aY < bX * bX + bY * bY;
    }
    public static void main(String[] args){
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(5);
        b.add(-1);
        List<Integer> c = new ArrayList<>();
        c.add(-2);
        c.add(4);
        input.add(a);
        input.add(b);
        input.add(c);
        List<List<Integer>> res = kClosest(input, 2);
        kClosest(input, 1);
    }

}

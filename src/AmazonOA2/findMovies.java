package AmazonOA2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class findMovies {
    /**
     *
     * @param movieDuration
     * @param d
     * @return
     */
    private static int[] get2SumClosest(int[] movieDuration, int d) {
        //todo:cc
        //hashMap to store index
        //to deal with duplicate, use list
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < movieDuration.length; i++){
            int cur = movieDuration[i];
            if(!map.containsKey(cur)){
                map.put(cur, new ArrayList<>());
            }
            map.get(cur).add(i);
        }
        int[] res = new int[2];
        Arrays.sort(movieDuration);
        int left = 0, right = movieDuration.length - 1;
        int target = d - 30;
        int max = Integer.MIN_VALUE;
        while(left < right){
            int sum = movieDuration[left] + movieDuration[right];
            if(sum == target){
                res[0] = map.get(movieDuration[left]).get(0);
                //if left value == right value
                int len = map.get(movieDuration[right]).size();
                res[1] = map.get(movieDuration[right]).get(len - 1);
                break;
            }
            else if(sum < target){
                //update max if needed
                if(max < sum){
                    res[0] = map.get(movieDuration[left]).get(0);
                    //if left value == right value
                    int len = map.get(movieDuration[right]).size();
                    res[1] = map.get(movieDuration[right]).get(len - 1);
                    max = sum;
                }
                //move
                left++;
            }
            else {
                right--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] movie_duration1 = {90, 85, 75, 60, 120, 150, 125};
        int d1 = 250;
        int[] movie_duration2 = {90, 85, 75, 60, 155, 150, 125};
        int d2 = 250;
        int[] movie_duration3 = {90, 85, 75, 60, 120,110,110, 150, 125};
        int d3 = 250;
        System.out.println(Arrays.toString(get2SumClosest(movie_duration1, d1)));
        System.out.println(Arrays.toString(get2SumClosest(movie_duration2, d2)));
        System.out.println(Arrays.toString(get2SumClosest(movie_duration3, d3)));
    }
}

package Robolox;

import java.util.*;

public class SmartSale {
    public static void main(String[] args) {
        System.out.println(deleteProducts(Arrays.asList(1,1,1,2,2,3,3,4,5,6,6),2));
        System.out.println(deleteProducts(Arrays.asList(1,1,1,2,2,3,3,4,5,6,6),3));
        System.out.println(deleteProducts(Arrays.asList(1,1,1,2,2,3,3,4,5,6,6),100));
    }

    public static int deleteProducts(List<Integer> ids, int m){
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int id : ids){
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(countMap.keySet());
        list.sort((l1, l2) -> (countMap.get(l1) - countMap.get(l2)));
        int size = countMap.size();
        int i = 0;
        while(m > 0 && i < list.size()){
            int id = list.get(i);
            if(countMap.get(id) <= m){
                size--;
                m -= countMap.get(id);
            }else{
                return size;
            }
            i++;
        }
        return size;
    }
}
/*
*
*
*
* 1 1 1 2 2 3 3 4 5 6 6
*
* 1 2 3 4 5 6
* 3 2 2 1 1 2
* count: 6
* m=4
*
*
* */
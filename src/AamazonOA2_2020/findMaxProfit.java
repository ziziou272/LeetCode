package AamazonOA2_2020;

import java.util.*;

public class findMaxProfit {
    public static void main(String[] args) {
        System.out.println(highestProfit(2, Arrays.asList(3L, 5L), 6));
        System.out.println(highestProfit(2, Arrays.asList(2L, 5L), 4));
        System.out.println(highestProfit(5, Arrays.asList(2L, 8L, 4L, 10L, 6L), 20));

    }
    public static long highestProfit(int numSupplies, List<Long> inventory, long order){
        long[] table = new long[11];
        for(Long num : inventory){
            table[Math.toIntExact(num)]++;
        }
        int index = 10;
        long count = 0L, profit = 0L;
        while(count < order && index > 0){
            long num = table[index];
            num = Math.min(order - count, num);
            table[index - 1] += num;
            count += num;
            profit += index * num;
            index--;
        }
        return profit;
    }




    public static long highestProfit2(int numSupplies, List<Long> inventory, long order){
        if(order == 0 || inventory == null || inventory.size() == 0 || numSupplies == 0) return 0L;
        //descending order
        inventory.sort((a, b) -> (int) (b - a));
        List<Long> sumInventory = new ArrayList<>();
        List<Long> profitInventory = new ArrayList<>();
        for(int i = 0; i < numSupplies; i++) {
            sumInventory.add(0L);
            profitInventory.add(0L);
        }
        for(int i = 0; i < numSupplies; i++){
            long next = i+1 == numSupplies ? 0 : inventory.get(i + 1);
            long diff = inventory.get(i) - next + 1;
            long sum = diff * (i + 1) + (i == 0 ? 0 : sumInventory.get(i - 1)) ;
            long profit = (diff + 1) * (inventory.get(i) + next) / 2;
            sumInventory.set(i, sum);
            profitInventory.set(i, profit);
        }
        int index = 0;
        long sum = 0L, profit = 0L;
        while (sum < order){
            if(sum + sumInventory.get(index) > order){
                break;
            }else{
                sum += sumInventory.get(index);
                profit += profitInventory.get(index);
                index++;
            }
        }
        long remain = order - sum;
        long curProfit = (inventory.get(index) - remain + 1) * (inventory.get(index) + inventory.get(index) - remain) / 2;
        return profit + curProfit;
    }
}

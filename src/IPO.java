import java.util.*;
class solution {
    public int consecutiveNumbersSum(int num) {
        int count = 0;
        int upper_limit = (int)(Math.sqrt(2 * num + 0.25) - 0.5);
        for (int k = 1; k <= upper_limit; ++k) {
            num -= k;
            if (num % k == 0)
                count++;
        }
        return count;
    }
}
public class IPO {
    public static void main(String[] args) {
        int[][] bids = {{1,3,1,9866}, {2,1,2,5258}, {3,2,4,5788}, {4,2,4,6536}};


        List<Integer> l1 = new ArrayList<>(List.of(1,3,1,9866));
        List<Integer> l2 = new ArrayList<>(List.of(2,1,2,5258));
        List<Integer> l3 = new ArrayList<>(List.of(3,2,4,5788));
        List<Integer> l4 = new ArrayList<>(List.of(4,2,4,6536));
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        int totalShares = 2;
        List<Integer> res = getUnallocatedUsers(bids, totalShares);
        System.out.println(res);
    }


    public static List<Integer> getUnallocatedUsers(int[][] bids, int totalShares){List<Integer> res = new ArrayList<>();
        if(bids == null ||  bids.length == 0 || totalShares == 0) return res;

        Comparator<int[]>  bidsComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int com = 0;
                if(com == 0){
                    com = Integer.compare(o2[2], o1[2]);
                    if(com == 0){
                        com = Integer.compare(o1[3], o2[3]);
                        if(com == 0){
                            com = Integer.compare(o2[1], o1[1]);
                        }
                    }
                }
                return com;
            }
        };

        Queue<int[]> maxHeap = new PriorityQueue<int[]>(bidsComparator);
        for(int[] bid: bids) maxHeap.offer(bid);
        while(totalShares > 0 && !maxHeap.isEmpty()){
            totalShares -= maxHeap.poll()[1];
        }
        while(!maxHeap.isEmpty()){
            res.add(maxHeap.poll()[0]);
            Collections.sort(res);
        }
        return res;
    }

}

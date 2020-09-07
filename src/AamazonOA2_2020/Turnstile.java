package AamazonOA2_2020;

import java.util.*;

public class Turnstile {
    public static void main(String[] args) {
        System.out.println(calc(4, Arrays.asList(0, 0, 1, 5), Arrays.asList(0, 1, 1, 0)));
        System.out.println(calc(5, Arrays.asList(0,1,1,3,3), Arrays.asList(0, 1, 0, 0, 1)));
        System.out.println(calc(16, Arrays.asList(0,0,1,2,6,6,7,7,7,10,11,12,12,12,12,14),Arrays.asList(0,0,1,1,0,1,1,1,1,1,1,0,1,0,0,0)));
        System.out.println(calc(100,
                Arrays.asList(0,0,1,1,2,2,2,3,3,3,4,5,6,6,7,8,8,9,10,10,11,11,12,12,13,13,13,13,14,14,14,15,15,15,18,18,18,18,19,21,22,22,23,24,25,27,27,28,28,28,28,29,30,30,30,31,32,32,32,33,33,33,34,34,35,35,36,36,37,37,38,38,38,39,39,39,39,39,40,40,40,40,40,42,42,43,44,45,45,45,46,46,48,48,49,49,50,50,50,50),
                Arrays.asList(0,0,1,0,1,1,1,0,0,0,0,1,0,0,1,0,1,0,0,0,0,1,1,1,0,1,0,0,1,0,0,0,1,1,0,0,1,1,0,1,0,1,1,1,1,0,0,1,1,1,1,1,0,1,0,1,1,1,1,0,0,1,1,0,0,0,1,1,1,0,0,0,1,1,0,1,0,0,0,0,1,1,0,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,1,0)));
        System.out.println(calc(12, Arrays.asList(0, 0, 1, 1, 2, 2, 3, 3, 10, 20, 20, 21), Arrays.asList(0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1)));
        System.out.println(calc(7, Arrays.asList(0, 0, 0, 0, 1, 1, 3), Arrays.asList(0, 0, 1, 1, 1, 0, 1)));
        System.out.println(calc(7, Arrays.asList(0, 0, 0, 0, 1, 1, 4), Arrays.asList(0, 0, 1, 1, 1, 0, 1)));
    }
/*
* enterHeap
* exitHeap
* Boolean status -> null:unused
*               -> true -> exit
*               -> false -> enter
* time: select greater one
*
* */
    public static List<Integer> calc(int numCustomers, List<Integer> arrTime, List<Integer> direction){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < numCustomers; i++) res.add(-1);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int res = arrTime.get(o1) - arrTime.get(o2);
                if(res != 0) return res;
                else return o1 - o2;
            }
        };
        PriorityQueue<Integer> enterHeap = new PriorityQueue<>(comparator);
        PriorityQueue<Integer> exitHeap = new PriorityQueue<>(comparator);
        for(int i = 0; i < numCustomers; i++){
            //exit
            if(direction.get(i) == 1){
                exitHeap.offer(i);
            }else{
                enterHeap.offer(i);
            }
        }
        int time = -1;
        Boolean exit = null;
        while (!enterHeap.isEmpty() && !exitHeap.isEmpty()){
            int enterTime = arrTime.get(enterHeap.peek()) < time ? time : arrTime.get(enterHeap.peek());
            int exitTime = arrTime.get(exitHeap.peek()) < time ? time : arrTime.get(exitHeap.peek());
            if(enterTime < exitTime){
                int index = enterHeap.poll();
                time = Math.max(time, enterTime);
                res.set(index, time);
                exit = false;
            } else if( exitTime < enterTime){
                int index = exitHeap.poll();
                time = Math.max(time, exitTime);
                res.set(index, time);
                exit = true;
            }
            //same time
            else{
                //used
                if(time == enterTime && exit != null){
                    if(exit){
                        int index = exitHeap.poll();
                        res.set(index, time);
                    }else {
                        int index = enterHeap.poll();
                        res.set(index, time);
                        exit = false;
                    }
                }else{
                    int index = exitHeap.poll();
                    time = Math.max(time, exitTime);
                    res.set(index, time);
                    exit = true;
                }
            }
            time++;
        }
        while (!enterHeap.isEmpty()){
            int index = enterHeap.poll();
            time = Math.max(time, arrTime.get(index));
            res.set(index, time);
            time++;
        }
        while (!exitHeap.isEmpty()){
            int index = exitHeap.poll();
            time = Math.max(time, arrTime.get(index));
            res.set(index, time);
            time++;
        }
        return res;
    }

    public int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
        int[] res = new int[numCustomers];
        Arrays.fill(res, -1);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return arrTime[o1] - arrTime[o2];
            }
        };
        PriorityQueue<Integer> enterHeap = new PriorityQueue<>(comparator);
        PriorityQueue<Integer> exitHeap = new PriorityQueue<>(comparator);
        for(int i = 0; i < numCustomers; i++){
            //exit
            if(direction[i] == 1){
                exitHeap.offer(i);
            }else{
                enterHeap.offer(i);
            }
        }
        int time = -1;
        Boolean exit = null;
        while (!enterHeap.isEmpty() && !exitHeap.isEmpty()){
            int enterTime = Math.max(time, arrTime[enterHeap.peek()]);
            int exitTime = Math.max(time, arrTime[exitHeap.peek()]);
            if(enterTime < exitTime){
                int index = enterHeap.poll();
                time = Math.max(time, enterTime);
                res[index] = time;
                exit = false;
            } else if( exitTime < enterTime){
                int index = exitHeap.poll();
                time = Math.max(time, exitTime);
                res[index] = time;
                exit = true;
            }
            //same time
            else{
                //used
                if(time == enterTime && exit != null){
                    if(exit){
                        int index = exitHeap.poll();
                        res[index] = time;
                    }else {
                        int index = enterHeap.poll();
                        res[index] = time;
                        exit = false;
                    }
                }else{
                    int index = exitHeap.poll();
                    time = Math.max(time, exitTime);
                    res[index] = time;
                    exit = true;
                }
            }
            time++;
        }
        while (!enterHeap.isEmpty()){
            int index = enterHeap.poll();
            time = Math.max(time, arrTime[index]);
            res[index] = time;
        }
        while (!exitHeap.isEmpty()){
            int index = exitHeap.poll();
            time = Math.max(time, arrTime[index]);
            res[index] = time;
        }
        return res;
    }
}

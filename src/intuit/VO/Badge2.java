package intuit.VO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Badge2 {
    public static void main(String[] args) {
        String[][] input = new String[][]{
                {"Alex", "enter"},
                {"Bob", "exit"},
                {"Charlie", "exit"},
                {"Allen", "enter"},
                {"Allen", "enter"},
                {"Charlie", "enter"},
                {"Charlie", "exit"},
                {"Bob", "enter"},
                {"Alex", "exit"}
        };
        System.out.println("Q1 ");
        checkMismatch(input);
        System.out.println("Q2 ");
        String[][] input2 = new String[][]{
                {"Alex", "1000"},
                {"Bob", "1300"},
                {"Charlie", "1200"},
                {"Allen", "1000"},
                {"Allen", "1100"},
                {"Charlie", "1300"},
                {"Charlie", "1310"},
                {"Allen", "1030"},
                {"Allen", "1050"},
                {"Charlie", "1220"},
                {"Bob", "1305"},
                {"Allen", "1010"},
                {"Allen", "1020"},
                {"Alex", "1030"},
                {"Charlie", "1205"},
                {"Charlie", "1215"},
                {"Bob", "1400"},
                {"Alex", "1400"},
                {"Alex", "900"}
        };
        checkUnusual(input2);

    }
    /*
    * input: String[][] input ->  ["Martha",   "exit"],[]
    * output:
    *   List<String> noExit
    *   List<String> noEnter
    * // name, enterTime ->  -1, +1 -> 0 +1
    * HashMap<String, Integer> map
    *
    * */

    public static void checkMismatch(String[][] input){
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] arr:input){
            String name = arr[0];
            String status = arr[1];
            if(!map.containsKey(name))
                map.put(name, 0);
            map.put(name, map.get(name) + (status.equals("exit") ? -1 : 1));
        }
        List<String> noExit = new ArrayList<>();
        List<String> noEnter = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) < 0){
                noEnter.add(key);
            }else if(map.get(key) > 0){
                noExit.add(key);
            }
        }
        System.out.println("misMatch enter: ");
        System.out.println(noEnter);
        System.out.println("misMatch exit: ");
        System.out.println(noExit);
    }

    /*input:
        String[][] input : ["Alex", "1300"], ["Alex", "1400"]
    * HashMap<String, List<Integer>> map ->
    *  Sort the list -> traverse the list -> to check if there any 3 or more badge times within one hour -> return the time slot


    * */

    public static void checkUnusual(String[][] badgeTime){
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(String[] arr : badgeTime){
            String name = arr[0];
            int time = Integer.parseInt(arr[1]);
            if(!map.containsKey(name)){
                map.put(name, new ArrayList<>());
            }
            map.get(name).add(time);
        }
        HashMap<String, List<Integer>> result = new HashMap<>();
        for(String name : map.keySet()){
            List<Integer> list = map.get(name);
            Collections.sort(list);
            /*
            * [1200,1210,1400,1410,1430,1450,1600]
            *              i
            *                             j
            *
            * */
            List<Integer> curRes = new ArrayList<>();
            for(int i = 0, j = 0; j < list.size(); j++){
                if(list.get(j) - list.get(i) <= 100){
                    curRes.add(list.get(j));
                }else{
                    if(j - i >= 3){
                        break;
                    }
                    i = j;
                    curRes.clear();
                }
            }
            if(curRes.size() >= 3){
                result.put(name, curRes);
            }

        }
        for(String name : result.keySet()){
            System.out.println(name + ": " + result.get(name));
        }
    }
}

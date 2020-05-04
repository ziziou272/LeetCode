package intuit.VO;

import java.util.*;

public class Badge {
    public static void main(String[] args){
        String[][] employees = new String[][]{
                {"Martha",   "exit"},
                {"Paul",     "enter"},
                {"Martha",   "enter"},
                {"Martha",   "exit"},
                {"Jennifer", "enter"},
                {"Paul",     "enter"},
                {"Curtis",   "enter"},
                {"Paul",     "exit"},
                {"Martha",   "enter"},
                {"Martha",   "exit"},
                {"Jennifer", "exit"}
        };
        //test1:
        find(employees);
        String[][] records2 = new String[][]{
                {"Paul","1355"},
                {"Jennifer","1910"},
                {"John","830"},
                {"Paul","1315"},
                {"John","835"},
                {"Paul","1405"},
                {"Paul","1630"},
                {"John","855"},
                {"John","915"},
                {"John","930"},
                {"Jennifer","1335"},
                {"Jennifer","730"},
                {"John","1630"},
        };
        HashMap<String, List<Integer>> map = findMoreThan3(records2);
        for(String ss: map.keySet()){
            System.out.println(ss + " " + map.get(ss));
        }
        System.out.println();
    }
    //q1:
    /*
    * name enter(t/f)
    * a exit remove
    * b enter
    * b enter
    * c enter
    * c exit  remove
    *
    *
    *
    * */
    public static void find(String[][] employees){
        //employee enter
        HashSet<String> map = new HashSet<>();
        HashSet<String> exitWithoutBadge = new HashSet<>();
        HashSet<String> enterWithoutBadge = new HashSet<>();

        for(String[] status : employees){
            String name = status[0];
            String sta = status[1];
            if(sta.equalsIgnoreCase("exit")){
                if(!map.contains(name))
                    enterWithoutBadge.add(name);
                else
                    map.remove(name);
            }
            else{//"enter"
                if(map.contains(name))
                    exitWithoutBadge.add(name);
                else
                    map.add(name);
            }
        }
        for(String name : map)
            exitWithoutBadge.add(name);

        System.out.println(exitWithoutBadge);
        System.out.println(enterWithoutBadge);
    }
    //q2:
    /*
     map: name : time List

    * */
    public static HashMap<String, List<Integer>> findMoreThan3(String[][] records){
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(String[] record : records){
            String name = record[0];
            int time = Integer.valueOf(record[1]);
            if(!map.containsKey(name))
                map.put(name, new ArrayList<>());
            map.get(name).add(time);
        }
        HashMap<String, List<Integer>> res = new HashMap<>();
        // 800 830 835 850 855 900 1000 1100 1200
        for(String name : map.keySet()){
            List<Integer> list = map.get(name);
            if(list.size() >= 3){
                //sort the List
                Collections.sort(list);
                for(int i = 0; i < list.size(); i++) {
                    int range = list.get(i) + 100;
                    List<Integer> curRes = new ArrayList<>();
                    curRes.add(list.get(i));
                    for(int j = i + 1; j < list.size(); j++){
                        if(list.get(j) <= range){
                           curRes.add(list.get(j));
                        }
                        else break;
                    }
                    if(curRes.size() >= 3){
                        res.put(name, curRes);
                        break;
                    }

                }
            }
        }
        return res;
    }



}

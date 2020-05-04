package intuit.VO;

import java.util.*;

public class employeeRelationship {
    public static void main(String[] args){
        //test:
        String[][] employee = new String[][]{
                {"3", "a", "HR"},
                {"1", "b", "EG"},
                {"2", "c", "EG"},
                {"5", "d", "EG"},
                {"6", "e", "SL"},
                {"8", "f", "HR"},
                {"7", "g", "SL"},
                {"4", "h", "SL"},
        };
        int[][] friend = new int[][]{
                {3, 2},
                {3, 4},
                {1, 5},
                {1, 2},
                {1, 3},
                {1, 4},
                {4, 2},
                {5, 4},
                {6, 5},
                {7, 1},
                {7, 6},
                {7, 2},
                {8,1}
        };
        Map<Integer, List<Integer>> map = getFriendList(employee, friend);
        for(Integer id : map.keySet()){
            System.out.println(id + ": " + map.get(id));
        }
        //test 2:
        Map<String, Integer> map2 = findFriend(employee, friend);
        for(String dep : map2.keySet()){
            System.out.println(dep + ": " + map2.get(dep));
        }
        //test3:
        System.out.println(sameGroup(employee, friend));

    }
    //q1:
    // employee: id, name, department   friend: a b
    public static Map<Integer, List<Integer>> getFriendList(String[][] employee, int[][] friend){
        //id list
        Map<Integer, List<Integer>> map = new HashMap<>();
        //traverse employee arr
        for(String[] em : employee){
            int id = Integer.valueOf(em[0]);
            String name = em[1];
            String department = em[2];
            map.put(id, new ArrayList<>());
        }
        // 1 2
        for(int[] relation : friend){
            map.get(relation[0]).add(relation[1]);
            map.get(relation[1]).add(relation[0]);
        }
        return map;
    }
    //q2:
    public static  Map<String, Integer> findFriend(String[][] employee, int[][] friend){
        // id department

        Map<Integer, String> idToDepMap = new HashMap<>();
        for(String[] em : employee){
            int id = Integer.valueOf(em[0]);
            String department = em[2];
            idToDepMap.put(id, department);
        }
        //department count
        Map<String, Integer> depCountMap = new HashMap<>();
        Map<Integer,List<Integer>> friendList = getFriendList(employee, friend);
        for(Integer id :friendList.keySet()){
            for(Integer frId :friendList.get(id)){
                String departmentName = idToDepMap.get(frId);
                //
                if(!idToDepMap.get(id).equals(idToDepMap.get(frId))){
                    if(!depCountMap.containsKey(departmentName))
                        depCountMap.put(departmentName, 0);
                    depCountMap.put(departmentName, depCountMap.get(departmentName) + 1);
                }
               }
        }
        return depCountMap;
    }
    //q3
    public static  boolean sameGroup(String[][] employee, int[][] friend){

        int size = employee.length;
        HashSet<Integer> visited = new HashSet<>();
        Map<Integer,List<Integer>> friendList = getFriendList(employee, friend);
        int[] count = new int[1];
        int id = Integer.valueOf(employee[0][0]);
        dfs(visited, friendList, count, id);

        return count[0] == size;
    }
    private static void dfs(HashSet<Integer>visited, Map<Integer,List<Integer>> friendList, int[] count, int id){
        if(visited.contains(id)) return;
        visited.add(id);
        count[0]++;
        for(Integer frId :friendList.get(id)){
            dfs(visited, friendList, count, frId);
        }
    }
}


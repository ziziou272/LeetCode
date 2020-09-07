package intuit.VO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FriendCycle {
    public static void main(String[] args) {
        String[] employees = new String[]{
                "1, Alex, Sales",
                "2, Allen, Engineering",
                "3, Bob, HR",
                "4, Bill, Sales",
                "5, Ben, Sales",
                "6, Cox, Engineering",
                "7, Curry, Engineering",
                "8, Dave, HR"
        };
        String[] relation = new String[]{
                "1, 2",
                "2, 3",
                "1, 6",
                "1, 7",
                "3, 5",
                "4, 1",
                "1, 3",
                "3, 4",
                "7, 2"
        };
        findFriend(employees, relation);
        countOtherDepartment(employees, relation);
    }

    /*
    * input employees: String[] employees ->["id, Name, Position"]
    * FriendShip: ["1, 2"],
    * HashMap<String, List<String>> map
    * name /id? -> id
    * */
    public static void findFriend(String[] employees, String[] relation){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : employees){
            String[] arr = str.split(",\\s+");
            map.put(arr[0], new ArrayList<>());
        }
        for(String str : relation){
            String[] arr = str.split(",\\s+");
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }
        for(String id : map.keySet()){
            System.out.println(id + ": " + map.get(id));
        }
    }

    /*
        Department -> list of employees(id)
    * HashMap<String, List<Sting>> department
    id -> department
    * HashMap<String, <Sting> employeeDepartment
    * */
    public static void countOtherDepartment(String[] employees, String[] relation){
        HashMap<String, List<String>> relationList = new HashMap<>();
        HashMap<String, List<String>> departmentMap = new HashMap<>();
        HashMap<String, String> employeeDepartment = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        for(String str : employees){
            String[] arr = str.split(",\\s+");
            relationList.put(arr[0], new ArrayList<>());
            if(!departmentMap.containsKey(arr[2])){
                result.put(arr[2], 0);
                departmentMap.put(arr[2], new ArrayList<>());
            }
            departmentMap.get(arr[2]).add(arr[0]);
            if(!employeeDepartment.containsKey(arr[0]))
                employeeDepartment.put(arr[0], arr[2]);
        }
        //build relation
        for(String str : relation){
            String[] arr = str.split(",\\s+");
            relationList.get(arr[0]).add(arr[1]);
            relationList.get(arr[1]).add(arr[0]);
        }
        for(String depart : departmentMap.keySet()){
            for(String id : departmentMap.get(depart)){
                //traverse friends
                List<String> list = relationList.get(id);
                if(list != null){
                    for(String friend : list){
                        if(!employeeDepartment.get(friend).equals(employeeDepartment.get(id))){
                            result.put(depart, result.get(depart) + 1);
                            break;
                        }
                    }
                }
            }
        }
        for(String department : result.keySet()){
            System.out.println(department + ": " + result.get(department) + " of " + departmentMap.get(department).size());
        }
    }
}

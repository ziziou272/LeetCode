package intuit.VO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class courseSchedule2 {
    public static void main(String[] args) {
        String[][] input = new String[][]{
                {"1", "A"},
                {"2", "B"},
                {"3", "C"},
                {"2", "A"},
                {"1", "C"},
                {"2", "D"},
                {"3", "E"},
                {"2", "E"},
        };
        getPair(input);
        String[][] input2 = new String[][]{
                {"A", "B"}

        };
        findMid(input2);
        String[][] input3 = new String[][]{
                {"Logic", "COBOL"},
                {"Data Structures", "Algorithms"},
                {"Creative Writing", "Data Structures"},
                {"Algorithms", "COBOL"},
                {"Intro to Computer Science", "Data Structures"},
                {"Logic", "Compilers"},
                {"Data Structures", "Logic"},
                {"Creative Writing", "System Administration"},
                {"Databases", "System Administration"},
                {"Creative Writing", "Databases"},
                {"Intro to Computer Science", "Graphics"}
        };
        findAllMid(input3);
    }
    /*
        {{"58", "A"},  {"94", "B"},  {"17", "A"},
        {"58", "B"},  {"17", "B"},  {"58", "C"}}
        输出:    [58, 94]: [B]
                [58, 17]: [A, B]
                [94, 17]: []

        hashMap: key: "1,2" -> "course"
    * */

    public static void getPair(String[][] input){
        HashMap<String, List<String>> pairCourseMap = new HashMap<>();
        for(int i = 0; i < input.length; i++){
            String student1 = input[i][0];
            for(int j = i + 1; j < input.length; j++){
                String student2 = input[j][0];
                if(input[i][1].equals(input[j][1])){
                    String pair = student1 + ", " + student2;
                    pairCourseMap.putIfAbsent(pair, new ArrayList<>());
                    pairCourseMap.get(pair).add(input[i][1]);
                }
            }
        }

        for(String pair : pairCourseMap.keySet()){
            System.out.println(pair + ": " + pairCourseMap.get(pair));
        }
    }

/*
Students may decide to take different "tracks" or sequences of courses in the Computer Science curriculum.
There may be more than one track that includes the same course, but each student follows a single linear track from
a "root" node to a "leaf" node. In the graph below, their path always moves left to right.

Write a function that takes a list of (source, destination) pairs, and returns the name of all of the courses that the
students could be taking when they are halfway through their track of courses.

Sample input:
all_courses = [
    ["Logic", "COBOL"],
    ["Data Structures", "Algorithms"],
    ["Creative Writing", "Data Structures"],
    ["Algorithms", "COBOL"],
    ["Intro to Computer Science", "Data Structures"],
    ["Logic", "Compilers"],
    ["Data Structures", "Logic"],
    ["Creative Writing", "System Administration"],
    ["Databases", "System Administration"],
    ["Creative Writing", "Databases"],
    ["Intro to Computer Science", "Graphics"],
]

Sample output (in any order):
          ["Data Structures", "Creative Writing", "Databases", "Intro to Computer Science"]

All paths through the curriculum (midpoint *highlighted*):

*Intro to C.S.* -> Graphics
Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> Compiler
Creative Writing -> *Databases* -> System Administration
*Creative Writing* -> System Administration
Creative Writing -> *Data Structures* -> Algorithms -> COBOL
Creative Writing -> *Data Structures* -> Logic -> COBOL
Creative Writing -> *Data Structures* -> Logic -> Compilers

Visual representation:

                    ____________
                    |          |
                    | Graphics |
               ---->|__________|
               |                          ______________
____________   |                          |            |
|          |   |    ______________     -->| Algorithms |--\     _____________
| Intro to |   |    |            |    /   |____________|   \    |           |
| C.S.     |---+    | Data       |   /                      >-->| COBOL     |
|__________|    \   | Structures |--+     ______________   /    |___________|
                 >->|____________|   \    |            |  /
____________    /                     \-->| Logic      |-+      _____________
|          |   /    ______________        |____________|  \     |           |
| Creative |  /     |            |                         \--->| Compilers |
| Writing  |-+----->| Databases  |                              |___________|
|__________|  \     |____________|-\     _________________________
               \                    \    |                       |
                \--------------------+-->| System Administration |
                                         |_______________________|

Complexity analysis variables:

n: number of pairs in the input
store inDegree -> inDegree == 0 will be start and
build graph
*/
    public static void findMid(String[][] input){
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> inDegreeMap = new HashMap<>();
        for(String[] pair : input){
            String pre = pair[0];
            String next = pair[1];
            inDegreeMap.putIfAbsent(pre, 0);
            inDegreeMap.put(next, inDegreeMap.getOrDefault(next, 0) + 1);
            graph.putIfAbsent(pre, new ArrayList<>());
            graph.putIfAbsent(next, new ArrayList<>());
            graph.get(pre).add(next);
        }
        //find start
        String startCourse = null;
        for(String course : inDegreeMap.keySet()){
            if(inDegreeMap.get(course) == 0)
                startCourse = course;
        }
        //get middle
        int total = inDegreeMap.size();
        //3 -> second , 2 -> 1 +==> (total+1)/2
        int mid = (total + 1) / 2;
        while(mid-- > 1){
            startCourse = graph.get(startCourse).get(0);
        }
        System.out.println(startCourse);
    }

    public static void findAllMid(String[][] input){
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> inDegreeMap = new HashMap<>();
        for(String[] pair : input){
            String pre = pair[0];
            String next = pair[1];
            inDegreeMap.putIfAbsent(pre, 0);
            inDegreeMap.put(next, inDegreeMap.getOrDefault(next, 0) + 1);
            graph.putIfAbsent(pre, new ArrayList<>());
            graph.putIfAbsent(next, new ArrayList<>());
            graph.get(pre).add(next);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        for(String course : inDegreeMap.keySet()){
            if(inDegreeMap.get(course) == 0){
                path.add(course);
                dfs(graph, res, path, course);
                path.remove(0);
            }
        }
        //get middle
        for(List<String> list : res){
            int total = list.size();
            int mid = (total - 1) / 2;
            String midCourse = list.get(mid);
            System.out.println("Middle course of: " + list + " is: ");
            System.out.println(midCourse);
        }


    }

    public static void dfs(HashMap<String, List<String>> graph, List<List<String>> res, List<String> path, String cur){
        if(graph.get(cur).size() == 0){
            res.add(new ArrayList<>(path));
        }
        for(String next : graph.get(cur)){
            path.add(next);
            dfs(graph, res, path, next);
            path.remove(path.size() - 1);
        }
    }



}

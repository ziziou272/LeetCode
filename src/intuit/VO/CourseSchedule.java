package intuit.VO;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args){
        String[][] student_course_pairs_1 = {
                {"58", "Software Design"},
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
        };
        Map<String, List<String>> res = sameClassPair(student_course_pairs_1);
        for(String pair : res.keySet()){
            System.out.print(pair + ": ");
            System.out.println(res.get(pair));
        }
        //q3:
        String[][] pre={
                {"A","C"},{"B","C"},{"C","D"},{"C","E"},{"D","F"},
                {"E","F"},{"F","G"}
        };
        List<List<String>> res3 = findMidPath(pre);
        for(List<String> list : res3){
            System.out.println(list);
        }


    }
    //q1:
    /*
m student and n courses
m * n ^ 2
* {
* {"58", "A"},
* {"94", "B"},
* {"17", "A"},
* {"58", "B"},
* {"17", "B"},
* {"58", "C"},
* {"17", "C"}
* } */
    public static Map<String, List<String>> sameClassPair(String[][] input){
        Map<String, List<String>> res = new HashMap<>();

        for(int i = 0; i < input.length; i++){
            String course = input[i][1];
            for(int j = i + 1; j < input.length; j++){
                String cur = input[j][1];
                if(course.equals(cur)){
                    String pair = input[i][0] + ", " + input[j][0];
                    if(!res.containsKey(pair)){
                        res.put(pair, new ArrayList<>());
                    }
                    res.get(pair).add(input[i][1]);
                }
            }
        }
        return res;
    }
    //q2:
    public static String findMid(String[][] input){
        HashMap<String, Integer> inDegree = new HashMap<>();
        HashMap<String, String> track = new HashMap<>();
        for(String[] course : input){
            //update in degree
            inDegree.put(course[1], 1);
            if(!inDegree.containsKey(course[0]))
                inDegree.put(course[0], 0);
            //update track
            track.put(course[0], course[1]);
        }
        int mid = (inDegree.size() - 1) / 2;
        String start = null;
        //find start
        for(String course : inDegree.keySet()){
            if(inDegree.get(course) == 0){
                start = course;
                break;
            }
        }
        String next = start;
        for(int i = 0; i < mid; i++){
            next = track.get(next);
        }
        return next;
    }
    //Q3:
    /*
A     D
   C      F G
B     E

count: 7
in degree :
A 0
B 0
C 2
D 1
E 1
F 2
G 1
GRAPH:
A: C
B: C
C: D E
D: F
E: F
F: G

7 -1 / 2  index 3   0 - 3
START: IN DEGREE 0
0      A         B
1      B         A
2      C         C
3   D     E   D    E
4   F     F   F    F
*/

    public static List<List<String>> findMidPath(String[][] input){
        //build the graph
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> inDegree = new HashMap<>();
        for(String[] course:input){
            String pre = course[0];
            String next = course[1];
            if(!inDegree.containsKey(next))
                inDegree.put(next, 0);
            if(!inDegree.containsKey(pre))
                inDegree.put(pre, 0);
            inDegree.put(next, inDegree.get(next) + 1);
            if(!graph.containsKey(pre))
                graph.put(pre, new ArrayList<>());
            if(!graph.containsKey(next))
                graph.put(pre, new ArrayList<>());
            graph.get(pre).add(next);
        }
        int num = graph.size();
        int mid = (num - 1) / 2;
        //start from all in degree == 0
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        for(String key : inDegree.keySet()){
            if(inDegree.get(key) == 0){
                path.add(key);
                dfs(res, path, mid, new int[]{0}, graph, key);
                path.remove(path.size() - 1);
            }
        }
        return res;
    }
    private static void dfs(List<List<String>> res, List<String> path, int mid, int[] count,
                            HashMap<String, List<String>> graph, String course){
        if(mid == count[0]){
            res.add(new ArrayList<>(path));
            return;
        }

        for(String next : graph.get(course)){
            path.add(next);
            count[0]++;
            dfs(res, path, mid, count, graph, next);
            path.remove(res.size() - 1);
            count[0]--;
        }
    }
}


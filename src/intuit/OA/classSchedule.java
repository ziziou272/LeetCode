package intuit.OA;

import java.util.HashMap;

public class classSchedule {
    public static void main(String[] args){
        classScheduleSolution solution = new classScheduleSolution();
    }
}







/**
Because each course has at most one prerequisite and no two courses share
the same prerequisite, which means there is only one path through the program.
 Therefore I came up to build the track using hashmap,
所以我就想到用hashmap把这个course track的关系表示出来，hashmap中的key是prerequisite，
value是the course after the prerequisite.

然后为了找到middle course，我需要先找到first course。所以我又建了另外一个hashmap，
key是course，value是他的indegree， 如果是course我就把它value set to 1，
 如果是prerequisite， 我就把value set to 0.
After traversing this input，
whose value in the hashmap is 0 would be my start course.

the size of inDegree hashmap is also the size of courses,
get the middle. Therefore we start from the first course and
count middle times to find the middle course
        a b    a         2 - 1 / 2
        a b c   b       3 - 1 /2    1
        a b c d    b    4 - 1 /2   1
        a b c d e   c    5- 1 / 2
In the beginning, I am not very sure about how to calculate the middle.
So I take 3 examples, which is 1 pair, 2 pairs, and 3 pairs.
*/

class classScheduleSolution{
    public String findMid(String[][] input){
        HashMap<String, Integer> inDegree = new HashMap<>();
        HashMap<String, String> track = new HashMap<>();
        for(String[] courses : input){//o(n)
            String prerequisite = courses[0];
            String course = courses[1];
            track.put(prerequisite, course);
            if(!inDegree.containsKey(prerequisite))
                inDegree.put(prerequisite, 0);
            inDegree.put(course, 1);
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
        //System.out.println(next);
        return next;
    }
}

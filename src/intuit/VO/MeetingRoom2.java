package intuit.VO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoom2 {
    public static void main(String[] args) {
        int [][] input = new int[][]{
                {900, 1030},
                {1100,1200}
        };
        canAdd(input, new int[]{900,1030});
        canAdd(input, new int[]{700,1030});
        canAdd(input, new int[]{700,900});
        canAdd(input, new int[]{1200,1330});
        System.out.println("Q2-----------");
        int [][] input2 = new int[][]{
                {900, 1030},
                {1100,1200},
                {900,1030},
                {700,1030},
                {1200,1330},
                {700,900}
        };
        findFreeTime(input2);
    }

    /*
    * [0900,1030],[1100,1200]
    * [0900,0920]   false
    * [1200,1300]   true
    *
    *
    * */

    public static boolean canAdd(int[][] input, int[] newMeeting){
        //traverse  if start time overlaps with certain meeting or end time overlaps
        // startTime <= newStartTime < endTime || startTime < newEndTime <= endTime
        for(int[] time : input){
            if(newMeeting[0] >= time[0] && newMeeting[0] < time[1] || (newMeeting[1] > time[0] && newMeeting[1] <= time[1])){
                System.out.println("False");
                return false;
            }

        }
        System.out.println("True");
        return true;
    }
    public static void findFreeTime(int[][] input){
        Arrays.sort(input,(a, b) -> a[0]-b[0]);
        List<int[]> occupiedTime = new ArrayList<>();
        for(int i = 0; i < input.length; i++){
            int[] time = input[i];
            if(occupiedTime.size() != 0){
                int[] prevTime = occupiedTime.get(occupiedTime.size() - 1);
                if(time[0] <= prevTime[1] || time[1] <= prevTime[1]){
                    prevTime[1] = Math.max(prevTime[1], time[1]);
                }
                else{
                    occupiedTime.add(time);
                }
            }else{
                occupiedTime.add(time);
            }
        }
        List<int[]> freeTime = new ArrayList<>();
        for(int i = 0; i < occupiedTime.size(); i++){
            int[] free = new int[]{occupiedTime.get(i)[1], i == occupiedTime.size() - 1 ? 2400 : occupiedTime.get(i+1)[0]};
            freeTime.add(free);
        }
        if(occupiedTime.get(0)[0] != 0)
            freeTime.add(0, new int[]{0, occupiedTime.get(0)[0]});
        for(int[] time : freeTime){
            System.out.print(time[0]);
            System.out.print("--");
            System.out.println(time[1]);
        }
    }

    /**
     * input:
     *  meeting: name, numberOfPeople, starTime, endTime
     *  room: name, capacity
     * output:
     *  meetingName: roomName
     *  "impossible"
     */
    class Meeting{
        String name;
        int numOfPeople;
        int startTime;
        int endTime;
        public Meeting( String name,
                int numOfPeople,
                int startTime,
                int endTime){
            this.name = name;
            this.numOfPeople = numOfPeople;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    class Room{
        String name;
        int capacity;
        boolean occupied;
        public Room(String name, int capacity){
            this.name = name;
            this.capacity = capacity;
            occupied = false;
        }
    }

    /**
     * put the input info to the Meeting list and rooms list
     *                    5    15    8    10    6
     * sorted start time[700, 800, 830, 1000,1200]
     *                                         s
     *                  5    8     15    6    10
     * sorted end time[800, 900, 1300, 1500, 1600]
     *                       e
     *                  o    o
     * sorted rooms[5, 10, 15]
     */
    public static void assignRoom(List<Meeting> meetings, List<Room> rooms){
        List<Meeting> start = new ArrayList<>(meetings);
        List<Meeting> end = new ArrayList<>(meetings);
        start.sort((a,b) -> a.startTime - b.startTime);
        end.sort((a,b) -> a.endTime - b.endTime);
        rooms.sort((a, b) -> a.capacity - b.capacity);



    }






}

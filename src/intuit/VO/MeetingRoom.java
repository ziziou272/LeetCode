package intuit.VO;

import java.lang.reflect.Array;
import java.util.*;

public class MeetingRoom {
    public static void main(String[]args){
        //test
        int[][] meetings = new int[][]{
                {800,830},
                {1000,1300},
                {1200,1400},
                {820,900},
                {1400,1430},
                {700,750},
        };
        System.out.println(canFit(meetings, 1600,1630));
        System.out.println(canFit(meetings, 800,1630));
        System.out.println(canFit(meetings, 100,1330));
        //test2
        List<int[]> res = findAvailable(meetings);
        for(int[] re : res){
            System.out.print(re[0] +": ");
            System.out.println(re[1]);
        }
        //test3:
        List<String> meetingList = new ArrayList<>();
        meetingList.add("m1" + " " + "5" + " " + "800" + " " + "830");
        meetingList.add("m2" + " " + "8" + " " + "1000" + " " + "1030");
        meetingList.add("m3" + " " + "10" + " " + "1000" + " " + "1130");
        meetingList.add("m4" + " " + "10" + " " + "1400" + " " + "1430");
        meetingList.add("m5" + " " + "12" + " " + "1300" + " " + "1330");
        meetingList.add("m6" + " " + "5" + " " + "1000" + " " + "1030");
        meetingList.add("m7" + " " + "8" + " " + "1100" + " " + "1230");
        meetingList.add("m8" + " " + "5" + " " + "900" + " " + "930");
        meetingList.add("m9" + " " + "18" + " " + "800" + " " + "820");
        List<String> roomList = new ArrayList<>();
        roomList.add("a" + " " + " 5");
        roomList.add("b" + " " + "8");
        roomList.add("c" + " " + " 10");
        roomList.add("d" + " " + " 10");
        roomList.add("e" + " " + " 15");
        List<String> roomres = assignRoom(meetingList, roomList);
        System.out.println(roomres);
    }

    /*
    * ex: {[1300, 1500], [930, 1200],[830, 845]},
    * 新的meeting[820, 830]*/

    /** q1:
     *  1. check if the start time is in between any existing meetings
     *  2. there in one case that start time is before the start time of any meeting
     *  but the end time is in between the meeting times, that's is also not valid
     *  [1000,1100]   [1000 1050] or [800,1020]
     */
    public static boolean canFit(int[][] meetings, int start, int end){
        //corner case
        if(meetings == null || meetings.length ==0 || meetings[0] == null || meetings[0].length == 0)
            return true;
        for(int[] meeting : meetings){
            if(start >= meeting[0] && start <= meeting[1] || (start <= meeting[0] && end >= meeting[0]))
                return false;
        }
        return true;
    }
    /** q2
    I think I could sort it to traverse from the earliest time
    so i need override the comparator to compare the start time only
    1. if current start time is in the time range of previous one,
    then we can merger these 2 meetings, selection the greater one as end time
    2. after that I will traverse the merged array one more time to get the available time
    {800,830},
    {820,900}
    {1000,1300},
    {1200,1400},
    {1400,1430}
    {700,750}
     */
    public static List<int[]> findAvailable(int[][] meetings){
        Arrays.sort(meetings, new Comparator<int[]>() {
           public int compare(int[] a, int[] b){
               return a[0] - b[0];
           }
        });
        List<int[]> res = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < meetings.length; i++){
            int curStart = meetings[i][0], curEnd = meetings[i][1];
            //overlap
            if(curStart >= meetings[index][0] && curStart <= meetings[index][1]){
                meetings[index][1] = Math.max(curEnd, meetings[index][1]);
            }
            else{
                index++;
                meetings[index][0] = curStart;
                meetings[index][1] = curEnd;
            }
        }
        //add from 00:00
        if(meetings[0][0] != 0)
            res.add(new int[]{0, meetings[0][0]});
        //form 0 to index
        /*  {700,750}
        *   {800,830},
            {820,900}
            {1000,1300},
            {1200,1400},
            {1400,1430}
        * */
        for(int i = 0; i < index; i++){
            int start = meetings[i][1];
            int end = meetings[i + 1][0];
            res.add(new int[]{start, end});
        }
        if(meetings[index][1] < 2400)
            res.add(new int[]{meetings[index][1], 2400});
        return res;
    }
    //q3:
    /*
给会议分配房间。已知每个会议的人数、开始时间、结束时间，以及每个房间的容量。
输入：
    会议列表：每个会议有名称、人数、开始时间、结束时间
    房间列表：每个房间有名称、容量。
输出：
    每个会议安排在哪个房间，格式是“会议名:房间名”
    如果没法都安排，输出"impossible"
    1. build 2 class:
        Meeting class :
        Room class
    * */

    /**
     * I would like to build 2 classes, one is meeting class and another one is room class
     */
    static class Meeting{
        String name;
        int count;
        int start;
        int end;
        Room room;

        public Meeting(String name, int count, int start, int end) {
            this.name = name;
            this.count = count;
            this.start = start;
            this.end = end;
            room = null;
        }
    }
    static class Room{
        String name;
        int capacity;
        boolean occupied;
        public Room(String name, int capacity, boolean occupied) {
            this.name = name;
            this.capacity = capacity;
            this.occupied = occupied;
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
    public static List<String> assignRoom(List<String> meetings, List<String> rooms){
        //transfer to List<Meeting> and List<Room>
        List<Meeting> meetingList = new ArrayList<>();
        for(String meeting : meetings){
            String[] str = meeting.split("\\s+");
            String name = str[0];
            int count = Integer.parseInt(str[1]);
            int start = Integer.parseInt(str[2]);
            int end = Integer.parseInt(str[3]);
            meetingList.add(new Meeting(name, count, start, end));
        }
        List<Room> roomList = new ArrayList<>();
        for(String room : rooms){
            String[] str = room.split("\\s+");
            String name = str[0];
            int count = Integer.parseInt(str[1]);
            roomList.add(new Room(name, count, false));
        }
        List<Meeting> meetingListEnd = new ArrayList<>(meetingList);

        Collections.sort(meetingList,(a, b) -> a.start - b.start);
        Collections.sort(meetingListEnd,(a,b) -> a.end - b.end);
        Collections.sort(roomList, (a, b) -> a.capacity - b.capacity);
        //start and end pointer
        int s = 0, e = 0;
        List<String> res = new ArrayList<>();
        boolean canFit = true;
        while(s < meetingList.size() && e < meetingList.size()){
            Meeting start = meetingList.get(s);
            Meeting end = meetingList.get(e);
            if(start.start < end.end){
                if(!findRoom(start, roomList)){
                    canFit = false;
                    break;
                }
                res.add(start.name + ": " + start.room.name);
                s++;
            }
            else{
                end.room.occupied = false;
                e++;
            }
        }
        if(!canFit){
            List<String> re = new ArrayList<>();
            re.add("impossible");
            return re;
        }
        return res;
    }
    private static boolean findRoom(Meeting cur, List<Room> list){
        for(Room room : list){
            if(!room.occupied && room.capacity >= cur.count){
                cur.room = room;
                room.occupied = true;
                return true;
            }
        }
        return false;
    }
}
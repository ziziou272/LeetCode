package VMwarePropelOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EmailThread {
    public static void main(String[] args) {
        String[] input = new String[10];
        /*
* s     r   c
* a@   b@   "hello"   [1,1]
* c@   d@    "hi"     [2,1]
* b@   a@    "hello there" -- "hello"  [1,2]
* c@   d@    "hi"      [3,1]
* d@   c@    "hi!" -- "hi"
* e@   a@    "hru"  [4,1]
* a@   b@    "yes" -- "hello there" -- "hello"  [1,3]*/

        input[0] = "a@gmail.com, b@gmail.com, first";
        input[1] = "b@gmail.com, c@gmail.com, first2";
        input[2] = "c@gmail.com, a@gmail.com, first3";
        input[3] = "b@gmail.com, a@gmail.com, second---first";
        input[4] = "a@gmail.com, b@gmail.com, first3";
        input[5] = "b@gmail.com, a@gmail.com, third---second---first";
        input[6] = "a@gmail.com, b@gmail.com, fourth---third---second---first";
        input[7] = "b@gmail.com, a@gmail.com, fifth---fourth---third---second---first";
        input[8] = "b@gmail.com, a@gmail.com, first4";
        input[9] = "h@gmail.com, a@gmail.com, first5";
        List<int[]> res = getEmailThreads(input);
        for(int[] arr : res){
            System.out.println(Arrays.toString(arr));
        }
    }
    static class Thread{
        int id;
        List<String> content;

        public Thread(int id){
            this.id = id;
            this.content = new ArrayList<>();
        }
        public Thread(int id, String str){
            this.id = id;
            this.content = new ArrayList<>();
            content.add(str);
        }
        public void add(String str){
            this.content.add(str);
        }

        @Override
        public int hashCode() {
            return this.id;
        }
    }

    public static List<int[]>  getEmailThreads(String[] emails){
        int id = 0;
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> idMap = new HashMap<>();
        //"sender+receiver", <most recent reply, threads with same recent reply>
        HashMap<String, HashMap<String, List<Thread>>> map = new HashMap<>();
        for(String email : emails){
            //check new email or reply
            String[] arr = email.split(", ", 3);
            String sender = arr[0];
            String receiver = arr[1];
            String contentStr = arr[2];
            String pair = sender + receiver;
            //put to map if no this pair
            if(!map.containsKey(sender+receiver) && !map.containsKey(receiver+sender)){
                map.put(pair, new HashMap<>());
            }
            HashMap<String, List<Thread>> innerMap = null;
            if(map.containsKey(sender+receiver)){
                innerMap = map.get(sender+receiver);
            }else{
                innerMap = map.get(receiver+sender);
            }

            String[] contents = contentStr.split("---");
            //new thread
            if(contents.length == 1){
                innerMap.putIfAbsent(contents[0], new ArrayList<>());
                innerMap.get(contents[0]).add(new Thread(id, contents[0]));
                idMap.put(id, 1);
                result.add(new int[]{id, 1});
                id++;
            }else{
                List<Thread> list = innerMap.get(contents[1]);
                Thread cur = null;
                //only one threads
                if(list.size() == 1){
                    list.get(0).add(contents[0]);
                    innerMap.remove(contents[1]);
                    innerMap.putIfAbsent(contents[0], new ArrayList<>());
                    cur = list.get(0);
                    innerMap.get(contents[0]).add(cur);
                }else{
                    for(int i = 0; i < list.size(); i++){
                        if(list.get(i).content.size() + 1 == contents.length){
                            cur = list.get(i);
                            list.remove(i);
                            break;
                        }
                    }
                    innerMap.putIfAbsent(contents[0], new ArrayList<>());
                    innerMap.get(contents[0]).add(cur);
                }
                result.add(new int[]{cur.id, idMap.get(cur.id)+1});
                idMap.put(cur.id, idMap.get(cur.id) + 1);
            }
        }
        return result;
    }

}
/*
* s     r   c
* a@   b@   "hello"   [1,1]
* c@   d@    "hi"     [2,1]
* b@   a@    "hello there" -- "hello"  [1,2]
* c@   d@    "hi"      [3,1]
* d@   c@    "hi!" -- "hi"
* e@   a@    "hru"  [4,1]
* a@   b@    "yes" -- "hello there" -- "hello"  [1,3]
*
*                                  most recent reply
* HashMap<"Send+receiver", HashMap<String, Thread>>
* //no send+receiver --> add to map    pair, thread++, new list(content)
* //
* Thread{
*   id;
*   List<String> content;
* }
*
 * */

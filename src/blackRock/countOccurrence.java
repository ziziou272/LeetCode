package blackRock;

import java.util.regex.Pattern;

public class countOccurrence {
    public static void main(String[] args) {
        System.out.println(count("aaaajkhaa", "aa"));
        System.out.println(count("aaadsaaa", "aa"));
        System.out.println(count("easaad", "aa"));
        System.out.println(count("sa", "aa"));
    }

    public static int count(String str, String subStr) {
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = str.indexOf(subStr,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += subStr.length();
            }
        }
        return count;
    }
}

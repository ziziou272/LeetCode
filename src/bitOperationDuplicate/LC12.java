package bitOperationDuplicate;

import java.util.HashMap;
import java.util.TreeSet;

public class LC12 {
    public String intToRoman(int num) {

        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(5);
        set.add(10);
        set.add(50);
        set.add(100);
        set.add(500);
        set.add(1000);
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        StringBuilder sb = new StringBuilder();
        if(num == 4|| num==9||num==40||num==90||num==400||num==900)
            sb.append(map.get(num));
        while(num != 0){
           int temp = set.floor(num);
            sb.append(map.get(temp));
            num = num - temp;
        }
        return sb.toString();
    }
}

package Special1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LC937customSort {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] split1 = s1.split(" ", 2);
                String[] split2 = s2.split(" ", 2);
                char split1first = split1[1].charAt(0);
                char split2first = split2[1].charAt(0);

                if(!Character.isDigit(split1first) && !Character.isDigit(split2first)){//both are not number
                    //compare first letter
                    int res = split1[1].compareTo(split2[1]);
                    if(res != 0)
                        return res;
                    else
                        return split1[0].compareTo(split2[0]);
                }
                else if(Character.isDigit(split1first) && Character.isDigit(split2first)){
                    return -1;
                }
                else
                    return Character.isDigit(split1first) ?  -1 : 0;

            }
        };

        Arrays.sort(logs, comp);
        return logs;
    }
}

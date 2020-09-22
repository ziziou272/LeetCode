package AamazonOA2_2020;

import java.util.ArrayList;
import java.util.List;

public class LC763PartitionLables {
    public List<Integer> partitionLabels(String S) {
        int[] charMap = new int[26];
        char[] charArr = S.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            charMap[charArr[i] - 'a'] = i;
        }
        int i = 0;
        List<Integer> res = new ArrayList<>();
        while(i < charArr.length){
            int boundary = i;
            int size = 0;
            for(;i <= boundary; i++){
                boundary = Math.max(boundary, charMap[charArr[i] - 'a']);
                size++;
            }
            res.add(size);
        }
        return res;
    }
}
/*


ababcbaca defegde hijhklij
i

[i,max(x1)]
[i,max(x5)]
[i,x9]

a:x1
b:x2
c:x3
d:x4
e:x5
f:x6
g:x7
h:x8
j:x9
k:x10



*/
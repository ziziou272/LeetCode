package VMwarePropelOA;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class BuildSequence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildSubsequences("xyz")));
        System.out.println(Arrays.toString(buildSubsequences("ba")));
    }
    public static String[] buildSubsequences(String s){
        //cdeaf
        TreeSet<String> treeSet = new TreeSet<>();
        dfs(s, 0, treeSet, new StringBuilder());
        String[] res = new String[treeSet.size()];
        int i = 0;
        for (String str : treeSet){
            res[i++] = str;
        }
        return res;
    }

    private static void dfs(String s, int index, TreeSet<String> treeSet, StringBuilder sb){
        if(index >= s.length()) return;
        for(int i = index; i < s.length(); i++){
            //add current char
            sb.append(s.charAt(i));
            treeSet.add(sb.toString());
            dfs(s, i + 1, treeSet, sb);
            //set back
            sb.setLength(sb.length() - 1);
        }
    }
}
/*
* c d e a f
*
*          c    d   e  a f
*    deaf    eaf   af  f
*
* */

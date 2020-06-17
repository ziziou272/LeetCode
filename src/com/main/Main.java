package com.main;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,null,2,2,null,3,4,5,5);
        deDuplicateIterator it = new deDuplicateIterator(list);
        while(it.hasNext())
            System.out.println(it.next());

    }
}

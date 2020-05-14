package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> words = new ArrayList<>();
        words.add("abcdefgdgsd");
        words.add("was the best was");
        words.add("the most of");
        words.add("time.");

        List<String> splitWord = new ArrayList<>();
        for(String sentence : words)
            splitWord.addAll(Arrays.asList(sentence.split("\\s+")));
        System.out.println();
    }
}

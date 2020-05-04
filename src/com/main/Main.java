package com.main;

import BinarySearch.LC302;
import BinarySearch.LC334;
import DFS.LC216DFS;
import DFS.LC46Permutation;
import DFS.LC90;
import DP.*;
import Design.LRUCache;
import Graph.LCC210;
import Recursion.LC59;
import Recursion.LC59LCSL;
import UnionFind.LC200unionFind;
import UnionFind.LC261re;
import UnionFind.LC305Ans;
import UnionFind.LC399;
import bitOperationDuplicate.LC219HashTableSo;
import bitOperationDuplicate.LC220BalacnedTree;
import stringAndArray.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

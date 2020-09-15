package com.main;

import bitOperation.addTwoNumberWithoutPlus;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int x = 2437, y = 875;
        while(x != y){
            if(x > y) x = x - y;
            if(x < y) y = y - x;
        }
        System.out.println(x);
    }
}

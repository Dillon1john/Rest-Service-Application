package edu.citytech.cst.project.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ABCCounterService {

   public static boolean isConsonant(String digit){
        return !isVowel(digit);
    }

   public static boolean isVowel(String digit){

        digit = digit.length() > 1 && digit.contains("-") ? digit.split("-")[0] : digit;

        // Java 8 Functional Programming
        boolean isVowel = Stream.of("a","e","i","o","u")
                                .anyMatch(digit::equalsIgnoreCase);
        return isVowel;
    }


    public static List<Character> countCBA() {
        var abc = countABC();
        Collections.reverse(abc);
        return abc;
    }

    public static List<Character> countABC() {

        ArrayList<Character> list = new ArrayList<>();

        for(char c = 'A'; c <= 'Z'; ++c)
            list.add(c);

        for(char c = 'a'; c <= 'z'; ++c)
            list.add(c);

        return list;
    }

    public static List<Integer> count123() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int c = 1; c <= 500; ++c)
            list.add(c);
        return list;
    }

    public static List<Integer> count321() {
        var list = count123();
        Collections.reverse(list);
        return list ;
    }

    public static List<Integer> count369() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int c = 1; c <= 500; ++c)
            list.add(c * 3);
        return list;
    }

    public static boolean isEven(int no) {
        return no % 2 == 0;
    }
    public static boolean isOdd(int no) {
        return !isEven(no);
    }
    public static boolean isEvery6(int no) {
        return no % 6 == 0;
    }

    public static List<String> countAa() {
        var list = new ArrayList<String>();

        for(char c = 'A'; c <= 'Z'; ++c)
            list.add(c + "-" + Character.toLowerCase(c));

        return list;
    }

    public static boolean is7(Integer number) {
       return Integer.toString(number).contains("7");
    }
}
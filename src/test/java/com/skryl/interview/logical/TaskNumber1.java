package com.skryl.interview.logical;

import java.util.HashMap;
import java.util.Map;

/**
 * Objective: Count character in string "GeeksForGeeks"
 */
public class TaskNumber1 {


    public static void main(String[] args) {
        var given = "GeeksForGeeks";
        System.out.println("Characters counts: " + countCharacterInWords(given));
    }

    private static String countCharacterInWords(String given) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (Character c : given.toCharArray()) {
            if(charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }
        return charCount.toString();
    }
}

package com.lea.leet.alg;


import java.util.*;

public class Solution893 {

    public int numSpecialEquivGroups(String[] A) {

        Set<String> set = new HashSet<>();

        for (String str : A) {
            set.add(getStr(str));
        }

        return set.size();
    }

    private String getStr(String str) {

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                first.append(str.charAt(i));
            } else {
                second.append(str.charAt(i));
            }
        }

        char[] array1 = first.toString().toCharArray();
        Arrays.sort(array1);

        char[] array2 = second.toString().toCharArray();
        Arrays.sort(array2);

        return new String(array1) + new String(array2);
    }

    public static void main(String[] args) {

        List<Character> list = new ArrayList<>();
        list.add('d');
        list.add('c');
        list.add('a');

        list.sort(Comparator.comparing(Character::charValue));

    }

}

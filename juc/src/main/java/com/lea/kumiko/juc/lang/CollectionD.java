package com.lea.kumiko.juc.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class CollectionD {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            stringList.add("kitty" + i);
        }


        List<String> kitty = Arrays.asList("kitty");

        System.out.println(kitty.getClass());


        ListIterator<String> listIterator = stringList.listIterator(stringList.size());

        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

    }
}

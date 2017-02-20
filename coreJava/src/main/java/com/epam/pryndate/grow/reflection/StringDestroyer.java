package com.epam.pryndate.grow.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tetiana_Prynda
 *         Created on 2/17/2017.
 */
public class StringDestroyer {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        Field value = String.class.getDeclaredField("value");
//        value.setAccessible(true);
//        value.set("hello!", "cheers".toCharArray());
//        System.out.println("hello!");
//
//        Field intValue = Integer.class.getDeclaredField("value");
//        intValue.setAccessible(true);
//        intValue.set(42, 43);
//        System.out.printf("Six times Seven = %d%n", 6 * 7);

        Map<Integer, String> meaningOfLife = new HashMap<>();
        meaningOfLife.put(42, "The Meaning of Life");

        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);
        value.set(42, 43);

        System.out.println(meaningOfLife.get(42));
        System.out.println(meaningOfLife.get(43));
    }
}

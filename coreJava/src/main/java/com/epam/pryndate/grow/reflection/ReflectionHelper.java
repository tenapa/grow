package com.epam.pryndate.grow.reflection;

import sun.reflect.FieldAccessor;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Tetiana_Prynda
 *         Created on 2/20/2017.
 */
public class ReflectionHelper {
    private static final ReflectionFactory reflection =
            ReflectionFactory.getReflectionFactory();

    private final static Object obj = "Hello world!";

    public static void main(String... args)
            throws NoSuchFieldException, IllegalAccessException {
        ReflectionHelper.setStaticFinalField(
                ReflectionHelper.class.getDeclaredField("obj"),
                "Goodbye cruel world!"
        );
        System.out.println("obj = " + obj);
    }

    public static void setStaticFinalField(Field field, Object value)
            throws NoSuchFieldException, IllegalAccessException {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        int modifiers = modifiersField.getInt(field);
        modifiers &= ~Modifier.FINAL;
        modifiersField.setInt(field, modifiers);
        FieldAccessor fa = reflection.newFieldAccessor(field, false);
        fa.set(null, value);
    }
}

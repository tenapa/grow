package com.epam.pryndate.grow.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Tetiana_Prynda
 *         Created on 2/16/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = NotesHolder.class)
public @interface Note {
    String value();

}

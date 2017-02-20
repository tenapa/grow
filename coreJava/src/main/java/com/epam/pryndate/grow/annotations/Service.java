package com.epam.pryndate.grow.annotations;

import java.lang.annotation.*;

/**
 * @author Tetiana_Prynda
 *         Created on 2/16/2017.
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String name();

    boolean lazyLoad() default false;
}

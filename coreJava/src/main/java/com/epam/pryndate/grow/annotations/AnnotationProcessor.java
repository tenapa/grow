package com.epam.pryndate.grow.annotations;

import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Tetiana_Prynda
 *         Created on 2/16/2017.
 */
public class AnnotationProcessor {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(ThrowingService.class);
        inspectService(String.class);

        SimpleService simpleService = createClassInstance("SimpleService");
        simpleService.init();
    }

    private static<T> T createClassInstance(String simpleService) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> newClass = Class.forName(simpleService);
        final Object newClassObject = newClass.newInstance();
        return (T) newClass;
    }

    private static void inspectService(Class<?> serviceClass) {
        if (serviceClass.isAnnotationPresent(Service.class)) {
            final Service serviceAnnotation = serviceClass.getAnnotation(Service.class);
            System.out.println("Class " + serviceClass.getName() + " has annotation " + Service.class.getSimpleName()
                    + " with name " + serviceAnnotation.name() + " and it is lazy loaded: " + serviceAnnotation.lazyLoad());
        } else {
            System.out.println("Class " + serviceClass.getSimpleName() + " has no annotation of " + Service.class.getSimpleName());
        }
        if (serviceClass.isAnnotationPresent(NotesHolder.class)) {
            final Note[] notes = serviceClass.getAnnotationsByType(Note.class);
            System.out.println("Class " + serviceClass.getSimpleName() + " has notes: " + Arrays.toString(notes));
        }

        final Method[] methods = serviceClass.getMethods();
        for (final Method method : methods) {
            if (method.isAnnotationPresent(Init.class)) {
                System.out.println("Class " + serviceClass.getSimpleName() + " has method " + method.getName() + " with annotation " + Init.class.getSimpleName());
            }
        }

    }
}

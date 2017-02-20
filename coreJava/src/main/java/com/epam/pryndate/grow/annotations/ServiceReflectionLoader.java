package com.epam.pryndate.grow.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Tetiana_Prynda
 *         Created on 2/16/2017.
 */
public class ServiceReflectionLoader {
    static Collection<String> classNames = new LinkedList<>();

    static {
        classNames.add("com.epam.pryndate.grow.annotations.Initializable");
        classNames.add("com.epam.pryndate.grow.annotations.SimpleService");
        classNames.add("com.epam.pryndate.grow.annotations.LazyService");
        classNames.add("com.epam.pryndate.grow.annotations.ThrowingService");
        classNames.add("com.epam.pryndate.grow.annotations.AnnotationProcessor");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Map<String, Class> serviceClasses = new HashMap<>();
        Map<String, Object> serviceObjects = new HashMap<>();
        for (String className : classNames) {
            Class<?> newClass = Class.forName(className);
            if (newClass.isAnnotationPresent(Service.class)) {
                final Service serviceAnnotation = newClass.getAnnotation(Service.class);
                serviceClasses.put(serviceAnnotation.name(), newClass);
                serviceObjects.put(serviceAnnotation.name(), newClass.newInstance());
            }
        }

        System.out.println(serviceClasses);
        System.out.println(serviceObjects);

        for (Object serviceObject : serviceObjects.values()) {
            if(serviceObject.getClass().getAnnotation(Service.class).lazyLoad()){
                System.out.println("No need to init service "+serviceObject.getClass().getSimpleName());
                continue;
            }
            for (Method method : serviceObject.getClass().getMethods()) {
                if (method.isAnnotationPresent(Init.class) && method.getParameterCount() == 0) {
                    try{
                        method.invoke(serviceObject);
                    } catch (Exception e) {
                        if(method.getAnnotation(Init.class).suppressException()){
                            System.err.println(e.getCause().getMessage());
                        }else{
                            throw e;
                        }
                    }
                }
            }
        }
    }

}

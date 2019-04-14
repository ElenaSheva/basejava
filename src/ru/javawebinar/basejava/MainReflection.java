package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("fullNameDefault");
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        System.out.println(r);

        Class<?> resumeClass = Class.forName("ru.javawebinar.basejava.model.Resume");
        String methodName = "toString";
        Method getNameMethod = r.getClass().getMethod(methodName);
        String name = (String) getNameMethod.invoke(r);
        System.out.println(name);

    }
}

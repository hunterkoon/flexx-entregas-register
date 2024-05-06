package com.flexx.register.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class ConverterUtil {

    public static <T> Object convertToDTO(Object input, Object output) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] inputFields = input.getClass().getDeclaredFields();
        Field[] outputFields = output.getClass().getDeclaredFields();

        Object inputObject = input.getClass().getDeclaredConstructor().newInstance();
        Object outPutObject = output.getClass().getDeclaredConstructor().newInstance();



        return null;
    }
}

package com.example.playlist_api.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionUtils {

    public static String getClassName(Object obj) {
        return obj.getClass().getName();
    }

    public static List<String> getFields(Object obj) {
        return Arrays.stream(obj.getClass().getDeclaredFields())
                .map(field -> field.getName())
                .collect(Collectors.toList());
    }

    public static List<String> getMethods(Object obj) {
        return Arrays.stream(obj.getClass().getDeclaredMethods())
                .map(method -> method.getName())
                .collect(Collectors.toList());
    }
}

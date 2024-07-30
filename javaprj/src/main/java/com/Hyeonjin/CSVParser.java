package com.Hyeonjin;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.Hyeonjin.annotations.Precision;
import com.Hyeonjin.annotations.Transient;

public class CSVParser {

    public static <T> String toCSV(T entity) throws IllegalAccessException, InvocationTargetException {
        // 객체 이미 만듬 App3
        StringBuilder sb = new StringBuilder(); // 문자열 만드는 객체

        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) entity.getClass();

        // 필드값 확인
        {
            Field[] fields = clazz.getDeclaredFields();

            for (Field f : fields) {
                if (!f.isAnnotationPresent(Transient.class)) {
                    continue;
                }
                f.setAccessible(true);
                Object fieldValue = f.get(entity);
                System.out.println(fieldValue);
            }
        }

        Method[] methods = clazz.getDeclaredMethods(); // 메소드들

        for (Method m : methods) { // for
            String methodName = m.getName(); //

            if (!methodName.startsWith("get")) {
                continue;
            }

            if (m.isAnnotationPresent(Transient.class)) {
                continue;
            }

            Object value = m.invoke(entity);
            if (m.isAnnotationPresent(Precision.class)) {
                Precision precision = m.getAnnotation(Precision.class);
                int formatNumber = precision.value();
                value = String.format("%." + formatNumber + "f", value);
            }

            sb
                    .append(value)
                    .append(",");
        }

        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}

package com.example.Kypchange.service.refl;

import java.lang.reflect.Field;

public class ReflClass {

    public static <T> T getFieldValue(Object obj, String fieldName, Class<T> fieldType) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equalsIgnoreCase(fieldName)) {
                return fieldType.cast(field.get(obj));
            }
        }
        throw new IllegalArgumentException("Campo '" + fieldName + "' não encontrado no objeto.");
    }

}

package com.sdm.multilingual.utils;

import com.sdm.multilingual.models.tables.Partition;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class SystemUtil {

    private static final int LEVEL_OF_METHOD = 3;
    private static final String NAME_OF_STATIC = "static";
    private static final String NAME_OF_FINAL = "final";

    /**
     * Method Name 얻기
     */
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[LEVEL_OF_METHOD].getMethodName();
    }

    /**
     * Entity 이동하기
     */
    public static <T> void moveEntityToEntity(String[] exceptFields, Class<T> entity, Object from, Object to) throws Exception {
        Field[] fields = entity.getDeclaredFields();
        for (Field field : fields) {
            if (
                    field.get(from) != null
                            &&
                            Modifier.toString(field.getModifiers()).indexOf(NAME_OF_STATIC) < 0
                            &&
                            Modifier.toString(field.getModifiers()).indexOf(NAME_OF_FINAL) < 0
                            &&
                            !Arrays.stream(exceptFields).anyMatch(field.getName()::equals)
            ) {
                field.set(to, field.get(from));
            }
        }
    }
}

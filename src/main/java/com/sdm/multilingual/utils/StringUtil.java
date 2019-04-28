package com.sdm.multilingual.utils;

public class StringUtil {

    public static char DELIMETER_OF_PATH = '.';

    /**
     * Exception Message 생성자
     *
     * */
    public static String getExceptionMessage(Object objClass, String message) {
        return String.format(
                "%s - %s : %s",
                objClass.getClass().getSimpleName(),
                SystemUtil.getMethodName(),
                message);
    }

}

package com.sdm.multilingual.utils;

import java.util.Arrays;
import java.util.List;

public class GroupUtil {

    public static String compressPath(List<String> listOfCode) {
        return listOfCode.stream().reduce((a, b) -> a + StringUtil.DELIMETER_OF_PATH + b).get();
    }

    public static List<String> dividePath(String pathOfCode) {
        return Arrays.asList(pathOfCode.split("\\" + StringUtil.DELIMETER_OF_PATH));
    }
}

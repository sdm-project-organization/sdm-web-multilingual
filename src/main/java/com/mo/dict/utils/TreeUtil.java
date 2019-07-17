package com.mo.dict.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeUtil {

    /**
     * DELIMETER로 TreePath 합치기
     */
    public static String compressPath(List<String> listOfCode) {
        return listOfCode.stream().reduce((a, b) -> a + StringUtil.DELIMETER_OF_PATH + b).get();
    }

    /**
     * DELIMETER로 TreePath 나누기
     */
    public static List<String> dividePath(String pathOfCode) {
        return Arrays.asList(pathOfCode.split("\\" + StringUtil.DELIMETER_OF_PATH));
    }

    /**
     * Tree의 다음 상위 경로 구하기
     */
    public static String getNextGreaterThanTreePath(String treePath) {
        List<String> arrOfCodes = dividePath(treePath);
        if (arrOfCodes.size() < 2)
            return null;

        int lastIdx = treePath.lastIndexOf(StringUtil.DELIMETER_OF_PATH);
        return treePath.substring(0, lastIdx);
    }

    /**
     * Tree의 상위 모든 경로 구하기
     */
    public static List<String> getAllGreaterThanTreePath(String treePath) {
        List<String> treePaths = new ArrayList<>();
        String nextGreaterThanTreePath = getNextGreaterThanTreePath(treePath);
        while (nextGreaterThanTreePath != null) {
            treePaths.add(nextGreaterThanTreePath);
            nextGreaterThanTreePath = getNextGreaterThanTreePath(nextGreaterThanTreePath);
        }
        return treePaths;
    }


}

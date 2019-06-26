package com.test.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author 张敏
 * @Title: Test
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/3/1117:48
 */
public class Test {
    public static void main(String[] args) {
        String pointIds="2#1#5";

      List<String> pointIdsList = new ArrayList<>(new HashSet<>(Arrays.asList(pointIds.split("#"))));
        System.out.println(pointIdsList );
    }
}

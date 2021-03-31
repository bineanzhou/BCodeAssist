package com.bcode.tool;

import com.tonicsystems.jarjar.Main;

public class MyClass {
    public static void main(String[] args) {
        try {
            String rule = "/Users/zhoubin/work/demo/BCodeTool/bcodetool/src/test/rule.txt";
            String jarFile = "/Users/zhoubin/work/demo/BCodeTool/bcodetool/src/test/junit-4.8.1.jar";
            String newJarFile = "/Users/zhoubin/work/demo/BCodeTool/bcodetool/src/test/junit-4.8.1_new.jar";
            Main.main(new String[]{"process",rule, jarFile, newJarFile});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
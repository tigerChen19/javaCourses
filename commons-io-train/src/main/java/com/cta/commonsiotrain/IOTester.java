package com.cta.commonsiotrain;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class IOTester {
    public static void main(String[] args) throws IOException {

//        readInTraditionalWay();
        readInIOUtils();
    }

    public static void readInTraditionalWay() throws IOException {
        String path = "D:\\IOtest.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
    public static void readInIOUtils() throws IOException {
        String path = "D:\\IOtest.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        System.out.println(IOUtils.toString(fileInputStream,"gbk"));
    }
}

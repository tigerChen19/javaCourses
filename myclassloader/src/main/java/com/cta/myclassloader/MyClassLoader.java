package com.cta.myclassloader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class MyClassLoader extends ClassLoader{

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        ClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.loadClass("Hello");
        Method method = clazz.getMethod("hello");
        method.invoke(clazz.newInstance());



    }

    @Override
    protected Class<?> findClass(String name) {
//        String resourcePath = name.replace(".", "\\");
//        String resourcePath = name;
//        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourcePath+".xlass");
        URLClassLoader urlClassLoader;
        File file = new File("D:\\"+name+".xlass");
        System.out.println("URI:"+file.toURI());

        InputStream inputStream = null;
        try {
            byte[] newBytes = null;
            try {
//                System.out.println("URL:"+file.toURI().toURL());
                URL url = file.toURI().toURL();
                URLConnection urlc = url.openConnection();
                inputStream = urlc.getInputStream();
//                inputStream = new FileInputStream("D:\\"+name+".xlass");
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                newBytes = decode(bytes);
            }catch (Exception e){
                e.printStackTrace();
            }
            return defineClass(name, newBytes, 0, newBytes.length);
        }  finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] decode(byte[] bytes) {
        int le = bytes.length;
        byte[] targetBytes = new byte[le];
        for(int i=0;i<le;i++){
            targetBytes[i] = (byte) (255-bytes[i]);
        }
        return targetBytes;
    }
}

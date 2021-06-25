package com.cta.myclassloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader{

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        ClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.loadClass("Hello");
        Method method = clazz.getMethod("hello");
        method.invoke(clazz.newInstance());



    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String resourcePath = name.replace(".", "/");
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourcePath+".xlass");
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            byte[] newBytes = decode(bytes);
            return defineClass(name, newBytes, 0, newBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        } finally {
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

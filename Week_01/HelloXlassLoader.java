package com.ackerm.geektime;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloXlassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloXlassLoader().findClass("Hello");
            Object o = helloClass.newInstance();
            Method hello = helloClass.getMethod("hello");
            hello.invoke(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] xlassData = new byte[1024];
        try {
            xlassData = xlassToByte(name);
            for (int i = 0; i < xlassData.length; i++) {
                xlassData[i] = (byte) ((byte) 255 - xlassData[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, xlassData, 0, xlassData.length);
    }

    private byte[] xlassToByte(String name) throws IOException {
        String path = "E:\\GeekTime\\Hello\\" + name + ".xlass";
        File file = new File(path);
        InputStream in = null;
        ByteArrayOutputStream out = null;
        byte[] bytes = new byte[1024];
        byte[] readBytes = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            int length;
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            readBytes = out.toByteArray();
        } finally {
            if (in != null) {
                in.close();
            }

            if (out != null) {
                out.close();
            }
        }
        return readBytes;
    }
}

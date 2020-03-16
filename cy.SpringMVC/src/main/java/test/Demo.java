package test;

import java.lang.reflect.Field;

public class Demo {

    public static void main(String[] args) {
        String string = "abc";
        Class clazz = string.getClass();
        try {
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            char[] chars = (char[]) field.get(string);
            chars[1] = '1';
            System.out.println(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

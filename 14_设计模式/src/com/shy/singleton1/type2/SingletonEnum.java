package com.shy.singleton1.type2;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/30/9:18
 * @Description:
 */
public enum SingletonEnum {
    INSTANCE;

    //    public void fun(){
//        System.out.println("aaaaaaaa");
//    }
//
//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Constructor<SingletonEnum> con = SingletonEnum.class.getConstructor();
//        con.setAccessible(true);
//        SingletonEnum s1 = con.newInstance();
//        SingletonEnum s2 = con.newInstance();
//        System.out.println(s1.equals(s2));
//    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IOException {
        Class<?> clazz = Class.forName("com.shy.singleton1.type2.SingletonEnum");
        Constructor<?>[] constructor = clazz.getDeclaredConstructors();
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.totalMemory());
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                System.out.println(SingletonEnum.INSTANCE.hashCode());
//            },i+"").start();
//        }


    }
}


class Singleton{
    private static volatile Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if (instance == null){

            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}

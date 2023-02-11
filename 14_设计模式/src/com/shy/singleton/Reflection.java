package com.shy.singleton;

import com.shy.singleton1.type1.Singleton1;
import com.shy.singleton1.type2.SingletonEnum;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/30/9:12
 * @Description:
 */
public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Constructor con = Singleton1.class.getDeclaredConstructor();
//        con.setAccessible(true);
//        Singleton1 singleton1 = (Singleton1) con.newInstance();
//        Singleton1 singleton2 = (Singleton1) con.newInstance();
//        System.out.println(singleton1.equals(singleton2));

//        Constructor<SingletonEnum> con = SingletonEnum.class.getConstructor();
//        con.setAccessible(true);
//        SingletonEnum s1 = (SingletonEnum) con.newInstance();
//        SingletonEnum s2 = (SingletonEnum) con.newInstance();
//        System.out.println(s1.equals(s2));
        SingletonEnum s = SingletonEnum.INSTANCE;
        System.out.println(s);
        Constructor<SingletonEnum> constructor = SingletonEnum.class.getConstructor();
        constructor.setAccessible(true);
        SingletonEnum s1 = (SingletonEnum) constructor.newInstance();
        SingletonEnum s2 = (SingletonEnum) constructor.newInstance();
    }
}

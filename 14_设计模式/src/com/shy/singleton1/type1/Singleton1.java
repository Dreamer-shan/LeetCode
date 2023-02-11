package com.shy.singleton1.type1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/26/18:02
 * @Description:
 */
public class Singleton1 {
    private Singleton1(){}
    private static Singleton1 instance;
    public static synchronized Singleton1 getInstance(){
        if (instance == null){
            return new Singleton1();
        }
        return instance;
    }
}

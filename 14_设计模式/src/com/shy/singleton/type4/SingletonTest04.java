package com.shy.singleton.type4;



/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/18:51
 * @Description:  // 懒汉式
 */

public class SingletonTest04 {
    public static void main(String[] args) {
        System.out.println("懒汉式2 ， 线程安全~");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }
}

// 懒汉式(线程安全，同步方法)
class Singleton {
    private static Singleton instance;
    private Singleton(){}
    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    //即懒汉式
    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

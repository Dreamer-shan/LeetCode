package com.shy.singleton.type7;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/19:44
 * @Description:
 */
/*优缺点说明：
        1) 这种方式采用了类装载的机制来保证初始化实例时只有一个线程。
        2) 静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化
        时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的
        实例化。
        3) 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们
        保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
        4) 优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
        5) 结论：推荐使用.*/

public class SingletonTest07 {
    public static void main(String[] args) {
        System.out.println("使用静态内部类完成单例模式");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}

// 静态内部类完成， 推荐使用
class Singleton{
    private static volatile Singleton instance;
    private Singleton(){}

    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static synchronized Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}

package com.shy.singleton.type8;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/21:14
 * @Description:
 */

    /*    1) 构造器私有化 (防止 new )
        2) 类的内部创建对象
        3) 向外暴露一个静态的公共方法。getInstance*/
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + Singleton5.getInstance().hashCode());
                }
            }).start();
        }
    }
}


// 饿汉式  静态常量
//优点：写法简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
//缺点：在类装载的时候就完成实例化，没有达到 Lazy Loading 的效果。如果从始至终从未使用过这个实例，则会造成内存浪费
class Singleton1{
    private Singleton1(){}
    private static final Singleton1 instance = new Singleton1();
    public static Singleton1 getInstance(){
        return instance;
    }
}

// 饿汉式  静态代码块
//和上面的方式其实类似
class Singleton2{
    private Singleton2(){}
    private static Singleton2 instance;
    static {
        instance = new Singleton2();
    }
    public static Singleton2 getInstance(){
        return instance;
    }
}


// 懒汉式(线程不安全)
//起到了 Lazy Loading 的效果，但是只能在单线程下使用。
//如果在多线程下，一个线程进入了 if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式
class Singleton3{
    private Singleton3(){}
    private static Singleton3 instance;
    public static Singleton3 getInstance(){
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}


// 懒汉式 同步代码块
//解决线程安全问题
//效率低，每个线程在想获得类的实例时候，执行 getInstance()方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接 return 就行了。方法进行同步效率太低
class Singleton4{
    private Singleton4(){}
    private static Singleton4 instance;
    public static synchronized Singleton4 getInstance(){
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}

// 懒汉式  双重校验
class Singleton5{
    private Singleton5(){}
    private static volatile Singleton5 instance;
    public static Singleton5 getInstance(){
        if (instance == null){
            synchronized (Singleton5.class){
                if (instance == null){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
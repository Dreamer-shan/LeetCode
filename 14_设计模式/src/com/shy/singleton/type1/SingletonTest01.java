package com.shy.singleton.type1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/16:55
 * @Description: 饿汉式  静态常量
 */
/*
* 步骤如下：
1) 构造器私有化 (防止 new )
2) 类的内部创建对象
3) 向外暴露一个静态的公共方法。getInstance
*/
    /*
        优缺点说明：
            1) 优点：就是在类装载的时候就完成实例化。避免了线程同步问题。
            饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的
            2) 缺点：在类装载的时候就完成实例化，没有达到懒加载的效果。如果从始
            至终从未使用过这个实例，则会造成内存的浪费
            3) 这种方式基于ClassLoader机制避免了多线程的同步问题，不过，instance在类装载
            时就实例化，在单例模式中大多数都是调用getInstance方法， 但是导致类装载
            的原因有很多种，因此不能确定有其他的方式（或者其他的静态方法）导致类
            装载，这时候初始化instance就没有达到lazy loading的效果
            4) 结论：这种单例模式可用，可能造成内存浪费
     */

public class SingletonTest01{
    public static void main(String[] args) {
        System.out.println("饿汉式(静态变量)");
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }
}

//饿汉式  静态常量
class Singleton {
    //1.构造器私有化，外部不能new
    private Singleton(){}

    // 2.本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    // 提供一个公有 的静态方法，返回对象实例
    public static Singleton getInstance(){
        return instance;
    }
}

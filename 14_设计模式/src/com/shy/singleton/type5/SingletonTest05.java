package com.shy.singleton.type5;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/19:21
 * @Description:  双重校验
 */

/*
优缺点说明：
        1) 这种方式，本意是想对第四种实现方式的改进，因为前面同步方法效率太低，
        改为同步产生实例化的的代码块
        2) 但是这种同步并不能起到线程同步的作用。跟第3种实现方式遇到的情形一
        致，假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
        另一个线程也通过了这个判断语句，这时便会产生多个实例
        3) 结论：在实际开发中，不能使用这种方式
*/

public class SingletonTest05 {
    public static void main(String[] args) {
        System.out.println("懒汉式3 ，不推荐使用");
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
    //即懒汉式   把synchronized放到if中
    public static synchronized Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }
}
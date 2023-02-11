package com.shy.singleton.type6;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/19:30
 * @Description: 双重校验锁
 */
/*优缺点说明：
        1) Double-Check概念是多线程开发中常使用到的，如代码中所示，我们进行了两
        次if (singleton == null)检查，这样就可以保证线程安全了。
        2) 这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，
        直接return实例化对象，也避免的反复进行方法同步.
        3) 线程安全；延迟加载；效率较高
        4) 结论：在实际开发中，推荐使用这种单例设计模式*/

public class SingletonTest06 {
    public static void main(String[] args) {
        System.out.println("双重校验锁");
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

// 懒汉式(线程安全，同步方法)
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

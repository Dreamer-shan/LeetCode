package com.shy.singleton.type2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/18:42
 * @Description:  饿汉式（静态代码块）
 */

  /*  优缺点说明：
            1) 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块
            中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优
            缺点和上面是一样的。
            2) 结论：这种单例模式可用，但是可能造成内存浪费*/

public class SingletonTest02 {
    public static void main(String[] args) {
        System.out.println("饿汉式  静态代码块");
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }
}

//饿汉式  静态代码块
class Singleton {
    //1.构造器私有化，外部不能new
    private Singleton(){}

    // 2.本类内部创建对象实例
    private static Singleton instance;
    static {
        instance = new Singleton();
    }

    // 提供一个公有的静态方法，返回对象实例
    public static Singleton getInstance(){
        return instance;
    }
}

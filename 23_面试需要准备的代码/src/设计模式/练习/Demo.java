package 设计模式.练习;

import java.lang.reflect.Constructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/28/10:55
 * @Description:.
 * 系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能。
 *
 * 缺点
 * 当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new，可能会给其他开发人员造成困扰，特别是看不到源码的时候。
 * 实例化后不使用，可能会被当成垃圾回收
 *
 * 适用场合
 * 需要频繁的进行创建和销毁的对象；
 * 创建对象时耗时过多或耗费资源过多，但又经常用到的对象；
 * 工具类对象；
 * 频繁访问数据库或文件的对象。
 */
// 饿汉式（静态常量）[可用]
    /*  优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。

        缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费
*/
class Singleton1{
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return instance;
    }
}

/*饿汉式（静态代码块
*
*这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
* */
class Singleton2{
    private static Singleton2 instance;
    static {
        instance = new Singleton2();
    }
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return instance;
    }
}

/*懒汉式(线程不安全)[不可用]
起到了Lazy Loading的效果，但是只能在单线程下使用。如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式
* */
class Singleton3{
    private static Singleton3 instance;
    private Singleton3(){}
    public static Singleton3 getInstance(){
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
// 懒汉式(线程安全，同步方法)[不推荐用]
class Singleton4{
    private static Singleton4 instance;
    private Singleton4(){}
    public static synchronized Singleton4 getInstance(){
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
//懒汉式(线程安全，同步代码块)[不可用]
class Singleton5{
    private static Singleton5 instance;
    private Singleton5(){}
    public static Singleton5 getInstance(){
        if (instance == null) {
            synchronized (Singleton5.class){
                instance = new Singleton5();
            }
        }
        return instance;
    }
}

//双重检查[推荐用]
class Singleton6{
    private static volatile Singleton6 instance;
    private Singleton6(){}
    public static Singleton6 getInstance(){
        if (instance == null){
            synchronized (Singleton6.class){
                if (instance == null){
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}

enum Singleton7 {
    instance;
    public static Singleton7 getInstance(){
        return instance;
    }
}
public class Demo {
    public static void main(String[] args) {
        Class<? extends Singleton7> clazz = Singleton7.class;
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println(constructors);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+":"+Singleton7.getInstance().hashCode());
            }).start();
        }
    }
}

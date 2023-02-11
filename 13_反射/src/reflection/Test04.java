package reflection;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/9:41
 * @Description:
 */
public class  Test04 {
    static {
        System.out.println("main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.主动引用   引用子类的时候，如果父类没有被加载  先会加载父类
//        Son son = new Son();

        // 2.反射也会产生主动引用
//        Class.forName("reflection.Son");

        // 不会产生类的引用的方法  通过子类引用父类的静态变量，不会导致子类初始化
//        System.out.println(Son.b);

        //通过数组定义类引用
//        Son[] arr = new Son[5];

        System.out.println(Son.M);
    }
}

class Father{
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
    }
    static  int m = 100;
    static final int M = 1;
}
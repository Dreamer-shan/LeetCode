package reflection;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/9:32
 * @Description:
 */

public class Test03 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }

}

class A{
    static {
        System.out.println("静态代码块执行");
        m = 300;
    }
    static int m = 100;
    public A(){
        System.out.println("执行无参构造方法");
    }
}

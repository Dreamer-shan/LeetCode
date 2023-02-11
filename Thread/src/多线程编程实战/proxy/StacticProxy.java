package 多线程编程实战.proxy;

/**
 * @author Shan
 * @Description 线程底部原理：静态代理模式
 * @create 2021-02-07 16:19
 */
// 真实对象和代理对象实现同一个接口，代理对象要代理真实角色
// 好处：代理对象可以做很多真实对象做不了的事情，真实对象专注做自己的事情
public class StacticProxy {
    public static void main(String[] args) {
        You you = new You();

//        Thread相当于WeddingCompany,start相当于HappyMarry
//        WeddingCompany的真实对象是you，Thread的真实对象是runnable接口
//        new Thread(()-> System.out.println("我爱你")).start();
//        new WeddingCompany(new You()).HappyMarry();

        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.HappyMarry();
    }
}

interface  Marry{
    void HappyMarry();
}

// 真实角色，你去结婚
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("A结婚了，开心");
    }
}

// 代理角色 帮助你结婚
class WeddingCompany implements Marry{
    // 代理谁 -> 真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();   //这就是真实对象
        after();
    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }

    private void before() {
        System.out.println("结婚之前布置现场");
    }
}

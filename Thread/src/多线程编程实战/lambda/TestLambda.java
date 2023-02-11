package 多线程编程实战.lambda;

/**
 * @author Shan
 * @Description
 * @create 2021-02-07 16:47
 */
public class TestLambda {
    //    3.静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        ILike like2 = new Like2();
        like2.lambda();

        // 4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        ILike like3 = new Like3();
        like3.lambda();

        // 5.匿名内部类 没有类名称，必须借助接口或者父类
        new ILike(){
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        }.lambda();
//        lambda简化
        like = ()->{
            System.out.println("i like lambda5");
        };
        like.lambda();
    }
}

// 1.定义一个函数式接口
interface ILike {
    void lambda();
}

// 2.实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
package 小测试.多态;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/20/16:07
 * @Description:
 */

public class duotai {
    public static void main(String[] args) {
        Animal animal = new Cat();
        System.out.println(animal instanceof Cat);
        System.out.println(animal instanceof Animal);
        animal.eat();
        animal.sleep();
        animal.run();
//        animal.catchMouse();
        System.out.println(animal.num);
        System.out.println(animal.age);

    }
}
class Animal{
    int num = 10;
    static int age = 10;
    public void eat(){
        System.out.println("动物吃饭");
    }
    public void sleep(){
        System.out.println("动物睡觉");
    }
    public void run(){
        System.out.println("动物奔跑");
    }
}

class Cat extends Animal{
    int num = 80;
    static int age = 80;
    public void eat(){
        System.out.println("猫吃饭");
    }
    @Override
    public void sleep(){
        System.out.println("猫睡觉");
    }

    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}
class Dog extends Animal{
    int num = 80;
}
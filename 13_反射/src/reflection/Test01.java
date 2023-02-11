package reflection;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/24/22:57
 * @Description:
 */
// 三种创建方式
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+person.name);

        // 方式1 .getClass()
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        // 方式2  全限定名
        Class c2 = Class.forName("reflection.Student");
        System.out.println(c2.hashCode());

        // 类名.class
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        // 基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);
        
        // 获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person{
    public String name;

    public int age;

    private int id;
    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(){}
    private void test(){};

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

class Student extends Person{
    public Student(){
        super("aa");
        this.name = "aaa";
    }
}
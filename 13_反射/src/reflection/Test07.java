package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/10:29
 * @Description:通过反射动态创建对象
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("reflection.Person");

        // 通过newInstance构造一个对象
        Person person1 = (Person) c1.newInstance();  // 本质上是调用无参构造器
        System.out.println(person1);

        // 通过构造器构造对象
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        Person person2 = (Person) constructor.newInstance("shan", 18,18 );
        System.out.println(person2);

        // 通过反射调用普通方法
        Person person3 = (Person) c1.newInstance();
        Method setName = c1.getMethod("setName", String.class);
        setName.invoke(person3, "shan");
        System.out.println(person3.getName());

        // 通过反射操作属性
        Person person4 = (Person) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.set(person4, "shannnnnn");

        System.out.println(person4.getName());

    }
}

package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/25/10:07
 * @Description:获得类的信息
 */
public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflection.Person");

        // 获得类名
        System.out.println(c1.getName());   // 包名+类名
        System.out.println(c1.getSimpleName()); // 类名

        System.out.println("获得public属性=======================================");
        Field[] fields = c1.getFields();    // 获得public属性
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("获得全部属性=======================================");
        fields = c1.getDeclaredFields();    // 获得全部属性
        for (Field field : fields) {
            System.out.println(field);
        }


        System.out.println("获得指定属性=======================================");
        Field name = c1.getField("name");   // 获得指定属性
        System.out.println(name);


        // 获得类的方法
        System.out.println("获得本类及其父类的全部public方法=======================================");
        Method[] methods = c1.getMethods();     // 获得本类及其父类的全部public方法
        for (Method method : methods) {
            System.out.println("正常的：" + method);
        }

        System.out.println("获得本类的全部方法(包括私有)=======================================");
        methods  = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("getDeclaredMethods：" + method); // 获得本类的全部方法(包括私有)
        }

        // 获得指定方法
        System.out.println("获得指定方法=======================================");
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        // 获得全部构造器
        System.out.println("获得全部构造器=======================================");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        // 获得指定构造器
        System.out.println("获得指定构造器=======================================");
        Constructor declaredConstructor = c1.getDeclaredConstructor();
        System.out.println(declaredConstructor);
        declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);
    }
}

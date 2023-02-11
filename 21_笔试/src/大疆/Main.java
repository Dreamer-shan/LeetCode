package 大疆;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/14/14:38
 * @Description:
 */

public class Main {
    public static void main(String[] args){
//        method();

        String s1 = "hello";
        String s2 = new String("hello").intern();
        System.out.println(s1 == s2);
    }
    public static void method(){
        try {
            System.out.println("aaa");
            System.exit(0);
            return;
        }catch (Exception e){
            System.out.println("异常发生");
        }finally {
            System.out.println("finally");

        }
        System.out.println("处理后续");
    }
}

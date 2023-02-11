package 顺网;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/09/13:13
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        String s1 = new String("good");
        String s2 = new String("bad");
        change(s1,s2);
        System.out.println(s1);
        System.out.println(s2);

        String[] sss = new String[10];
        System.out.println(sss[9]);
    }
    static void change(String s1, String s2){
        s2 = s1;
        s1 = new String("A");
        s2.concat("B");
    }
}

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/05/20:16
 * @Description:
 */
public class Test {
    public static int gene(int a) {
        int count = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                count++;
            }
        }
        return count;
    }
    //函数 gene结束

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int m;
//        System.out.println("请输入一个整数..");
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 3;
//        while (n-- > 0){
//            m = sc.nextInt();
//            gene(m);  //调用函数
//        }
//        int[] arrA = {1, 3, 5};
//        int[] arrB = {4, 2, 6};
        int[] arrA = {5, 8, 9};
        int[] arrB = {4, 12, 6};
        int[] fightA = new int[arrA.length];
        int[] fightB = new int[arrB.length];
        for (int i = 0; i < arrA.length; i++) {
            fightA[i] = gene(arrA[i]);
            fightB[i] = gene(arrB[i]);
        }

        Arrays.sort(fightA);
        System.out.println(Arrays.toString(fightA));
        System.out.println(Arrays.toString(fightB));
        int index=0;
        int count = 0;
        while (index < n){
            if (fightA[index] > fightB[index]){
                count++;
            }
            index++;
        }
        System.out.println(count);
    }
}

package 奇安信;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/23/15:40
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        int[] fraction = getFraction((float) 0.1415926535898);
        System.out.println(Arrays.toString(fraction));
    }

//    public int[] getFraction (float a) {
//        // write code here
//        float min = a, m, n, temp, sum;
//        for (int i = 1; i < 200; i++) {
//            m = i;
//            for (int j = 1; j < i; j++) {
//                n = j;
//                temp = n / m;
//                sum = n + m;
//                System.out.println(temp);
//            }
//
//
//        }
//        return new int[]{};
//    }

    public static int[] getFraction (float a) {
        // write code here
        //float x = a;
        int[] ans = new int[2];
        ans[0]=1;ans[1]=1;
        if (a <= 0.005){
            ans[1] = 200;
        }
        for (int i = 1; i <= 200; i++) {
            float z = (float) ((i * 1.0) / a + 0.5);
            int temp = (int) z;
            if (Math.abs((i * 1.0) / (temp * 1.0) - a) < Math.abs((ans[0] * 1.0) / (ans[1] * 1.0) - a) && temp <= 200){
                ans[0] = i;
                ans[1] = temp;
            }
        }
        return ans;

    }

    public static int[] getFraction2 (float a) {
        // write code here
        float number = (float) 1.0;
        int[] num = new int[2];
        for (int i = 1; i <= 200; i++) {
            for (int j = i; j<= 200; j++) {
                float item = (float) (i * 1.0 / j);
                if (item > a){
                    if (item - a < number){
                        num[0] = i;
                        num[1] = j;
                        number = item - a;
                    }else if (item - a == number){
                        if (num[0] + num[1] > i + j){
                            num[0] = i;
                            num[1] = j;
                        }
                    }
                }else {
                    if (a - item < number){
                        num[0] = i;
                        num[1] = j;
                        number = a- item;
                    }else if (item - a == number){
                        if (num[0] + num[1] > i + j){
                            num[0] = i;
                            num[1] = j;
                        }
                    }
                }
            }
        }
        return num;
    }
}


//    public int[] getFraction (float a) {
//        // write code here
//        float x = a;
//        int[] ans = new int[2];
//        if (x < 0.005){
//            ans[1] = 200;
//        }
//        for (int i = 1; i <= 200; i++) {
//            float z = (float) ((i * 1.0) / x + 0.5);
//            int temp = (int) z;
//            if (Math.abs((i * 1.0) / (a * 1.0) - x) < Math.abs((ans[0] * 1.0) / (ans[1] * 1.0) - x) && temp <= 200){
//                ans[0] = i;
//                ans[1] = temp;
//            }
//        }
//        return ans;
//    }
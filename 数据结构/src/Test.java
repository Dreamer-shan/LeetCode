import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/07/19:47
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int[] xishu = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
//        System.out.println(xishu.length);
        int[] last = {1, 0, 88, 9, 8, 7, 6, 5, 4, 3, 2};
//        int[] haoma = 34088119480815*663;
        int[] haoma = {3, 4, 0, 8, 8, 1, 1, 9, 4, 8, 0, 8, 1, 5, '*', 6, 6, 3};
//        int[] haoma = {5,2,0,1,2,3,2,0,0,5,0,1,1,6,9,'*','*',4};
        System.out.println(Arrays.toString(haoma));
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        char[] charArray = s.toCharArray();
        int sum1 = 0;
        int count = 0;
        for (int i = 0; i < 14; i++) {
            System.out.println((haoma[i]));
            sum1 += haoma[i] * xishu[i];
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 14; i < 17; i++) {
            if (haoma[i] == 42){
                list.add(i);
            }else {
                sum1 += haoma[i] * xishu[i];
            }
//            if (Character.isDigit(haoma[i])) {
//                sum1 += haoma[i] * xishu[i];
//            } else {
//                if (i == 14) {
//                    sum1 += 8 * haoma[i];
//                } else if (i == 15) {
//                    sum1 += 4 * haoma[i];
//                } else {
//                    sum1 += haoma[i];
//                }
//            }
//            if (sum1 % 11 == last[haoma[haoma.length - 1]]) {
//                count++;
//            }
//            for (int k = 0; k < 10; k++) {
//                for (int m = 0; m < 10; m++) {
//                    for (int n = 0; n < 10; n++) {
//                        if ((sum1 + 8 * k + 4 * m + n) % 11 == last[haoma[haoma.length - 1]]){
//                            count++;
//                        }
//                    }
//                }
//            }
        }
        int size = list.size();
        if (size == 1){
            for (int i = 0; i < 10; i++) {
                int temp = sum1;
                temp += xishu[list.get(0)] * i;
                if(last[temp % 11] == haoma[17]){
                    count++;
                }
            }
        }else if (size == 2){
            for (int i = 0; i < 10; i++) {
                int temp = sum1;
                temp += xishu[list.get(0)] * i;
                for (int j = 0; j < 10; j++) {
                    int temp1 = temp;
                    temp1 += xishu[list.get(1)] * j;
                    if(last[temp1 % 11] == haoma[17]){
                        count++;
                    }
                }
            }
        }else {
            for (int i = 0; i < 10; i++) {
                int temp = sum1;
                temp += xishu[list.get(0)] * i;
                for (int j = 0; j < 10; j++) {
                    int temp1 = temp;
                    temp1 += xishu[list.get(1)] * j;
                    for (int k = 0; k < 10; k++) {
                        int temp2 = temp1;
                        temp2 += xishu[list.get(2)] * k;
                        if(last[temp2 % 11] == haoma[17]){
                            count++;
                        }
                    }
                }
            }
        }
//        for (Integer number : set) {
//            if (last[number] == haoma[17]){
//                count++;
//            }
//        }
        System.out.println(count);
//        System.out.println(sum1);
//        System.out.println(xishu.length);
//        System.out.println(haoma.length);
//        System.out.println(count);
    }
}

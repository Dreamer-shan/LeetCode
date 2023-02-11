package QQ音乐;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/16/19:45
 * @Description:
 */
public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @param k int整型
     * @return long长整型
     */
//    public static void main(String[] args) {
//        System.out.println(minM(5, 3));
//        System.out.println(minM(10, 10));
//    }
    public static long minM (int n, int k) {
        // write code here
        int m =  1;
        int count = 1;
        while (count < n){
            count+= convert(++m,k);
        }
        return m;
    }
    public static int convert(long m, int k){
        int res = 0;
        long temp = m / k;
        if (m % k == 1) res++;
        while (temp != 0){
            if (temp % k == 1)  res++;
            temp = temp / k;
        }
        return res;
    }

    public static String maxLexicographical (String num) {
        // write code here
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1'){
                continue;
            }
            else {
                int index = i;
                chars[index++] = '1';
//                while (chars[index] == '0'){
//                    chars[index] = '1';
//                    index++;
//                }
//                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maxLexicographical("1000"));
        System.out.println(maxLexicographical("1001"));
    }
}
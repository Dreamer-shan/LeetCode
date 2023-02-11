
import java.io.IOException;
import java.util.Scanner;

public class Solution8 {
    private static double epsilon = 1e-8;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double ans = mySqrt(x,epsilon);
        System.out.println((int)ans);
        System.out.printf(String.format("%.3f",ans));
    }

    public static double mySqrt(double x , double epsilon){
        double left = 0 , right = x;
        if(x == 0 || x == 1){
            return x;
        }
        while(left < right){
            double mid = left + (right - left) / 2;
            if(Math.abs(mid * mid - x) < epsilon){
                return mid;
            }else if(mid * mid < x){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }

}

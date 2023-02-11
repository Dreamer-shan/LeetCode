package 平方根;

/**
 * @author Shan
 * @Description
 * @create 2021-07-05 23:42
 */
class Solution {
    public static void main(String[] args) {
        int i = mySqrt(10);
        System.out.println(i);

    }
    public static int mySqrt(int x) {
        double temp = x;
        double v = mySqrt(10, 0.9999);
        System.out.println(v);
        int ans = (int)mySqrt(temp,0.01);
        System.out.println(ans);
        return (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
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
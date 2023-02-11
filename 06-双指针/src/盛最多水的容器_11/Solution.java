package 盛最多水的容器_11;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/12/18/11:16
 * @Description:
 */
class Solution {
//    暴力法
    public int maxArea(int[] height) {
        if(height.length <= 1) return 0;
        int res = 0;//保存结果
        for(int i = 0; i < height.length - 1; i++)//以i为左挡板，从O开始
        {
            for(int j = i + 1; j < height.length; j++)//以j为右挡板，从height.size() - 1开始
            {
                int L = j - i;//底边长度
                int H = Math.min(height[i], height[j]);//对短的板子为高
                res = Math.max(res, L * H);//取最大值
            }
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r){
            int area = (r - l) * Math.min(height[l], height[r]);
            ans = Math.max(area, ans);
            if (height[l] <= height[r]){
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }
}
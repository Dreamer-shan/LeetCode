package src.接雨水42;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/03/14:11
 * @Description:
 */
class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        // 第一个柱子和最后一个柱子不会有雨水，所以 i -> [1,n-2]
        for (int i = 1; i < n - 1; i++) {
            int l_max = 0, r_max = 0;
            // 维护左右两边的最大值，注意边界条件
            for (int j = i; j >= 0; j--) {
                l_max = Math.max(l_max, height[j]);
            }
            for (int j = i; j < n; j++) {
                r_max = Math.max(r_max, height[j]);
            }
            //找出两端较小的
            int min = Math.min(l_max, r_max);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                ans += min - height[i];
            }

        }
        return ans;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        int ans = 0;

        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i + 1]);
        }
        // 第一个柱子和最后一个柱子不会有雨水，所以 i -> [1,n-2]
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(l_max[i], r_max[i] );
            if (min > height[i]){
                ans += min - height[i];
            }
        }
        return ans;
    }

    public int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
}
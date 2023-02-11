package 有序数组中位数_3;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/30/10:55
 * @Description:
 */
class Solution {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        int[] b1 = {4, 5, 6};
        double res = findMedianSortedArrays(a1, b1);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1, nums2);
        int n = arr.length;
        int res = 0;
        if (n % 2 != 0) {
            return arr[n / 2];
        } else {
            return (arr[n / 2] + arr[n / 2 - 1]) / 2.0;
        }
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int p1 = 0, p2 = 0, index = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            res[index++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        while (p1 < nums1.length) {
            res[index++] = nums1[p1++];
        }
        while (p2 < nums2.length) {
            res[index++] = nums2[p2++];
        }
        return res;
    }
}



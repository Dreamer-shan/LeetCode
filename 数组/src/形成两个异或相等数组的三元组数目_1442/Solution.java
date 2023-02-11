package 形成两个异或相等数组的三元组数目_1442;

/**
 * @author Shan
 * @Description
 * @create 2020-11-26 10:21
 */
class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = 0;
            for (int j = i; j < arr.length; j++) {
                a ^= arr[j];
                int b = 0;
                for (int k = j + 1; k < arr.length; k++) {
                    b ^= arr[k];
                    if (a==b){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countTriplets2(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                tmp ^= arr[k];
                if (tmp == 0){
                    count += k - i;
                }
            }
        }
        return count;
    }
}
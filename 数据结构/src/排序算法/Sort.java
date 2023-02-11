package 排序算法;

import java.util.*;

/**
 * @author Shan
 * @Description
 * @create 2021-02-23 21:45
 */
public class Sort {
    // 每轮冒泡的过程都可以确定一个元素放在正确的位置上，而这个元素就是剩余元素中最大的元素，正确的位置就是剩余位置中的最右侧的位置
    // 最好情况  完全有序，只需要遍历一次，  最坏情况，完全逆序，需要全部遍历
    public int[] bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j + 1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /*
    首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
    然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     */
    public int[] selectSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {

            // 定义最小下标
            int minIndex = i;
            // 从未排序的序列中找到最小值
            for (int j = i; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;   //将最小数的索引保存
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


    // 从第一个元素开始，该元素可以认为已经被排序
    // 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
    // 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序
    public int[] insertSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int curValue = arr[i + 1];  // 当前值,待插入的数
            int preIndex = i;   // 待插入数的前一个数的下标
            while (preIndex >= 0 && curValue < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];  // 后移一位
                preIndex--; // 从后往前遍历，preIndex是有序序列的最后一个元素的索引
            }
            arr[preIndex + 1] = curValue;   // curValue放到正确位置
        }
        return arr;
    }


    public int[] ShellSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int len = arr.length;
        int curValue, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                curValue = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && curValue < arr[preIndex]) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = curValue;
            }
            gap /= 2;
        }
        return arr;
    }

    public int[] MergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        // 拆分数组
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        // 递归调用  分解并合并
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     * 合并两个有序数组并返回新的数组
     *
     * @param left
     * @param right
     * @return
     */
    int[] merge(int[] left, int[] right) {
        // 新数组
        int[] res = new int[left.length + right.length];
        // i 代表左边数组的指针， j 代表右边数组的指针
        for (int index = 0, i = 0, j = 0; index < res.length; index++) {
            // 合并两个有序数组
            if (i >= left.length) {
                res[index] = right[j++];
            } else if (j >= right.length) {
                res[index] = left[i++];
            } else if (left[i] > right[j]) {
                res[index] = right[j++];
            } else {
                res[index] = left[i++];
            }
        }
        return res;
    }

    public void quickSort1(int[] arr, int low, int high) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            //quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题
            quickSort1(arr, low, index - 1);
            quickSort1(arr, index + 1, high);
        }
    }

    public int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }


    // 快排第二种写法
    public void quickSort2(int[] arr, int start, int end) {
        // 递归终止条件
        if (arr.length <= 1 || start >= end) {
            return;
        }
        // 进行分区，得到分区下标
        int pivotIndex = partition(arr, start, end);
        // 递归  左侧
        quickSort2(arr, start, pivotIndex - 1);
        quickSort2(arr, pivotIndex + 1, end);

    }

    // 返回某一个序列的基准点 pivot
    public int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pivotIndex = start;
        for (int i = start; i < end; i++) {
            //  判断该区间内有元素小于pivot，则将该元素从区间头开始一直向后填充
            if (arr[i] < pivot) {
                if (i > pivotIndex) {
                    swap(arr, i, pivotIndex);
                }
                pivotIndex++;
            }
        }
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @param arr
     * @param bucketSize 桶中能放置多少个不同数值 bucketSize == 3 表示能放{1,2,3}这几种数字，但是容量不限，即可以存在100个1
     * @return
     */
    public List<Integer> bucketSort(List<Integer> arr, int bucketSize) {
        if (arr == null || arr.size() < 2 || bucketSize < 1) {
            return arr;
        }
        // 找出集合中元素的最值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            max = Math.max(max, arr.get(i));
            min = Math.min(min, arr.get(i));
        }
        // 计算桶的个数 [最小值---最大值]
        int bucketCount = (max - min) / bucketSize + 1;
        // 按顺序创建桶，创建一个list, list带下标且是有序的,list中的每一个元素是一个桶,也用list桶
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketList.add(new ArrayList<>());
        }

        //  添加到对应的桶中
        for (int i = 0; i < arr.size(); i++) {
            int bucketIndex = (arr.get(i) - min) / bucketSize;
            bucketList.get(bucketIndex).add(arr.get(i));
        }
        // 桶内元素排序
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < bucketList.size(); i++) {
            List<Integer> everyBucket = bucketList.get(i);
            // 如果桶内有元素
            if (everyBucket.size() > 0) {
                // 只有一个桶
                if (bucketCount == 1) {
                    bucketSize--;
                }
                List<Integer> temp = bucketSort(everyBucket, bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultList.add(temp.get(j));
                }
            }
        }
        return resultList;
    }

    public void countSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        // 数据范围
        int bucketSize = max - min + 1;
        int[] count = new int[bucketSize];
        // 频率数组   统计对应元素的个数
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - min;
            count[index]++;
        }
        // 对频率数组进行累加
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // 创建临时数组，存储最终有序的序列
        int[] temp = new int[arr.length];
        // 逆序扫描待排数组，保证稳定性
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = arr[i] - min;
            temp[count[index] - 1] = arr[i];
            count[index]--;
        }
        // 临时数据依次放入原始数组中
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }

    public void countSort2(int[] arr) {
        if (arr.length == 0) return;
        int max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = arr[i] - min;
            temp[count[index] - 1] = arr[i];
            count[index]--;
        }
    }

    public void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        // 建大顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, len);
        }
        // 排序
        for (int i = len - 1; i > 0; i--) {
            // 堆顶元素与最后一个元素交换
            swap(arr, 0, i);
            // 维护堆顶元素的性质
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * @param arr 存储堆的数组
     * @param i   待维护节点的下标
     * @param len 数组长度
     */
    void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }

    // 插入排序
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1)    return nums;
        int n = nums.length;
        for(int i = 0; i < n - 1 ; i++){
            int insertValue = nums[i + 1];
            int insertIndex = i;
            while(insertIndex >= 0 && insertValue < nums[insertIndex]){
                nums[insertIndex + 1] = nums[insertIndex];
                insertIndex--;
            }
            nums[insertIndex + 1] = insertValue;
        }
        return nums;
    }

}
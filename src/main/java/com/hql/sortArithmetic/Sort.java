package com.hql.sortArithmetic;

import java.util.Stack;

/**
 * @author 开发者中文姓名
 * @date 2019/11/7 10:28
 * java 8 大排序
 */
public class Sort {


    public static void main(String[] args) {
        int[] array = {3,2,6,7,1,9,4,6,2,0,7,4,3};
        throughArray(array);
//        directInsertionSort(array);
//        directInsertionSort2(array);
//        shellSort(array);
//        simplenessSelectionSort(array);
//        pileSort(array);
//        bubblingSort(array);
//        QuickSortRecursion(array,0,array.length-1);
//        QuickSortRecursion2(array,0,array.length-1);
//        QuicksortByStack(array);
//        mergerSort(array);
        baseSort(array);
        throughArray(array);
    }

    /**
     * 直接插入排序1
     * 通过交换进行插入排序，借鉴冒泡排序
     * @param a
     *
     * 1.从第一个元素开始，该元素可以认为已经被排序
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5.将新元素插入到该位置后
     * 6.重复步骤2~5
     */
    public static void directInsertionSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if(a[j]<a[j-1]){
                    a[j] = a[j] ^ a[j-1];
                    a[j-1] = a[j] ^ a[j-1];
                    a[j] = a[j] ^ a[j-1];
                }
            }
        }
    }

    /**
     * 直接插入排序2
     * 通过较大的元素都向右移动而不总是交换两个元素
     * @param a
     */
    public static void directInsertionSort2(int[] a){
        for (int i = 1; i < a.length; i++) {
            int num = a[i];
            int j;
            for(j = i ;j > 0 && num <a[j-1];j--){
                a[j] = a[j-1];
            }
            a[j] = num;
        }
    }


    /**
     * 希尔排序
     * @param a
     * 1.选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
     * 2.按增量序列个数 k，对序列进行 k 趟排序；
     * 3.每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。
     *  仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     */
    public static void shellSort(int[] a){
        int length = a.length;
        int h = 1;
        while (h < length / 3) h = 3 * h + 1;
        for (; h >= 1; h /= 3) {
            for (int i = 0; i < a.length - h; i += h) {
                for (int j = i + h; j > 0; j -= h) {
                    if (a[j] < a[j - h]) {
                        a[j] = a[j] ^ a[j-h];
                        a[j-h] = a[j] ^ a[j-h];
                        a[j] = a[j] ^ a[j-h];
                    }
                }
            }
        }
    }

    /**
     * 简单选择排序
     * @param a
     * 1.从未排序序列中，找到关键字最小的元素
     * 2.如果最小元素不是未排序序列的第一个元素，将其和未排序序列第一个元素互换
     * 3.重复1、2步，直到排序结束。
     */
    public static void simplenessSelectionSort(int[] a){
        for (int i = 0; i < a.length; i++) {
            int min =i;
            //选出之后待排序中值最小的位置
            for (int j = i+1; j <a.length ; j++) {
                if (a[j] < a[min]){
                    min = j;
                }
            }
            //最小值不等于当前值时进行交换
            if(min != i){
                a[i] = a[i] ^ a[min];
                a[min] = a[i] ^ a[min];
                a[i] = a[i] ^ a[min];
            }
        }
    }

    /**
     * 堆排序
     * @param a
     * 1.先将初始序列K[1..n]建成一个大顶堆, 那么此时第一个元素K1最大, 此堆为初始的无序区.
     * 2.再将关键字最大的记录K1 (即堆顶, 第一个元素)和无序区的最后一个记录 Kn 交换,
     * 由此得到新的无序区K[1..n−1]和有序区K[n], 且满足K[1..n−1].keys⩽K[n].key
     * 3.交换K1 和 Kn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]调整为堆. 然后重复步骤2, 直到无序区只有一个元素时停止。
     */
    public static void pileSort(int[] a){
        for (int i = a.length - 1; i > 0; i--) {
            max_heapify(a, i);
            //堆顶元素(第一个元素)与Kn交换
            a[0] = a[0] ^ a[i];
            a[i] = a[0] ^ a[i];
            a[0] = a[0] ^ a[i];
        }
    }

    /***
     *
     *  将数组堆化
     *  i = 第一个非叶子节点。
     *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
     *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
     *
     * @param a
     * @param n
     */
    public static void max_heapify(int[] a, int n) {
        int child;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            //左子节点位置
            child = 2 * i + 1;
            //右子节点存在且大于左子节点，child变成右子节点
            if (child != n && a[child] < a[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (a[i] < a[child]) {
                a[i] = a[i] ^a[child];
                a[child] = a[i] ^a[child];
                a[i] = a[i] ^a[child];
            }
        }
    }

    /**
     * 冒泡排序
     * @param a
     * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3.针对所有的元素重复以上的步骤，除了最后一个。
     * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    public static void bubblingSort(int[] a){
        //外层循环控制比较的次数
        for (int i = 0; i < a.length - 1; i++) {
            //内层循环控制到达位置
            for (int j = 0; j < a.length-i-1 ; j++) {
                //前面的元素比后面大就交换
                if(a[j]>a[j+1]){
                    a[j] = a[j] ^ a[j+1];
                    a[j+1] = a[j] ^ a[j+1];
                    a[j] = a[j] ^ a[j+1];
                }
            }
        }
    }

    /**
     * 快速排序
     * @param a
     * 1.从数列中挑出一个元素，称为"基准"（pivot）。
     * 2.重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。
     * 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * 3.递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * 递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，
     * 它至少会把一个元素摆到它最后的位置去。
     *
     * 递归版
     * @param a
     * @param low
     * @param high
     */
    public static void QuickSortRecursion(int[] a,int low,int high){
        //已经排完
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;

        //保存基准值
        int pivot = a[left];
        while (left < right) {
            //从后向前找到比基准小的元素
            while (left < right && a[right] >= pivot)
                right--;
            a[left] = a[right];
            //从前往后找到比基准大的元素
            while (left < right && a[left] <= pivot)
                left++;
            a[right] = a[left];
        }
        // 放置基准值，准备分治递归快排
        a[left] = pivot;
        QuickSortRecursion(a, low, left - 1);
        QuickSortRecursion(a, left + 1, high);
    }

    /**
     * 快排递归2
     * @param num
     * @param left
     * @param right
     */
    private static void QuickSortRecursion2(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if(left>=right) {
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(num[j]>=key && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(num[i]<=key && i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                num[i] = num[i] ^ num[j];
                num[j] = num[i] ^ num[j];
                num[i] = num[i] ^ num[j];
            }
        }
        num[left]=num[i];
        num[i]=key;
        QuickSortRecursion2(num,left,i-1);
        QuickSortRecursion2(num,i+1,right);
    }


    /**
     * 快排非递归
     * @param a
     */
    public static void QuicksortByStack(int[] a) {
        Stack<Integer> stack = new Stack<Integer>();

        //初始状态的左右指针入栈
        stack.push(0);
        stack.push(a.length - 1);
        while (!stack.isEmpty()) {
            //出栈进行划分
            int high = stack.pop();
            int low = stack.pop();

            int pivotIndex = partition(a, low, high);

            //保存中间变量
            if (pivotIndex > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }
            if (pivotIndex < high && pivotIndex >= 0) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }

    /**
     * partition区间划分
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] a, int low, int high) {
        if (low >= high) return -1;
        int left = low;
        int right = high;
        //保存基准的值
        int pivot = a[left];
        while (left < right) {
            //从后向前找到比基准小的元素，插入到基准位置中
            while (left < right && a[right] >= pivot) {
                right--;
            }
            a[left] = a[right];
            //从前往后找到比基准大的元素
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right] = a[left];
        }
        //放置基准值，准备分治递归快排
        a[left] = pivot;
        return left;
    }

    /**
     * 归并排序
     *  一.迭代法
     *      1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     *      2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
     *      3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     *      4.重复步骤3直到某一指针到达序列尾
     *      5.将另一序列剩下的所有元素直接复制到合并序列尾
     *  二.递归法
     *      1.将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
     *      2.将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
     *      3.重复步骤2，直到所有元素排序完毕。
     */

    /**
     * 以下为递归法
     */
    //归并所需的辅助数组
    private static int[] aux;

    public static void mergerSort(int[] a) {
        //一次性分配空间
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        //将左半边排序
        sort(a, low, mid);
        //将右半边排序
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    /**
     * 该方法先将所有元素复制到aux[]中，然后在归并会a[]中。方法咋归并时(第二个for循环)
     * 进行了4个条件判断：
     * - 左半边用尽(取右半边的元素)
     * - 右半边用尽(取左半边的元素)
     * - 右半边的当前元素小于左半边的当前元素(取右半边的元素)
     * - 右半边的当前元素大于等于左半边的当前元素(取左半边的元素)
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] a, int low, int mid, int high) {
        //将a[low..mid]和a[mid+1..high]归并
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    /**
     * 基数排序
     * @param arr
     *
     * MSD（Most significant digital） 从最左侧高位开始进行排序。先按k1排序分组, 同一组中记录, 关键码k1相等,
     * 再对各组按k2排序分成子组, 之后, 对后面的关键码继续这样的排序分组,直到按最次位关键码kd对各子组排序后.
     * 再将各组连接起来, 便得到一个有序序列。MSD方式适用于位数多的序列。
     *
     * LSD （Least significant digital）从最右侧低位开始进行排序。先从kd开始排序，再对kd-1进行排序，依次重复，
     * 直到对k1排序后便得到一个有序序列。LSD方式适用于位数少的序列。
     *
     * 1.取得数组中的最大数，并取得位数；
     * 2.arr为原始数组，从最低位开始取每个位组成radix数组；
     * 3.对radix进行计数排序（利用计数排序适用于小范围数的特点）
     * 以LSD为例
     */
    public static void baseSort(int[] arr) {
        if (arr.length <= 1) return;

        //取得数组中的最大数，并取得位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }
        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];        //存储各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            base *= 10;
        }
    }

    /**
     * 遍历array
     * @param a
     */
    public static void throughArray(int[] a){
        for (int i : a) {
            System.out.print(i+"  ");
        }
        System.out.println();
    }

}

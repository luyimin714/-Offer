public class Question39 {
    /**
     *                 数组中出现次数超过一半的数字
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
     * 超过数组长度的一半，因此输出2。如果不存在则输出0。
     */

    //解法1:根据数组特点找到的解法
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;

        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = nums[i];
                    count++;
                }
            }
        }

        if (!checkMoreThanHalf(nums, res)) res = 0;

        return res;
    }

    //解法2:基于快速排序partition函数的解法
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;

        int middle = nums.length >> 1;
        int start = 0, end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }

        int res = nums[index];
        if (!checkMoreThanHalf(nums, res)) res = 0;

        return res;
    }

    //判断是否有数字出现的次数超过数组长度的一半
    private boolean checkMoreThanHalf(int[] nums, int num) {
        int times = 0;
        for (int n : nums) {
            if (n == num) times++;
        }

        boolean isMoreThanHalf = true;
        if (times * 2 <= nums.length) {  // 注意是小于等于 不是小于
            isMoreThanHalf = false;
        }

        return isMoreThanHalf;
    }

    //快速排序的partition函数 算法第六版
    private int partition(int[] nums, int lo, int hi){
        if (lo == hi) return lo;

        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) { //指针i和指针j相遇时循环退出
            while (nums[++i] <= v) if (i == hi) break;
            while (v <= nums[--j]) if (j == lo) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    //快速排序的partition函数 剑指Offer
    private int partition2(int[] nums, int lo, int hi) {
        if (nums == null || nums.length <= 0 || lo < 0 || hi >= nums.length)
            return -1;

        int index = lo;
        swap(nums, index, hi);

        int small = lo - 1;
        for (index = lo; index < hi; index++) {
            if (nums[index] < nums[hi]) {
                small++;
                if (small != index)
                    swap(nums, index, small);
            }
        }

        ++small;
        swap(nums, small, hi);

        return small;
    }

    private static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 2, 3, 4, 5};
        System.out.println(new Question39().checkMoreThanHalf(nums1, 2));
    }
}

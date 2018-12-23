public class Question51 {
    /**
     *                    数组中的逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组
     * 成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对
     * 1000000007取模的结果输出。即输出P%1000000007
     */

    //在归并排序的基础上修改
    public int InversePairs(int [] nums) {
        if (nums == null || nums.length <= 0) return 0;

        int[] copy = new int[nums.length];

        return sort(nums, copy, 0, nums.length - 1) % 1000000007;
    }

    private int sort(int[] nums, int[] copy, int lo, int hi) {
        if (hi <= lo) return 0;
        int mid = lo + (hi - lo) / 2;
        int left = sort(nums, copy, lo, mid) % 1000000007;
        int right = sort(nums, copy, mid + 1, hi) % 1000000007;
        return left + right + merge(nums, copy, lo, mid, hi);
    }

    private int merge(int[] nums, int[] copy, int lo, int mid, int hi) {
        if (lo == hi) return 0;

        int i = mid, j = hi;
        for (int k = lo; k <= hi; k++) {
            copy[k] = nums[k];
        }

        int k = hi;
        int count = 0;
        while (i >= lo && j >= mid + 1) {
            if (copy[i] > copy[j]) {
                nums[k--] = copy[i--];
                count += j - mid;
                if (count >= 1000000007)
                    count %= 1000000007;
            } else {
                nums[k--] = copy[j--];
            }
        }

        while (i >= lo)      nums[k--] = copy[i--];
        while (j >= mid + 1) nums[k--] = copy[j--];

        return count;
    }

    //修改后的版本(将sort和merge合并为一个函数)
    public int InversePairs2(int [] nums) {
        if (nums == null || nums.length <= 0)
            return 0;

        int[] copy = new int[nums.length];

        return merge(nums, copy, 0, nums.length - 1);
    }

    private int merge(int[] nums, int[] aux, int lo, int hi) {
        if (lo == hi) return 0;

        int mid = (lo + hi) / 2;

        int left = merge(nums, aux, lo, mid);
        int right = merge(nums, aux, mid + 1, hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }

        int i = mid, j = hi;
        int k = hi;
        int count = 0;

        while (i >= lo && j >= mid + 1) {
            if (aux[i] > aux[j]) {
                nums[k--] = aux[i--];
                count += j - mid;
                count %= 1000000007;
            } else {
                nums[k--] = aux[j--];
            }
        }

        while (i >= lo) nums[k--] = aux[i--];
        while (j >= mid + 1) nums[k--] = aux[j--];

        return (left + right + count) % 1000000007;
    }


    //剑指Offer
    public int inversePairs(int [] data) {
        if (data == null || data.length <= 0)
            return 0;

        int[] copy = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            copy[i] = data[i];
        }

        return helper(data, copy, 0, data.length - 1);
    }

    private int helper(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;

        // 交换copy和data
        int left = helper(copy, data, start, start + length);
        int right = helper(copy, data, start + length + 1, end);

        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = data[j--];
            }
        }

        for (; i >= start; i--)
            copy[indexCopy--] = data[i];
        for (; j >= start + length + 1; j--)
            copy[indexCopy--] = data[j];

        return left + right + count;
    }

    public static void main(String[] args) {
        Question51 test = new Question51();
        int[] nums1 = {7, 5, 6, 4};
        int[] nums2 = {7, 5, 6, 4};
        int[] nums3 = {7, 5, 6, 4};
        System.out.println(test.InversePairs(nums1));
        System.out.println(test.inversePairs(nums2));
        System.out.println(test.InversePairs2(nums3));
    }
}

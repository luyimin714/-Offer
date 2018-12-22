public class Question51 {
    /***************************************************************************
     *                             数组中的逆序对
     *  在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     *  输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
     *  即输出P%1000000007
     ***************************************************************************/

    //在归并排序的基础上修改
    public int InversePairs(int [] nums) {
        if (nums == null || nums.length <= 0)
            return 0;

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

        while (i >= lo) nums[k--] = copy[i--];
        while (j >= mid + 1) nums[k--] = copy[j--];

        return count;
    }

    //修改后的版本
    public int InversePairs2(int [] nums) {
        if (nums == null || nums.length <= 0)
            return 0;

        int[] copy = new int[nums.length];

        return merge(nums, copy, 0, nums.length - 1);
    }

    private int merge(int[] nums, int[] copy, int lo, int hi) {
        if (lo == hi) {
            return 0;
        }

        int mid = (lo + hi) / 2;

        int left = merge(nums, copy, lo, mid) % 1000000007;
        int right = merge(nums, copy, mid + 1, hi) % 1000000007;

        for (int k = lo; k <= hi; k++) {
            copy[k] = nums[k];
        }

        int i = mid;
        int j = hi;
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

        while (i >= lo) nums[k--] = copy[i--];
        while (j >= mid + 1) nums[k--] = copy[j--];

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

        /*
         * 交换copy和data是因为：
         * 1.在每次的操作中，数值的比较都是采用当前传入函数中第一项，也就是data；
         * 比较的结果都存放到copy中；也就意味着此时copy中是经过此次调用的结果。
         * 2.从最底层返回时，进入了(start == end)的情形，data 和 copy 完全没有修改，
         * 此时copy和data还是一样的。
         * 3.进入倒数第二层时，程序进入98行以后部分，copy是部分排序后的新数组，
         * data是旧数组。注意这里都是传值的调用，数组都是直接修改的。倒数第二层使用
         * 的copy其实是倒数第三层中的data,这就确保了倒数第三层进入98行以后时，
         * 数据比较使用的data是最新排序的数组。
         * 4. 倒数第三层将排序的结果存入copy中。程序在倒数第四层进入98行后，
         * 使用的data数组为刚刚倒数第三层中的最新排序的copy.
         * 5. 也就是说，在每次程序进入98行时，此时的data是最新的排序结果，copy是次新的结果。
         * 在最后一次进入98行以后时，copy为完整排序后的结果，data是次新的结果。
         * 然而这里第一个类内函数调用第二个函数时，data和copy的顺序没有改变，
         * 所以最后结果应该copy是完整排序的结果.data是差一步完成排序的结果。
         * 以输入[7,5,6,4], 最后的结果copy[4,5,6,7], data[5,7,4,6].
         */

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

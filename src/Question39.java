public class Question39 {
    private boolean inputInvalid = false;

    public int majorityElement(int[] nums) {
        if (checkInvalidArray(nums))
            return 0;

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

        int result = nums[index];
        if (!checkMoreThanHalf(nums, result))
            result = 0;

        return result;
    }

    private boolean checkInvalidArray(int[] nums) {
        inputInvalid = false;
        if (nums == null || nums.length <= 0)
            inputInvalid = true;

        return inputInvalid;
    }

    private boolean checkMoreThanHalf(int[] nums, int num) {
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num)
                times++;
        }

        boolean isMoreThanHalf = true;
        if (times * 2 <= nums.length) {
            inputInvalid = true;
            isMoreThanHalf = false;
        }

        return isMoreThanHalf;
    }

    private int partition(int[] a, int lo, int hi){
        if (lo == hi)
            return lo;

        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) if (i == hi) break;
            while (v < a[--j]) if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private static void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

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
}

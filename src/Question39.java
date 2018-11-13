public class Question39 {
    public int majorityElement(int[] nums) {
        if (checkInvalidArray(nums))
            return 0;

        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
            } else if  (nums[i] == res)
                count++;
            else
                count--;
        }

        if (!checkMoreThanHalf(nums, res))
            res = 0;

        return res;
    }

    private boolean inputInvalid = false;

    public int majorityElement2(int[] nums) {
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
        for (int n : nums) {
            if (n == num)
                times++;
        }

        boolean isMoreThanHalf = true;
        if (times * 2 <= nums.length) {
            inputInvalid = true;
            isMoreThanHalf = false;
        }

        return isMoreThanHalf;
    }

    private int partition(int[] nums, int lo, int hi){
        if (lo == hi)
            return lo;

        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] < v) if (i == hi) break;
            while (v < nums[--j]) if (j == lo) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
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

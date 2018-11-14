public class Question53 {
    /*
     * 数字在排序数组中出现的次数
     * 统计一个数字在排序数组中出现的次数。
     */
    // 循环写法
    public int getNumberOfK1(int[] nums , int k) {
        if (nums == null || nums.length <= 0)
            return 0;

        int start = 0, end = nums.length - 1;
        int first, last;

        while (start < end) { //getFirstK
            int mid = (start + end) / 2;
            if (nums[mid] < k)
                start = mid + 1;
            else
                end = mid;
        }
        if (nums[start] != k)
            return 0;
        first = start;

        end = nums.length - 1;
        while (start < end) { //getLastK
            int mid = (start + end) / 2 + 1; //此处需要加1
            if (nums[mid] > k)
                end = mid - 1;
            else
                start = mid;
        }
        last = end;

        return last - first + 1;
    }
    // 递归写法
    public int getNumberOfK2(int[] nums , int k) {
        if (nums == null || nums.length <= 0)
            return 0;

        int count = 0;

        int first = getFirstK(nums, k, 0,nums.length - 1);
        int last = getLastK(nums, k, 0, nums.length - 1);

        if (first > -1 && last > -1)
            count = last - first + 1;

        return count;
    }

    /*
     *  在排序数组中查找元素的第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        res[0] = getFirstK(nums, target, 0, nums.length - 1);
        res[1] = getLastK(nums, target, 0, nums.length - 1);

        return res;
    }

    private int getFirstK(int[] nums, int k, int lo, int hi) {
        if (lo > hi)
            return -1;

        int mid = (lo + hi) / 2;
        if (nums[mid] == k) {
            if ((mid > 0 && nums[mid - 1] != k) || mid == 0)
                return mid;
            else
                hi = mid - 1;
        } else if (nums[mid] > k)
            hi = mid - 1;
        else
            lo = mid + 1;

        return getFirstK(nums, k, lo, hi);
    }

    private int getLastK(int[] nums, int k, int lo, int hi) {
        if (lo > hi)
            return -1;

        int mid = (lo + hi) / 2;

        if (nums[mid] == k) {
            if ((mid < nums.length - 1 && nums[mid + 1] != k) || mid == nums.length - 1)
                return mid;
            else
                lo = mid + 1;
        } else if (nums[mid] < k)
            lo = mid + 1;
        else
            hi = mid - 1;

        return getLastK(nums, k, lo, hi);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
        Question53 test = new Question53();
        System.out.println(test.getFirstK(nums, 3, 0, nums.length - 1));
        System.out.println(test.getLastK(nums, 3, 0, nums.length - 1));
        System.out.println(test.getNumberOfK1(nums, 3));
        System.out.println(test.getNumberOfK2(nums, 3));
    }
}

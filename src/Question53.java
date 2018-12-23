public class Question53 {
    /**
     *     数字在排序数组中出现的次数
     * 统计一个数字在排序数组中出现的次数。
     */

    //剑指offer 迭代
    public int getNumberOfK2(int [] nums , int k) {
        if (nums == null || nums.length == 0) return 0;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] == k) {
                if ((mid > 0 && nums[mid - 1] != k) || mid == 0) {
                    lo = mid;
                    break;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid] < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (nums[lo] != k) return 0;
        int first = lo;

        hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] == k) {
                if ((mid < nums.length - 1 && nums[mid + 1] != k) || mid == nums.length - 1) {
                    hi = mid;
                    break;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        int last = hi;

        return last - first + 1;
    }

    //剑指offer  递归
    public int getNumberOfK3(int[] nums , int k) {
        if (nums == null || nums.length <= 0) return 0;

        int count = 0;

        int first = getFirstK(nums, k, 0,nums.length - 1);
        int last = getLastK(nums, k, 0, nums.length - 1);

        if (first > -1 && last > -1)
            count = last - first + 1;

        return count;
    }

    private int getFirstK(int[] nums, int k, int lo, int hi) {
        if (lo > hi) return -1;

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
        if (lo > hi) return -1;

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

    //leetcode
    public int getNumberOfK1(int[] nums , int k) {
        if (nums == null || nums.length <= 0) return 0;

        int lo = 0, hi = nums.length - 1;
        int first, last;

        while (lo < hi) { //getFirstK
            int mid = (lo + hi) / 2;
            if (nums[mid] < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        if (nums[lo] != k) return 0;

        first = lo;

        hi = nums.length - 1;
        while (lo < hi) { //getLastK
            int mid = (lo + hi) / 2 + 1; //加1
            if (nums[mid] > k)
                hi = mid - 1;
            else
                lo = mid;
        }
        last = hi;

        return last - first + 1;
    }

    /**
     *              leetcode 34 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * 如果数组中不存在目标值，返回 [-1, -1]。
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        res[0] = getFirstK(nums, target, 0, nums.length - 1);
        res[1] = getLastK(nums, target, 0, nums.length - 1);

        return res;
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

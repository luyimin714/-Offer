public class Question53_1 {
    /**
     *          0 ~ n-1 中缺失的数字
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
     * 并且每个数字都在范围0到n-1之内。在范围0到n-1的n个数
     * 字中有且只有一个数字不在该数组中，请找出这个数字。
     */
    public static int getMissingNumber(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;

        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] != mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1)
                    return mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo == nums.length) return nums.length;

        return -1;
    }

    /**
     *           数组中值和下标相等的元素
     * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
     * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
     * 例如，在数组{-3, -1, 1, 3, 5}中，数字3和它的下标相等。
     */
    public static int getNumberSameAsIndex(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;

        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] == mid)
                return mid;

            if (nums[mid] < mid)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 3, 5, 6, 7};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums3 = {0, 1, 2, 3, 4, 5, 6};
        System.out.println(getMissingNumber(nums1));
        System.out.println(getMissingNumber(nums2));
        System.out.println(getMissingNumber(nums3));

        int[] nums4 = {-3, -1, 1, 3, 5};
        System.out.println(getNumberSameAsIndex(nums4));
    }
}

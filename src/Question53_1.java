public class Question53_1 {
    /*
     * 0 ~ n-1 中缺失的数字
     */
    public static int getMissingNumber(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] != mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1)
                    return mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left == nums.length)
            return nums.length;

        return -1;
    }

    /*
     * 数组中值和下标相等的元素
     */
    public static int getNumberSameAsIndex(int[] nums) {
        if (nums == null || nums.length <= 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == mid)
                return mid;

            if (nums[mid] < mid)
                left = mid + 1;
            else
                right = mid - 1;
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

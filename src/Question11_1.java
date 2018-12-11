public class Question11_1 {
    /**
     * leetcode 154. 寻找旋转排序数组中的最小值 II
     * 注意数组中可能存在重复的元素。
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     */
    //leetcode
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = (lo + hi) >> 1;

            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else if (nums[mid] < nums[hi])
                hi = mid;
            else // when num[mid] and num[hi] are same
                hi--;
        }
        return nums[lo];
    }

    //剑指offer
    public int findMin2(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int mid = lo;
        while (nums[lo] >= nums[hi]) {
            if(hi - lo == 1){
                mid = hi;
                break;
            }

            mid = (lo + hi) / 2;
            if(nums[lo] == nums[hi] && nums[mid] == nums[lo])
                return minInOrder(nums, lo, hi);

            if(nums[mid] >= nums[lo])
                lo = mid;
            else if(nums[mid] <= nums[hi])
                hi = mid;
        }
        return nums[mid];
    }

    private int minInOrder(int[] nums, int lo, int hi) {
        int res = nums[lo];
        for (int i = lo + 1; i <= hi; i++) {
            if(res > nums[i])
                res = nums[i];
        }
        return res;
    }
}

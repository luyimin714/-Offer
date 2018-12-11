public class Question11 {
    /**
     *   旋转数组的最小数字 (数组中不存在重复的元素)
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */

    //leetcode
    /*
     * 如果第一个元素小于最后一个元素，则数组中没有旋转。所以我们可以直接返回这个子数组中的第一个元素。
     * 如果第一个元素大于最后一个元素，那么我们计算中间的元素，并将其与第一个元素进行比较。
     * 如果中间元素的值大于第一个元素，我们知道旋转位于该数组的后半部分。否则，它在数组的前半部分。
     */
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return nums[lo];

            int mid = (lo + hi) >> 1;

            if (nums[mid] >= nums[lo])
                lo = mid + 1;
            else
                hi = mid;
        }
        return nums[lo];
    }

    //剑指Offer
    public int findMin2(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int mid = lo;
        while (nums[lo] >= nums[hi]) {
            if(hi - lo == 1){
                mid = hi;
                break;
            }

            mid = (lo + hi) / 2;

            if(nums[mid] >= nums[lo])
                lo = mid;
            else if(nums[mid] <= nums[hi])
                hi = mid;
        }
        return nums[mid];
    }
}

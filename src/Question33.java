public class Question33 {
    /**
     *              二叉搜索树的后序遍历序列
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     */
    public static boolean verifySequenceOfBST(int[] nums) {
        if (nums == null || nums.length <= 0) return false;

        return helper(nums, 0, nums.length - 1);
    }

    private static boolean helper(int[] nums, int start, int end) {
        if (start > end) return true;  //边界条件

        int i = start;
        for (; i < end; i++) {
            if (nums[i] > nums[end])
                break;
        }

        int j = i;
        for (; j < end; j++) {
            if (nums[j] < nums[end])
                return false;
        }
        return helper(nums, start, i - 1) && helper(nums, i, end - 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 9, 11, 10, 8};
        int[] nums2 = {7, 4, 6, 5};

        System.out.println(verifySequenceOfBST(nums1));
        System.out.println(verifySequenceOfBST(nums2));
    }
}

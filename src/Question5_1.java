public class Question5_1 {
    /*
     *  leetcode 88.合并两个有序数组
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int index = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }
        while (index2 >= 0) nums1[index--] = nums2[index2--];
    }
}

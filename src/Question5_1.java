public class Question5_1 {
    //合并两个有序数组
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[10];
        for (int i = 0; i < 5; i++) {
            nums1[i] = 1 + i;
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        int[] nums2 = {2, 4, 6, 8 ,10};
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
        merge(nums1, 5, nums2, 5);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}

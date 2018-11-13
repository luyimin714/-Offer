import java.util.Arrays;

public class Merge {
    /*
     * 归并排序1
     */
    public static void sort(int[] nums) {
        int[] aux = new int[nums.length];

        sort(nums, aux, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(nums, aux, lo, mid);
        sort(nums, aux, mid + 1, hi);
        merge(nums, aux, lo, mid, hi);
    }

    private static void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }

        int k = lo;
        while (i <= mid && j <= hi) {
            if (aux[i] <= aux[j]) {
                nums[k++] = aux[i++];
            } else {
                nums[k++] = aux[j++];
            }
        }

        while (i <= mid) nums[k++] = aux[i++];
        while (j <= hi)  nums[k++] = aux[j++];
//        for (int k = lo; k <= hi; k++) {
//            if (i > mid)
//                nums[k] = aux[j++];
//            else if (j > hi)
//                nums[k] = aux[i++];
//            else if (aux[j] < aux[i])
//                nums[k] = aux[j++];
//            else
//                nums[k] = aux[i++];
//        }
    }
    /*
     * 归并排序2
     */
    public static void sort2(int [] nums) {
        if (nums == null || nums.length <= 0)
            return;

        int[] copy = new int[nums.length];
        sort2(nums, copy, 0, nums.length - 1);
    }

    private static void sort2(int[] nums, int[] copy, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort2(nums, copy, lo, mid);
        sort2(nums, copy, mid + 1, hi);
        merge2(nums, copy, lo, mid, hi);
    }

    private static void merge2(int[] nums, int[] copy, int start, int mid, int end) {
        if (start == end) return;

        int i = mid, j = end;
        for (int k = start; k <= end; k++) {
            copy[k] = nums[k];
        }

        int k = end;
        int count = 0;
        while (i >= start && j >= mid + 1) {
            if (copy[i] > copy[j]) {
                nums[k--] = copy[i--];
            } else {
                nums[k--] = copy[j--];
            }
        }

        while (i >= start) nums[k--] = copy[i--];
        while (j >= mid + 1) nums[k--] = copy[j--];
    }
    /*
     * 归并排序3
     */
    public static void sort3(int [] nums) {
        if (nums == null || nums.length <= 0)
            return;

        int[] copy = new int[nums.length];

        merge(nums, copy, 0, nums.length - 1);
    }

    private static void merge(int[] nums, int[] copy, int lo, int hi) {
        if (lo == hi) return;

        int mid = (lo + hi) / 2;

        merge(nums, copy, lo, mid);
        merge(nums, copy, mid + 1, hi);

        for (int ii = 0; ii < nums.length; ii++) {
            copy[ii] = nums[ii];
        }

        int i = mid;
        int j = hi;
        int k = hi;

        while (i >= lo && j >= mid + 1) {
            if (copy[i] > copy[j]) {
                nums[k--] = copy[i--];
            } else {
                nums[k--] = copy[j--];
            }
        }

        while (i >= lo) nums[k--] = copy[i--];
        while (j >= mid + 1) nums[k--] = copy[j--];
    }

    public static void main(String[] args) {
        int[] nums1 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] nums2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] nums3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(nums1);
        sort2(nums2);
        sort3(nums3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }
}

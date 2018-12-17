import java.util.Arrays;
import java.util.Stack;

public class Quick {
    /**
     * 快速排序
     */

    //递归
    public static void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(nums, lo, hi);
        sort(nums, lo, j-1);
        sort(nums, j+1, hi);
    }

    //非递归
    public static void sort2(int[] nums, int lo, int hi) {
        if (hi <= lo) return;

        Stack<Integer> stack = new Stack<>();

        stack.push(lo);
        stack.push(hi);

        while (!stack.empty()) {
            hi = stack.pop(); // 先弹出high,再弹出low
            lo = stack.pop();

            int j = partition(nums, lo, hi);

            if (lo < j - 1) { // 先压low,再压high
                stack.push(lo);
                stack.push(j - 1);
            }
            if (j + 1 < hi) {
                stack.push(j + 1);
                stack.push(hi);
            }
        }
    }

    private static int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;

        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] <= v) if (i == hi) break;
            while (v <= nums[--j]) if (j == lo) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 7, 9, 0, 1, 4, 6, 6, 8};
        System.out.println(Arrays.toString(nums1));
        sort(nums1, 0, nums1.length-1);
        System.out.println(Arrays.toString(nums1));

        System.out.println();

        int[] nums2 = {2, 2, 7, 9, 0, 1, 4, 6, 6, 8};
        System.out.println(Arrays.toString(nums2));
        sort2(nums2, 0, nums2.length-1);
        System.out.println(Arrays.toString(nums2));
    }
}

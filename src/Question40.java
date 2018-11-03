import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Question40 {
    /*****************************************************************
        Java中的TreeSet类实现了红黑树的功能，底层是通过TreeMap实现的，
        TreeSet中的数据会按照插入数据自动升序排列（按自然顺序）
     *****************************************************************/
    public static List<Integer> getLeastNumbers2(int[] nums, int k) {
        if (nums == null || k > nums.length || nums.length <= 0 || k <= 0)
            return new ArrayList<>();

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int num : nums) {
            if (treeSet.size() < k) {
                treeSet.add(num);
            } else {
                if (num < treeSet.first()) {
                    treeSet.pollFirst();
                    treeSet.add(num);
                }
            }
        }
        //list.addAll(treeSet);
        //return list;
        return new ArrayList<>(treeSet);
    }

    public static int[] getLeastNumbers(int[] nums, int k) {
        if (nums == null || k > nums.length || nums.length <= 0 || k <= 0)
            return new int[0];

        int start = 0, end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }

        return res;
    }

    private static int partition(int[] nums, int lo, int hi) {
        if (lo == hi)
            return lo;

        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] < v) if (i >= hi) break;
            while (nums[--j] > v) if (j <= lo) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);

        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] res = getLeastNumbers(nums, 4);
        for (int i : res) {
            System.out.print(i + " ");
        }

        System.out.println();

        List<Integer> list = getLeastNumbers2(nums, 4);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}

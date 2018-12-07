import java.util.*;

public class Question40 {
    /*
     * 最小的K个数
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */
    //解法1:堆排序 基于TreeSet
    public static List<Integer> getLeastNumbers(int[] nums, int k) {
        /*
         * Java中的TreeSet类实现了红黑树的功能，底层是通过TreeMap实现的，
         * TreeSet中的数据会按照插入数据自动升序排列（按自然顺序）
         * Java.util.TreeSet.first()方法用于返回TreeSet的第一个元素。
         * 这里的第一个元素是指集合中最低的元素。如果元素是整数类型，则返回最小的整数。
         * Java.util.TreeSet.last()方法用于返回TreeSet的最后一个元素。
         * 这里的最后一个元素被引用到集合中最高的元素。如果元素是整数类型，则返回最大的整数。
         */
        if (nums == null || nums.length <= 0 || k > nums.length  || k <= 0)
            return new ArrayList<>();

        TreeSet<Integer> treeSet = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int num : nums) {
            if (treeSet.size() < k) {
                treeSet.add(num);
            } else {
                if (num < treeSet.first()) { //num < 最大的元素
                    treeSet.pollFirst();  //如果不Override compare则最大的元素为last()
                    treeSet.add(num);
                }
            }
        }

        return new ArrayList<>(treeSet);
    }

    //解法1:堆排序 基于优先级队列
    public static List<Integer> getLeastNumbers2(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k > nums.length  || k <= 0)
            return new ArrayList<>();

        /*
         * 优先级队列的元素按照其自然顺序进行排序，
         * 或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。
         * jdk官方默认是升序，是基于
         *      < return -1
         *      = return 0
         *      > return 1
         * 如果要降序就必须完全相反
         */
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else {
                if (num < heap.peek()) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }

        return new ArrayList<>(heap);
    }

    //解法2:基于快速排序partition函数
    public static List<Integer> getLeastNumbers3(int[] nums, int k) {
        if (nums == null || k > nums.length || nums.length <= 0 || k <= 0)
            return new ArrayList<>();

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

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(nums[i]);
        }

        return res;
    }
    //快速排序partition函数
    private static int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;

        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] <= v) if (i >= hi) break;
            while (nums[--j] >= v) if (j <= lo) break;
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
        int[] nums1 = {4, 5, 1, 6, 2, 7, 3, 8};
        List<Integer> res1 = getLeastNumbers(nums1, 4);
        System.out.println(res1.toString());

        int[] nums2 = {4, 5, 1, 6, 2, 7, 3, 8};
        List<Integer> res2 = getLeastNumbers2(nums2, 4);
        System.out.println(res2.toString());

        int[] nums3 = {4, 5, 1, 6, 2, 7, 3, 8};
        List<Integer> res3 = getLeastNumbers3(nums3, 4);
        System.out.println(res3.toString());

        System.out.println();
        Integer a = 1;
        Integer b = 2;
        Integer c = 1;
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        System.out.println(a.compareTo(c));
    }
}

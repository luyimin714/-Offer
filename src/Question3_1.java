import java.util.ArrayList;
import java.util.List;

public class Question3_1 {
    /**
     *     不修改数组找出重复的数字
     * 在一个长度为 n+1 的数组中所有的数字都在 1~n 范围内，所以数组中至少有一个数字是重复的。
     * 请至少找出数组中任意一个重复的数字，但不能修改输入的数组。
     */
    public int getDuplication(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 1, end = nums.length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            int count = countRange(nums, start, mid);
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count > (mid - start + 1))
                end = mid;
            else
                start = mid + 1;
        }
        return -1;
    }

    private int countRange(int[] nums, int start, int end) {
        if (nums == null)
            return 0;
        int count = 0;
        for (int num : nums) {
            if (num >= start && num <= end)
                count++;
        }
        return count;
    }

    /**
     * leetcode 442. 数组中重复的数据
     * 给定一个整数数组 a，其中1≤a[i]≤ n（n为数组长度）,其中有些元素出现两次而其他元素出现一次。
     * 找到所有出现两次的元素。
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     *
     * 每遍历到一个数字num，将索引为num-1的数字设为负数
     * 如果索引为num-1的数字已经是负的，那么num就是出现两次的数字
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] < 0) {
                res.add(index);
            }
            nums[index - 1] = - nums[index - 1];
        }
        return res;
    }
}

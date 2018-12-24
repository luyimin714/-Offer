import java.util.ArrayList;

public class Question57 {
    /**
     *                  和为S的两个数字
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和
     * 正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] nums,int target) {
        ArrayList<Integer> list = new ArrayList<>();

        if (nums == null || nums.length <= 0) return list;

        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum == target) {
                list.add(nums[lo]);
                list.add(nums[hi]);
                break;
            } else if (sum < target)
                lo++;
            else
                hi--;
        }
        return list;
    }
}

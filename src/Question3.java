import java.util.Arrays;

public class Question3 {
    /*
     *                          数组中重复的数字
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     */
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int num : nums)
            if (num < 0 || num > length - 1)
                return false;

        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                int m = nums[i];
                if (m == nums[m]) {
                    duplication[0] = m;
                    return true;
                }
                nums[i] = nums[m];
                nums[m] = m;
            }
        }
        return false;
    }
}

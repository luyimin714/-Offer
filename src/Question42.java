public class Question42 {
    /*
     * 连续子数组的最大和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
     * 返回其最大和。
     */

    //Leetcode
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else
                dp[i] = dp[i - 1] + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //剑指offer
    private boolean invalidInput = false;
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            invalidInput = true;
            return 0;
        }

        invalidInput = false;

        int curSum = 0;  //dp[i]
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (curSum <= 0)
                curSum = nums[i];
            else
                curSum += nums[i];

            if (curSum > maxSum)
                maxSum = curSum;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(0x80000000);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(0x7fffffff);
        System.out.println(Integer.MAX_VALUE);
    }
}

public class Question42 {
    /**
     *            连续子数组的最大和
     * 给定一个整数数组 nums ，找到一个具有最大和的连
     * 续子数组（子数组最少包含一个元素），返回其最大和。
     */
    //剑指offer
    //dp[i] = nums[i]               i == 0 或 dp[i-1] <= 0
    //dp[i] = dp[i-1] + nums[i]     i != 0 且 dp[i-1] >  0
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int cur = 0;  //dp[i]
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (cur <= 0)
                cur = nums[i];
            else
                cur += nums[i];

            max = Math.max(cur, max);
        }
        return max;
    }

    //Leetcode
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

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

    public static void main(String[] args) {
        System.out.println(0x80000000);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(0x7fffffff);
        System.out.println(Integer.MAX_VALUE);
    }
}

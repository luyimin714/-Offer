public class Question42 {
    private boolean invalidInput = false;

    public int maxSubArray(int[] nums) {
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

    public int dp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
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

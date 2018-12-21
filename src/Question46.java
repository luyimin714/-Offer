public class Question46 {
    /*
     * LeetCode Decode Ways
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (1 <= first && first <= 9)
                dp[i] += dp[i - 1];
            if (10 <= second && second <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public int numDecodings2(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0')
                dp[i] = 0;
            else {
                int digit1 = s.charAt(i) - '0';
                int digit2 = s.charAt(i + 1) - '0';
                int num = digit1 * 10 + digit2;
                if (num <= 26)
                    dp[i] = dp[i + 1] + dp[i + 2];
                else
                    dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    /****************************************
     *  把数字翻译成字符串
     ****************************************/
    public int numDecodings3(String s) {
        if (s == null || s.length() == 0)
            return 0;

        return getTranslationCount(s);
    }

    private int getTranslationCount(String s) {
        int length = s.length();
        int[] counts = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int count = 0;
            if (i < length - 1)
                count = counts[i + 1];
            else
                count = 1;

            if (i < length - 1) {
                int digit1 = s.charAt(i) - '0';
                int digit2 = s.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < length - 2)
                        count += counts[i + 2];
                    else
                        count += 1;
                }
            }

            counts[i] = count;
        }


        return counts[0];
    }

    public static void main(String[] args) {
        Question46 test = new Question46();
        System.out.println(test.getTranslationCount("10"));
    }
}

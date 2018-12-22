public class Question46 {
    /**
     *          LeetCode Decode Ways
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     *  'A' -> 1
     *  'B' -> 2
     *     ...
     *  'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        // s_index      0   1   2
        // s[]          2   2   6
        // dp[]     1   1   2   3
        // dp_index 0   1   2   3
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

    /**
     *  剑指offer：把数字翻译成字符串
     *  'A' -> 0
     *  'B' -> 1
     *     ...
     *  'Z' -> 25
     */
    public int numDecodings3(String s) {
        if (s == null || s.length() == 0) return 0;

        return getTranslationCount(s);
    }

    //f[i] = f[i+1] + g[i,i+1] x f[i+2]
    //其中当第i位和第i+1位的数字拼接起来在10~25范围内时，g[i,i+1]=1，否则g[i,i+1]=0
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
        System.out.println(Integer.valueOf("123"));
        System.out.println(Integer.parseInt("123"));
        System.out.println("123".substring(1, 2));
    }
}

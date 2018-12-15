public class Question19 {
    /**
     *                正则表达式匹配
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串
     * 的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
     * 但是与"aa.a"和"ab*a"均不匹配
     */
    //leetcode 递归
    public boolean isMatch(String s, String p) {
        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int sId, String p, int pId) {
        if (pId == p.length()) return sId == s.length();
        boolean firstMatch = (sId != s.length() &&
                (s.charAt(sId) == p.charAt(pId) || p.charAt(pId) == '.'));
        if (pId+1 < p.length() && p.charAt(pId+1) == '*') {//第二个字符是*
            return helper(s, sId, p, pId+2) || //* 匹配字符串中的0个字符
                   (firstMatch && helper(s, sId+1, p, pId));//* 匹配字符串中的1至多个字符
        } else {
            return firstMatch && helper(s, sId+1, p, pId+1);
        }
    }

    //动态规划
    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1])
                dp[0][i+1] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j)== '.')
                    dp[i+1][j+1] = dp[i][j];

                if (p.charAt(j) == s.charAt(i))
                    dp[i+1][j+1] = dp[i][j];

                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.')
                        dp[i+1][j+1] = dp[i+1][j-1];
                    else
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    //剑指offer
    public boolean isMatch3(String s, String p) {
        if (s == null || p == null)
            return false;
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        return helper3(str, 0, pattern, 0);
    }

    private boolean helper3(char[] s, int sId, char[] p, int pId) {
        if (sId == s.length && pId == p.length) return true;
        if (sId != s.length && pId == p.length) return false;

        if (pId + 1 < p.length && p[pId + 1] == '*') {
            if ((sId != s.length && p[pId] == s[sId]) || (p[pId] == '.' && sId != s.length))
                return helper3(s, sId + 1, p, pId + 2) ||
                       helper3(s, sId + 1, p, pId) ||
                       helper3(s, sId, p, pId + 2);
            else
                return helper3(s, sId, p, pId + 2);
        }

        if ((sId != s.length && p[pId] == s[sId]) || (p[pId] == '.' && sId != s.length))
            return helper3(s, sId + 1, p, pId + 1);
        return false;
    }
}

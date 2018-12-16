public class LCSs {
    /**
     * 最长公共子序列 (子序列是有序的，但不一定连续)
     * 给定两个字符串，求解这两个字符串的最长公共子序列（Longest Common Subsequence）。
     * 比如字符串1：BDCABA；字符串2：ABCBDAB
     * 则这两个字符串的最长公共子序列长度为4，最长公共子序列是：BCBA
     */

     //           0,                      i=0 || j=0
     //  c[i,j] = c[i-1,j-1] + 1,         i,j>0 && A[i]=B[j]
     //           max(c[i-1,j],c[i,j-1]), i,j>0 && A[i]!=B[j]
    public int LongestCommonSubsequence(String A, int n, String B, int m) {
        int[][] c = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i-1) == B.charAt(j-1))
                    c[i][j] = c[i-1][j-1] + 1;
                else
                    c[i][j] = Math.max(c[i][j-1], c[i-1][j]);
            }
        }
        return c[n][m];
    }

    /**
     * 最长公共子串 (子串有序且连续)
     *
     */

     //           0,                      i=0 || j=0
     //  c[i,j] = c[i-1,j-1] + 1,         i,j>0 && A[i]=B[j]
     //           0,                      i,j>0 && A[i]!=B[j]
    public int LongestCommonSubstring(String A, int n, String B, int m) {
        int[][] c = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i-1) == B.charAt(j-1))
                    c[i][j] = c[i-1][j-1] + 1;
                else
                    c[i][j] = 0;

                max = Math.max(max, c[i][j]);
            }
        }
        return max;
    }
}

public class Question10_1 {
    /*
     *          跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法
     * （先后次序不同算不同的结果）。
     */
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int f1 = 2; //f(n-1)
        int f2 = 1; //f(n-2)
        int f = 0;  //f(n)
        for (int i = 3; i <= n; i++) {
            f = f1 + f2;

            f2 = f1;
            f1 = f;
        }
        return f;
    }
}

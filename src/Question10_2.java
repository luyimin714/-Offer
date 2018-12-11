public class Question10_2 {
    /**
     *          变态跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *  f(1) = 1
     *  f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
     *  f(3) = f(3-1) + f(3-2) + f(3-3)
     *  ...
     *  f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1)
     *         = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     *  f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)
     *       = 2 * f(n-1)
     *
     */
    public int JumpFloorII(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int f1 = 1;
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = 2 * f1;
            f1 = f;
        }
        return f;
    }
}

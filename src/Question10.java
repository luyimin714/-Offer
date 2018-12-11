import java.math.BigInteger;

public class Question10 {
    /**
     *              斐波那契数列
     * 输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     */
    public int Fibonacci_newcoder(int n) {
        int[] result = {0, 1};
        if (n < 2)
            return result[n];
        int fibNMinus1 = 1;
        int fibNMinus2 = 0;
        int fibN = 0;
        for (int i = 2; i <= n; i++){
            fibN = fibNMinus1 + fibNMinus2;
            fibNMinus2 = fibNMinus1;
            fibNMinus1 = fibN;
        }
        return fibN;
    }

    /**
     * 效率低的解法
     */
    public static long slowFibonacci(int n){
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return slowFibonacci(n-1) + slowFibonacci(n-2);
    }

    /*
     * 大数版本
     */
    public static BigInteger Fibonacci(int n){
        BigInteger[] result = {new BigInteger("0"), new BigInteger("1")};
        if (n < 2)
            return result[n];
        BigInteger res_1 = new BigInteger("1");
        BigInteger res_2 = new BigInteger("0");
        BigInteger res = new BigInteger("0");
        for (int i = 2; i <= n; i++){
            res = res_1.add(res_2);
            res_2 = res_1;
            res_1 = res;
        }
        return res;
    }
}

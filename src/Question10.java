import java.math.BigInteger;

public class Question10 {
    public static long slowFibonacci(int n){
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return slowFibonacci(n-1) + slowFibonacci(n-2);
    }

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

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            System.out.println(i + " " + slowFibonacci(i));
        }
//        for (int i = 0; i < 100; i++){
//            System.out.println(i + " " + Fibonacci(i));
//        }
    }
}

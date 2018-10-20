public class Question16 {
    private boolean g_InvalidInput = false;
    public double myPow(double x, int n) {
        g_InvalidInput = false;

        if (equal(x, 0) && n < 0) {
            g_InvalidInput = true;
            return 0.0;
        }

        int absExponent = Math.abs(n);

        double result = PowerWithUnsignedExponent(x, absExponent);
        if (n < 0)
            result = 1.0 / result;

        return result;
    }

    private double PowerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double res = PowerWithUnsignedExponent(base, exponent / 2);
        res *= res;
        if ((exponent & 1) == 1)
            res *= base;

        return res;
    }

    private boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)) {
            return true;
        } else
            return false;
    }

    private double PowerWithUnsignedExponentNaive(double base, int exponent) {
        double res = 1.0;
        for (int i = 1; i <= exponent; i++) {
            res *= base;
        }
        return res;
    }

    private double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    private double test(double x) {
        return 1 / x;
    }

    public static void main(String[] args) {
        Question16 pow = new Question16();
        System.out.println(pow.myPow(0, -1));
        System.out.println(pow.pow(0, -1));
        System.out.println(0.0 * (1 / 0.0));
        System.out.println(pow.test(0.0));
    }
}

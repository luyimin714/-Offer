public class Question16 {
    /**
     *                  数值的整数次方
     * 给定一个double类型的浮点数base和int类型的整数exponent。
     * 求base的exponent次方。
     */
    //leetcode
    private double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            return 1/x * pow(1/x, -(n+1));
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }

    //剑指offer
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
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double res = PowerWithUnsignedExponent(base, exponent / 2);

        res *= res;

        if ((exponent & 1) == 1) res *= base;

        return res;
    }

    private boolean equal(double num1, double num2) {
        return (num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001);
    }
}

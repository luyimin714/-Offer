public class Question65 {
    /**
     *                     不用加减乘除做加法
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     */
    public int getSum(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (b != 0);
        return a;
    }

    public static void main(String[] args) {
        Question65 test = new Question65();
        System.out.println(test.getSum(3, 5));
    }
}

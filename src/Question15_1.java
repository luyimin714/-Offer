public class Question15_1 {
    /**
     * leetcode 231. 2的幂
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}

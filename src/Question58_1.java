import java.util.LinkedList;
import java.util.Queue;

public class Question58_1 {
    /**
     *                   左旋转字符串
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
     * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请
     * 你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要
     * 求输出循环左移3位后的结果，即“XYZdefabc”。
     */
    public String LeftRotateString(String s, int n) {
        if (s == null || s.length() == 0) return "";

        char[] chars = s.toCharArray();
        int length = chars.length;

        if (n > 0 && n < length) {
            int firstStart = 0;
            int firstEnd = n - 1;
            int secondStart = n;
            int secondEnd = length - 1;

            //翻转字符串前面n个字符
            reverse(chars, firstStart, firstEnd);
            //翻转字符串后面的部分
            reverse(chars, secondStart, secondEnd);
            //翻转整个字符串
            reverse(chars, firstStart, secondEnd);
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int lo, int hi) {
        while (lo < hi) {
            char temp = chars[lo];
            chars[lo++] = chars[hi];
            chars[hi--] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question58_1().LeftRotateString("abcdefg", 2));
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class Question58_1 {
    /*
     *          左旋转字符串
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
     * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请
     * 你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
     * 要求输出循环左移3位后的结果，即“XYZdefabc”。
     */
    public String LeftRotateString(String s,int n) {
        if (s == null || s.length() == 0)
            return "";

        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length > 0 && n > 0 && n < length) {
            int firstStart = 0;
            int firstEnd = n - 1;
            int secondStart = n;
            int secondEnd = length - 1;

            reverse(chars, firstStart, firstEnd);
            reverse(chars, secondStart, secondEnd);

            reverse(chars, firstStart, secondEnd);
        }

        return new String(chars);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question58_1().LeftRotateString("abcdefg", 2));
    }
}

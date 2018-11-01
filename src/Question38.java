import java.util.ArrayList;
import java.util.List;

public class Question38 {
    private int count;

    public void permutation(String str) {
        if (str == null)
            return;
        count = 0;
        permutation(str.toCharArray(), 0);
        System.out.println(count);
    }

    private void permutation(char[] str, int begin) {
        if (begin == str.length) {
            System.out.println(String.valueOf(str));
            count++;
        } else {
            for (int i = begin; i < str.length; i++) {
                swap(str, i, begin);

                permutation(str, begin + 1);

                swap(str, i, begin);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public void combination(char[] chars) {
        if (chars == null || chars.length == 0)
            return;
        count = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= chars.length; i++) {
            combination(chars, 0, i, str);
        }
        System.out.println(count);
    }

    private void combination(char[] chars, int begin, int m, StringBuilder str) {
        if (m == 0) {
            count++;
            System.out.println(str);
            return;
        }
        if (begin == chars.length)
            return;

        str.append(chars[begin]);
        //求n-1个字符中长度为m-1的组合
        combination(chars, begin + 1, m - 1, str);
        str.deleteCharAt(str.length() - 1);
        //求n-1个字符中长度为m的组合
        combination(chars, begin + 1, m, str);
    }

    public static void main(String[] args) {
        Question38 print = new Question38();
        print.permutation("abc");

        System.out.println();

        char[] chars = {'a', 'b', 'c'};
        print.combination(chars);
    }
}

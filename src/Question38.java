import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question38 {
    /*
     * 字符串的排列
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     */
    //leetcode 回溯法
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;
        backtrack(res, new StringBuilder(), str.toCharArray(), new boolean[str.length()]);
        return res;
    }

    private void backtrack(ArrayList<String> res, StringBuilder sb, char[] chars, boolean[] used) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (used[i] || (i > 0 && chars[i] == chars[i-1] && !used[i-1])) continue;
                used[i] = true;
                sb.append(chars[i]);
                backtrack(res, sb, chars, used);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    //剑指Offer
    public ArrayList<String> Permutation2(String str) {
        if (str.length() == 0) return new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        permutation(res, chars, 0);
        Collections.sort(res);
        return res;
    }

    private void permutation(ArrayList<String> res, char[] str, int begin) {
        if (begin == str.length) {
            String val = String.valueOf(str);
            if (!res.contains(val))
                res.add(val);
        } else {
            for (int i = begin; i < str.length; i++) {
                swap(str, i, begin);
                permutation(res, str, begin + 1);
                swap(str, i, begin);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    //求所有字符的组合
    public void combination(char[] chars) {
        if (chars == null || chars.length == 0) return;
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= chars.length; i++) {
            combination(chars, 0, i, str);
        }
    }

    private void combination(char[] chars, int begin, int m, StringBuilder str) {
        if (m == 0) {
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
}

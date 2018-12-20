import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question38 {
    /**
     *                    字符串的排列
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
                /*
                 * assume permutating [1,2,2,3]. Talking about 2 at index 2,
                 * we could have been here as part of path: [1->2->2] in which
                 * case previous 2 at index 1 would be a parent to us so
                 * used[i-1] = true in this case. However we could also have
                 * been here as part of path [1---->2] which is a direct path
                 * from 1. In this case previous 2 at index 1 is not a parent
                 * of this particular permutation therefore used[i-1] = false
                 * so that we skip it to avoid duplicates
                 */
                if (used[i] || (i > 0 && chars[i] == chars[i-1] && !used[i-1])) continue;
                used[i] = true;
                sb.append(chars[i]);
                //System.out.println(sb.toString());
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

    private void permutation(ArrayList<String> res, char[] chars, int begin) {
        if (begin == chars.length) {
            String val = String.valueOf(chars);
            if (!res.contains(val))
                res.add(val);
        } else {
            for (int i = begin; i < chars.length; i++) {
                swap(chars, i, begin);
                permutation(res, chars, begin + 1);
                swap(chars, i, begin);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Question38 test = new Question38();
        ArrayList<String> a = test.Permutation("1223");
        System.out.println(a);
    }
}

public class Question38_1 {
    /**
     *                字符的组合
     * 输入一个字符串,按字典序打印出该字符串中字符的所有组合。
     */
    public static void combination(char[] chars) {
        if (chars == null || chars.length == 0) return;
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= chars.length; i++) {
            combination(chars, 0, i, str);
        }
    }

    private static void combination(char[] chars, int begin, int m, StringBuilder sb) {
        if (m == 0) {
            System.out.println(sb);
            return;
        }
        if (begin == chars.length) return;

        sb.append(chars[begin]);
        //求n-1个字符中长度为m-1的组合
        combination(chars, begin+1, m-1, sb);
        sb.deleteCharAt(sb.length() - 1);
        //求n-1个字符中长度为m的组合
        combination(chars, begin+1, m, sb);
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        combination(chars);
    }
}

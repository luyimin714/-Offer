public class Question58 {
    /**
     *          翻转单词顺序列
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     */
    public String reverseWords(String s) {
        if (s == null) return null;

        char[] chars = s.toCharArray();
        int n = chars.length;

        reverse(chars, 0, n - 1);
        reverseWords(chars, n);

        return cleanSpaces(chars, n);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }

    private void reverseWords(char[] chars, int n) {
        int lo = 0, hi = 0;

        while (lo < n) {
            while (lo < hi || lo < n && chars[lo] == ' ') lo++;
            while (hi < lo || hi < n && chars[hi] != ' ') hi++;
            reverse(chars, lo, hi - 1);
        }
    }

    private String cleanSpaces(char[] chars, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && chars[j] == ' ') j++;
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
            while (j < n && chars[j] == ' ') j++;
            if (j < n) chars[i++] = ' ';
        }

        return new String(chars).substring(0, i);
    }

    public static void main(String[] args) {
        String s = "I am a student.";
        System.out.println(new Question58().reverseWords(s));
    }
}

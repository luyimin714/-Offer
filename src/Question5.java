public class Question5 {
    /**
     *    替换空格
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String ReplaceBlank(StringBuffer str) {
        if (str == null || str.length() <= 0) return "";
        int blankNum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                blankNum++;
        }

        int newLength = str.length() + 2 * blankNum;
        int indexNew = newLength - 1;
        int indexOld = str.length() - 1;

        str.setLength(newLength);

        while (indexOld >= 0 && indexOld < indexNew) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            } else {
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
            indexOld--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Question5 test = new Question5();
        System.out.println(test.ReplaceBlank(new StringBuffer("hello world")));
    }
}

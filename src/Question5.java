public class Question5 {
    /***********************************************************************
     *                       替换空格
     *   请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     *   例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     ***********************************************************************/
    public String ReplaceBlank(StringBuffer str) {
        if (str == null)
            return null;
        int blankNum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                blankNum++;
        }

        int indexOld = str.length() - 1;
        int newLength = str.length() + 2 * blankNum;
        int indexnew = newLength - 1;

        str.setLength(newLength);

        for (; indexOld >= 0 && indexOld < newLength; indexOld--) {
            if (str.charAt(indexOld) == ' ') {  //
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            } else {
                str.setCharAt(indexnew--, str.charAt(indexOld));
            }
        }
        return str.toString();
    }

    public String ReplaceBlank2(StringBuffer str) {
        if (str == null)
            return null;
        int blankNum = 0;
        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ')
                blankNum++;
        }
        int newLength = length + 2 * blankNum;
        char[] newChars = new char[newLength];
        int index = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) == ' '){
                newChars[index--] = '0';
                newChars[index--] = '2';
                newChars[index--] = '%';
            }
            else {
                newChars[index--] = str.charAt(i);
            }
        }
        return new String(newChars);
    }

    private static void ModifyString(String text) {
        text += "World";
    }
    public static void main(String[] args) {
        String text = "Hello";
        ModifyString(text);
        System.out.println(text);

        Question5 test = new Question5();
        System.out.println(test.ReplaceBlank(new StringBuffer("hello world")));
//        String[] str1 = new String[]{"hello world"};
//        String[] str2 = new String[]{"hello world"};
//        if (str1 == str2)
//            System.out.println("str1 and str2 are same.\n");
//        else
//            System.out.println("str1 and str2 are not same.\n");
    }
}

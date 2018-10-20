import java.lang.reflect.Type;

public class Question5 {
    public String ReplaceBlank(StringBuffer str){
        if (str == null)
            return null;
        int blankNum = 0;
        int length = str.length();
        int newLength = 0;
        for (int i = 0; i < length; i++){
            if (str.charAt(i) == ' ')
                blankNum++;
        }
        newLength = length + 2 * blankNum;
        char[] newChars = new char[newLength];
        int index = newLength-1;
        for (int i = newLength-1; i >= 0; i--){
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

    private static void ModifyString(String text){
        text = "World";
    }
    public static void main(String[] args) {
        String text = "Hello";
        ModifyString(text);
        System.out.println(text);
//        String[] str1 = new String[]{"hello world"};
//        String[] str2 = new String[]{"hello world"};
//        if (str1 == str2)
//            System.out.println("str1 and str2 are same.\n");
//        else
//            System.out.println("str1 and str2 are not same.\n");
    }
}

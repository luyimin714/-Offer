public class Question20 {
    /**************************************************************
     *                  表示数值的字符串
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     **************************************************************/
    private int i;
    public boolean isNumeric(String str) {
        if (str == null)
            return false;
        i = 0;
        boolean numeric = scanInteger(str);
        if (i < str.length() && str.charAt(i) == '.') {
            i++;
            numeric = scanUnsignedInteger(str) || numeric;
        }

        if (i < str.length() && (str.charAt(i) == 'e' || str.charAt(i) == 'E')) {
            i++;
            numeric = scanInteger(str) && numeric;
        }

        return i >= str.length() && numeric;
    }

    private boolean scanUnsignedInteger(String str) {
        int before = i;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            i++;
        }
        return i > before;
    }

    private boolean scanInteger(String str) {
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            i++;
        }
        return scanUnsignedInteger(str);
    }

    public static void main(String[] args) {
        Question20 question20 = new Question20();
        String s = "123.45e+6";
        System.out.println(question20.isNumeric(s));
    }
}

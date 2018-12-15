public class Question20 {
    /**
     *                  表示数值的字符串
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */

    //数字的格式可以用A[.[B]][e|EC]或.B[e|EC]表示，其中A和C都是整数
    //（可以有正负号，也可以没有），而B是一个无符号整数
    private int i;
    public boolean isNumeric(String str) {
        if (str == null) return false;

        i = 0;
        boolean numeric = scanInteger(str);

        //如果出现'.'，则接下来是数字的小数部分
        if (i < str.length() && str.charAt(i) == '.') {
            i++;
            //下面一行代码用或的原因：
            //1.小数可以没有整数部分，如.123等于0.123
            //2.小数点后面可以没有数字，如233.等于233.0
            //3.小数点前面和后面都可以有数字，如233.666
            numeric = scanUnsignedInteger(str) || numeric;

            //scanUnsignedInteger要放在numeric的前面 短路求值
            //如果'.'后面的字符不是数字，再看'.'前面的字符是不是数字，对应233.e12
            //如果'.'后面的字符是数字，则不需要看'.'前面是否是数字，对应.123（以小数点开头的字符）
        }

        //如果出现'e'或'E'，则接下来是数字的指数部分
        if (i < str.length() && (str.charAt(i) == 'e' || str.charAt(i) == 'E')) {
            i++;

            //下面一行代码用&&的原因
            //1.当e或E前面没有数字时，整个字符串不能表示数字，如.e1、e1
            //2.当e或E后面没有整数时，整个字符串不能代表数字，如12e、12e+5.4
            numeric = scanInteger(str) && numeric;
        }

        return i >= str.length() && numeric;
    }

    //扫描字符串中0~9的数位
    private boolean scanUnsignedInteger(String str) {
        int before = i;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9')
            i++;

        return i > before;
    }

    //扫描以表示正负的'+'或者'-'为起始的数位
    private boolean scanInteger(String str) {
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            i++;

        return scanUnsignedInteger(str);
    }

    public static void main(String[] args) {
        Question20 question20 = new Question20();
        String s = "a.45e6";
        System.out.println(question20.isNumeric(s));
    }
}

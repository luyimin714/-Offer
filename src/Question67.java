public class Question67 {
    /**
     *                把字符串转换成整数
     * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
     * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的
     * 库函数。 数值为0或者字符串不是一个合法的数值则返回0。
     */

    //LeetCode
    public int myAtoi(String str) {
        long num = 0;
        int index = 0, sign = 1;
        if (str.length() == 0) return 0;

        while (index < str.length() && str.charAt(index) == ' ')
            index++;

        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;
            num = num * 10 + digit;

            if (sign == -1 && -num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            if (sign == 1 && num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            index++;
        }
        return sign * (int) num;
    }

    //剑指Offer
    public int StrToInt(String str) {
        long num = 0;
        char[] s = str.toCharArray();

        if (s.length != 0) {
            boolean minus = false;
            int index = 0;
            if (s[index] == '+')
                index++;
            else if (s[index] == '-') {
                index++;
                minus = true;
            }

            if (index != s.length) {
                num = StrToIntCore(s, index, minus);
            }
        }

        return (int) num;
    }

    private static long StrToIntCore(char[] s, int index, boolean minus) {
        long num = 0;

        while (index != s.length) {
            if ('0' <= s[index] && s[index] <= '9') {
                int flag = minus ? -1 : 1;
                num = num * 10 + flag * (s[index] - '0');

                if ((!minus && num > Integer.MAX_VALUE) ||
                        (minus && num < Integer.MIN_VALUE)) {
                    num = 0;
                    break;
                }

                index++;
            } else {
                num = 0;
                break;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Question67 test = new Question67();
        System.out.println(test.myAtoi("-91283472332"));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(912834723 * 10 + 3);
    }
}

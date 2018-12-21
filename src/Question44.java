public class Question44 {
    /**
     *              数字序列中某一位的数字
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
     * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，
     * 等等。请写一个函数，求任意第n位对应的数字。
     */

    public int digitAtIndex(int index) {
        if (index < 0) return -1;

        int digits = 1; //数字位数
        while (true) {
            int num = countOfIntegers(digits);
            if (index < num * digits)
                return digitAtIndex(index, digits);

            index -= digits * num;
            digits++;
        }
    }

    //得到m位的数字共有多少个
    private int countOfIntegers(int digits) {
        if (digits == 1) return 10;

        int count = (int)(Math.pow(10, digits - 1));
        return 9 * count;
    }

    //当我们知道要找的那一位数字位于某m位数之中后，用该函数找出那一位数字
    private int digitAtIndex(int index, int digits) {
        int num = beginNumber(digits) + index / digits; //100 + 270 beginNumber=100   index / digits = 811 / 3 = 270
        int indexFromRight = digits - index % digits;  //3 - 1 = 2 digits=3  index % digits = 811 % 3 = 1
        for (int i = 1; i < indexFromRight; i++) {
            num /= 10;
        }
        return num % 10;
    }

    //m位数的第一个数字
    private int beginNumber(int digits) {
        if (digits == 1) return 0;

        return (int)(Math.pow(10, digits - 1));
    }

    public static void main(String[] args) {
        Question44 test = new Question44();
        System.out.println(test.digitAtIndex(1001));
    }
}

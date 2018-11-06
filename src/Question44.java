public class Question44 {
    public int digitAtIndex(int index) {
        if (index < 0)
            return -1;

        int digits = 1;
        while (true) {
            int num = countOfIntegers(digits);
            if (index < num * digits)
                return digitAtIndex(index, digits);

            index -= digits * num;
            digits++;
        }
    }

    private int countOfIntegers(int digits) {
        if (digits == 1)
            return 10;

        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }

    private int digitAtIndex(int index, int digits) {
        int num = beginNumber(digits) + index / digits; //100 + 270 beginNumber=100   index / digits = 811 / 3 = 270
        System.out.println("num " + num);
        int indexFromRight = digits - index % digits;  //digits=3  index % digits = 811 % 3 = 1
        System.out.println("indexFromRight " + indexFromRight);
        for (int i = 1; i < indexFromRight; i++) {
            num /= 10;
        }
        return num % 10;
    }

    private int beginNumber(int digits) {
        if (digits == 1)
            return 0;

        return (int) (Math.pow(10, digits - 1));
    }

    public static void main(String[] args) {
        Question44 test = new Question44();
        System.out.println(test.digitAtIndex(10011));
    }
}

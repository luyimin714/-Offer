public class Question17 {
    public void Print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;

        StringBuffer number = new StringBuffer();

        for (int i = 0; i < n; i++) {
            number.append('0');
        }

        while (!Increment(number)) {
            PrintNumber(number);
        }
    }

    private boolean Increment(StringBuffer number) {
        boolean isOverflow = false;
        int nTakeOver = 0;   //进位
        int nLength = number.length();
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number.charAt(i) - '0' + nTakeOver;

            //最低位加一
            if (i == nLength - 1) {
                nSum++;
            }

            //是否产生进位
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number.setCharAt(i, (char) ('0' + nSum));
                }
            } else {
                number.setCharAt(i, (char) ('0' + nSum));
                break;  //若不产生进位，则跳出循环，完成加1操作
            }
        }
        return isOverflow;
    }

    private void PrintNumber(StringBuffer number) {
        boolean isBeginning0 = true;
        for (int i = 0; i < number.length(); i++) {
            if (isBeginning0 && number.charAt(i) != '0') {
                isBeginning0 = false;
            }

            if (!isBeginning0) {
                System.out.print(number.charAt(i));
            }
        }
        System.out.println();
    }

    public void Print1ToMaxOfNDigits2(int n) {
        if (n < 0)
            return;

        StringBuffer number = new StringBuffer();
        for (int i = 0; i < n; i++) {
            number.append('0');
        }

        for (int i = 0; i < 10; i++) {
            number.setCharAt(0, (char) (i + '0'));
            Print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
//        Print1ToMaxOfNDigitsRecursively(number, n, 0);

    }

    private void Print1ToMaxOfNDigitsRecursively(StringBuffer number,
                                                 int length, int index) {
        if (index == length - 1) {
            PrintNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number.setCharAt(index + 1, (char) (i + '0'));
            Print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }


    public static void main(String[] args) {
        Question17 question17 = new Question17();
        //question17.Print1ToMaxOfNDigits(5);
        //question17.print(5);
        question17.Print1ToMaxOfNDigits2(3);
//        BigInteger integer = new BigInteger("1");
//        System.out.println(integer);
//        BigInteger add1 = new BigInteger("1");
//        integer.add(add1);
//        System.out.println(integer);
    }
}

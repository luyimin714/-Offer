public class Question43 {
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;

        String str = n + "";
        return numOf1(str);
    }

    private int numOf1(String str) {
        if (str.length() == 0)
            return 0;

        int first = str.charAt(0) - '0';
        int length = str.length();

        if (length == 1 && first == 0)
            return 0;

        if (length == 1 && first > 0)
            return 1;

        int numFirstDigit = 0;
        if (first > 1)
            numFirstDigit = (int) Math.pow(10, length - 1);
        else if (first == 1)
            numFirstDigit = Integer.parseInt(str.substring(1)) + 1;

        int numOtherDigits = (int) (first * (length - 1) * Math.pow(10, length - 2));

        int numRecursive = numOf1(str.substring(1));

        return numFirstDigit + numOtherDigits + numRecursive;
    }

    public int NaiveCountDigitOne(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            count += numOf1(i);
        }
        return count;
    }

    private int numOf1(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Question43 question43 = new Question43();
        long start = System.nanoTime();
        int num1 = question43.NaiveCountDigitOne(824883294);
        long end = System.nanoTime();
        System.out.println(num1 + " " + (end - start) + "ns");

        start = System.nanoTime();
        num1 = question43.countDigitOne(824883294);
        end = System.nanoTime();
        System.out.println(num1 + " " + (end - start) + "ns");
    }
}

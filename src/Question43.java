public class Question43 {
    /**
     *       整数中1出现的次数（从1到n整数中1出现的次数）
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
     * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
     * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     */
    //leetcode
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;
            long b = n % m;
            count += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return count;
    }

    // 剑指Offer
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;

        String str = n + "";
        return numOf1(str);
    }

    private int numOf1(String str) {
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

    //
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
        int num1 = question43.NaiveCountDigitOne(5000);
        long end = System.nanoTime();
        System.out.println(num1 + " " + (end - start) + "ns");

        start = System.nanoTime();
        num1 = question43.countDigitOne(5000);  //824883294
        end = System.nanoTime();
        System.out.println(num1 + " " + (end - start) + "ns");

        start = System.nanoTime();
        num1 = question43.NumberOf1Between1AndN_Solution(5000);  //824883294
        end = System.nanoTime();
        System.out.println(num1 + " " + (end - start) + "ns");
    }
}

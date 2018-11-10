public class Question49 {
    /*
     * 第 n 个丑数
     */
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int p2 = 0, p3 = 0, p5 = 0;
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        for (int i = 1; i < n; i++) {
            uglyNums[i] = Math.min(uglyNums[p2] * 2, Math.min(uglyNums[p3] * 3, uglyNums[p5] * 5));
            if (uglyNums[i] == uglyNums[p2] * 2) p2++;
            if (uglyNums[i] == uglyNums[p3] * 3) p3++;
            if (uglyNums[i] == uglyNums[p5] * 5) p5++;
        }
        return uglyNums[n - 1];
    }

    public int nthUglyNumber2(int n) {
        if (n <= 0)
            return 0;

        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int nexUglyIndex = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        while (nexUglyIndex < n) {
            int min = Math.min(uglyNums[p2] * 2, Math.min(uglyNums[p3] * 3, uglyNums[p5] * 5));
            uglyNums[nexUglyIndex] = min;

            while (uglyNums[p2] * 2 <= uglyNums[nexUglyIndex])
                p2++;
            while (uglyNums[p3] * 3 <= uglyNums[nexUglyIndex])
                p3++;
            while (uglyNums[p5] * 5 <= uglyNums[nexUglyIndex])
                p5++;

            nexUglyIndex++;
        }

        return uglyNums[nexUglyIndex - 1];
    }

    public int nthUglyNumberNaive(int n) {
        if (n <= 0)
            return 0;

        int num = 0;
        int uglyIndex = 0;
        while (uglyIndex < n) {
            num++;

            if (isUgly(num))
                uglyIndex++;
        }
        return num;
    }

    private boolean isUgly(int num) {
        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;

        return num == 1;
    }

    public static void main(String[] args) {
        Question49 test = new Question49();
        System.out.println(test.nthUglyNumber(1500));
        System.out.println(test.nthUglyNumber2(1500));
        //ystem.out.println(test.nthUglyNumberNaive(1500));
    }
}

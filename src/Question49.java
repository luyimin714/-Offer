public class Question49 {
    /**
     *                  丑数
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     */

    //leetcode
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int p2 = 0, p3 = 0, p5 = 0;
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;

        for (int i = 1; i < n; i++) {
            uglyNums[i] = Math.min(uglyNums[p2]*2, Math.min(uglyNums[p3]*3, uglyNums[p5]*5));
            if (uglyNums[i] == uglyNums[p2]*2) p2++;
            if (uglyNums[i] == uglyNums[p3]*3) p3++;
            if (uglyNums[i] == uglyNums[p5]*5) p5++;
        }
        return uglyNums[n-1];
    }

    //剑指offer：创建数组保存已经找到的丑数，用空间换时间的解法
    public int nthUglyNumber2(int n) {
        if (n <= 0) return 0;

        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int i = 1;   //nextUglyIndex

        int p2 = 0, p3 = 0, p5 = 0;

        while (i < n) {
            uglyNums[i] = Math.min(uglyNums[p2]*2, Math.min(uglyNums[p3]*3, uglyNums[p5]*5));

            while (uglyNums[p2]*2 <= uglyNums[i]) p2++;  //==也可以  if也可以
            while (uglyNums[p3]*3 <= uglyNums[i]) p3++;
            while (uglyNums[p5]*5 <= uglyNums[i]) p5++;

            i++;
        }

        return uglyNums[i-1];
    }

    //剑指offer：逐个判断每个整数是不是丑数的解法，直观但不够高效
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

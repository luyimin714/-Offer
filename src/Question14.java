public class Question14 {
    /**
     *                      剪绳子
     * 给你一根长度为n的绳子，请把绳子剪成m段 (m和n都是整数，n>1并且m>1)
     * 每段绳子的长度记为k[0],k[1],...,k[m].请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
     * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
     */
    //动态规划
    public int maxProductAfterCutting_solution1(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int[] products = new int[length + 1];

        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;

                products[i] = max;
            }
        }
        return products[length];
    }

    //贪婪算法
    public int maxProductAfterCutting_solution2(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        //尽可能多地去剪长度为3的绳子段
        int timesOf3 = length / 3;

        //当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        //此时更好的方法是把绳子剪成长度为2的两段，因为2x2 > 3x1
        if (length - timesOf3 * 3 == 1)
            timesOf3 -= 1;

        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}

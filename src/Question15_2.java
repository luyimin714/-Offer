public class Question15_2 {
    /**
     * leetcode 461. 汉明距离
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     */
    //先异或再统计1的个数
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((z & flag) != 0)
                count++;
            flag <<= 1;
        }
        return count;
    }
}

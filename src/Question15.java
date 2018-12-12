public class Question15 {
    /**
     *              二进制中1的个数
     *  输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */
    //更好的解法
    //把一个整数减去1，就是把最右边的1变成0，左边的位保持不变
    //那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    //常规解法
    public int hammingWeight1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;

            flag <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int flag = 1;
        while (flag != 0) {
            System.out.println(flag);
            flag <<= 1;
        }
        System.out.println(flag);
    }
}

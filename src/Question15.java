public class Question15 {
    /***********************************************************
     *              二进制中1的个数
     *  输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     ***********************************************************/
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

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
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

public class Question15_2 {
    public int hammingDistance(int x, int y) {
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

    public int hammingDistance2(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}

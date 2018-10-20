public class Question15 {
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

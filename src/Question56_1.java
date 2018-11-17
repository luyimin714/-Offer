public class Question56_1 {
    /*
     *   给定一个非空整数数组，除了某个元素只出现一次以外，
     *  其余每个元素均出现了三次。找出那个只出现了一次的元素。
     */
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = nums[i] & bitMask;
                if (bit != 0)
                    bitSum[j] += 1;

                bitMask <<= 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += bitSum[i] % 3;
        }

        return res;
    }
}

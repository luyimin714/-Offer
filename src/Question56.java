public class Question56 {
    /**
     *      数组中只出现一次的数字
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，
     * 其余所有元素均出现两次。 找出只出现一次的那两个元素。
     */


    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;

        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        int indexOf1 = 0;
        //在整数num的二进制表示中找到最右边是1的位
        while ((diff & 1) == 0 && indexOf1 < 32) {
            diff >>= 1;
            indexOf1++;
        }

        for (int num : nums) {
            if (((num >> indexOf1) & 1) == 1) //判断在num的二进制表示中从右边数起的indexBit位是不是1
                res[0] ^= num;
            else
                res[1] ^= num;
        }

        return res;
    }

    //剑指offer
    public int[] singleNumber2(int[] nums) {
        int[] res = new int[2];

        if (nums == null || nums.length <= 0) return res;

        int or = 0;
        for (int num : nums)
            or ^= num;

        int indexOf1 = findFirstBitIs1(or);

        for (int num : nums) {
            if (isBit1(num, indexOf1))
                res[0] ^= num;
            else
                res[1] ^= num;
        }

        return res;
    }

    //在整数num的二进制表示中找到最右边是1的位
    private int findFirstBitIs1(int num) {
        int indexBit = 0;
        while (((num & 1) == 0) && indexBit < 32) {
            num >>= 1;
            indexBit++;
        }

        return indexBit;
    }

    //判断在num的二进制表示中从右边数起的indexBit位是不是1
    private boolean isBit1(int num, int indexBit) {
        num >>= indexBit;
        return (num & 1) == 1;
    }
}

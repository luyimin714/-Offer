public class Question21 implements Foo {
    public boolean func (int n) {
        return (n & 1) == 0;
    }

    public static void ReorderOddEven(int[] nums, Foo foo) {
        if (nums == null || nums.length == 0)
            return;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            while (start < end && !foo.func(nums[start]))  //(nums[start] & 0x1) != 0
                start++;
            while (start < end && foo.func(nums[end]))  //(nums[end] & 0x1) == 0
                end--;
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        ReorderOddEven(nums, new Question21());
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1)
                System.out.print(" ");
        }
    }
}

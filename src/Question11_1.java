public class Question11_1 {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int index1 = 0;
        int index2 = nums.length - 1;
        int indexMid = index1;
        while(nums[index1] >= nums[index2]){
            if(index2 - index1 == 1){
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if(nums[index1] == nums[index2] &&
                    nums[indexMid] == nums[index1])
                return minInOrder(nums, index1, index2);

            if(nums[indexMid] >= nums[index1])
                index1 = indexMid;
            else if(nums[indexMid] <= nums[index2])
                index2 = indexMid;
        }
        return nums[indexMid];
    }

    private int minInOrder(int[] nums, int index1, int index2){
        int res = nums[index1];
        for(int i = index1 + 1; i <= index2; i++){
            if(res > nums[i])
                res = nums[i];
        }
        return res;
    }
}

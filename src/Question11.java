public class Question11 {
    public int findMin(int[] nums) {
        //剑指offer 数组中没有重复
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
            if(nums[indexMid] >= nums[index1])
                index1 = indexMid;
            else if(nums[indexMid] <= nums[index2])
                index2 = indexMid;
        }
        return nums[indexMid];
    }
}

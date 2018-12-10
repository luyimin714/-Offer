public class Question11 {
    public int findMin(int[] nums) {
        /***************************************************************
         *   旋转数组的最小数字
         * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
         * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
         * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
         * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
         ***************************************************************/
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

import java.util.Arrays;

/**
 * Created by X on 08/04/2016.
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */
public class Solution26 {
    public static int removeDuplicates(int[] nums) {
        int pos = 1;
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i - 1] != nums[i]) {
                nums[pos ++] = nums[i];
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,5,5,6};
        int length = removeDuplicates(nums);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }
}

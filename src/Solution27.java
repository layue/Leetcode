/**
 * Created by X on 24/03/2016.
 * Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Solution27 {
    public static int removeElement(int[] nums, int val) {
        int pos = 0;
        for(int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[pos] = nums[i];
                pos ++;
            }
        }
        return pos;
    }

    public static void main (String []  args) {
        int [] nums = {1,2,3,4,3,3,5};
        int n = removeElement(nums, 3);
        System.out.print(n);
    }

}

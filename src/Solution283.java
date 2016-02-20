/**
 * Created by X on 12/02/2016.
 Move zeros
 */
public class Solution283 {
    public static void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == 0) {
                int k;
                for(k = i + 1;  k < nums.length && nums[k] == 0; k ++);
                if(k == nums.length)
                    break;
                else {
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] n = {1, 0, 2, 0, 3};
        moveZeroes(n);
    }
}

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by X on 26/02/2016.
 */
public class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap();

        for(int i = 0; i < nums.length; i ++) {
            if (hm.containsKey(nums[i])) {
                result[0] = hm.get(nums[i]);
                result[1] = i;
                return result;
            }
            hm.put(target - nums[i], i);
        }

        return result;
    }
    public static void main(String [] args) {
        int [] nums = {3, 2, 4};
        int target = 6;
        int [] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}

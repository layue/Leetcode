import java.util.Arrays;

/**
 * Created by X on 11/07/2016.
 * Partition an integers array into odd number first and even number second.
 */
public class PartitionOddEven {
    public static void partitionOddEven (int [] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            for (;left < right && nums[left] % 2 == 1; left ++);

            for (; left < right && nums[right] % 2 == 0; right--);

            if(left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }

    public static void main(String [] args) {
        int [] nums = {1, 3, 5, 7, 2, 4, 6};
        partitionOddEven(nums);
        System.out.println(Arrays.toString(nums));
    }
}

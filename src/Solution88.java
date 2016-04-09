import java.util.Arrays;

/**
 * Created by X on 09/04/2016.
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Solution88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length == 0 || nums2.length == 0) {
            return;
        }

        int p1 = 0;
        int p2 = 0;
        int end = m;

        while(p1 < end && p2 < n) {
            if(nums1[p1] <= nums2[p2]) {
                p1 ++;
            } else {
                int move = 0;
                int start = p2;
                while(p2 < n && nums1[p1] > nums2[p2]) {
                    move ++;
                    p2 ++;
                }
                end += move;
                move(nums1, p1, move, end);
                add(nums1, nums2, p1, start, move);
            }
        }

        if(end < m + n) {
            add(nums1, nums2, p1, p2, n - p2);
        }
    }

    public static void move(int [] array, int pos, int move, int arrayEnd) {
        System.arraycopy(array, pos + move - move, array, pos + move, arrayEnd - (pos + move));
    }

    public static void add(int [] array1, int [] array2, int pos1,int pos2, int move) {
        System.arraycopy(array2, pos2, array1, pos1, move);
    }

    public static void main(String [] args) {
        int[] nums1 = {1,5,6,8,10,0,0,0};
        int[] nums2 = {4,7};
        int m = 5;
        int n = 2;

        merge(nums1, m, nums2, n);

        System.out.print(Arrays.toString(nums1));
    }
}

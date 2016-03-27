/**
 * Created by X on 27/03/2016.
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.
 */
public class Solution11 {
    public static int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while(l < r) {
            int h = height[l] < height[r] ? height[l] : height[r];
            int temp = h * (r - l);

            max = temp > max ? temp : max;

            if(height[l] < height[r]) {
                while (l < r && height[l] > height[++l]);
            } else {
                while (l < r && height[r] > height[--r]);
            }
        }

        return max;
    }

    public static void main(String [] args) {
        int [] height = {5,2,12,1,5,3,4,11,9,4};
        System.out.print(maxArea(height));
    }
}

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by X on 27/03/2016.
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Solution120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int [] d = new int[triangle.size()];

        d[0] = triangle.get(0).get(0);

        for(int i = 1; i < triangle.size(); i ++) {
            int j = i;
            d[j] = d[j - 1] + triangle.get(i).get(j);
            for(j = i - 1; j > 0; j --) {
                int temp = d[j] < d[j - 1] ? d[j] : d[j - 1];
                d[j] = temp + triangle.get(i).get(j);
            }
            d[0] = d[0] + triangle.get(i).get(0);
        }

        return min(d);
    }

    public static int min(int [] d) {
        int min = d[0];

        for(int i = 1; i < d.length; i ++) {
            min = d[i] < min ? d[i] : min;
        }

        return min;
    }

    public static void main(String [] args) {
//      How to initialise a List
        List<List<Integer>> triangle = asList(
                asList(2),
                asList(3,4),
                asList(6,5,7),
                asList(4,1,8,3));

        System.out.print(minimumTotal(triangle));
    }
}

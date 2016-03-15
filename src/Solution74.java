/**
 * Created by X on 11/03/2016.

 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Solution74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int left = 0;
        int right = matrix.length - 1;
        int mid;

        while(left < right - 1) {
            mid = left + (right - left) / 2;
            if (target >= matrix[mid][0]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        int row;
        if (target >= matrix[right][0]) {
            row = right;
        } else {
            row = left;
        }

        left = 0;
        right = matrix[row].length - 1;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (target > matrix[row][mid]) {
                left = mid + 1;
            }
            else if (target < matrix[row][mid]){
                right = mid - 1;
            } else {
                return true;
            }
        }

        return target == matrix[row][left];
    }

    public static void main(String [] args) {
//        int [][]matrix = {{1,5,8},{100,101,190},{200, 205,299}};
        int [][]matrix = {{-8,-6,-6,-4,-2,-1,-1,-1,0,1,2,4,6,7,7},
                {10,10,12,13,13,14,14,16,17,17,17,17,17,18,19},
                {22,24,26,28,29,31,32,34,34,34,34,36,38,39,39},
                {40,40,41,43,43,44,46,47,49,49,50,52,53,55,55},
                {56,57,59,61,62,64,65,65,66,67,68,68,69,70,71},
                {74,75,77,77,79,79,79,80,81,83,85,87,88,89,89},
                {91,93,94,96,97,98,99,99,100,100,102,104,105,107,107},
                {110,112,114,114,115,117,117,118,118,120,120,121,123,124,124},
                {127,127,129,131,133,134,134,135,137,139,139,140,142,143,144},
                {145,146,147,149,151,151,153,155,156,156,158,160,162,162,163}};

        System.out.println(searchMatrix(matrix, 107));

    }
}

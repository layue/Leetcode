/**
 * Created by X on 10/07/2016.
 */
public class Search2DMetrix {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public static int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        int count = 0;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) {
                row ++;
                col --;
                count ++;
            } else if (matrix[row][col] > target) {
                col --;
            } else {
                row ++;
            }
        }
        return count;
    }

    public static void main(String [] args) {
        int [][] matrix = {{1,3,5},{3,5,7},{5,7,9},{9,11,13}};
        System.out.println(searchMatrix(matrix, 5));
    }
}

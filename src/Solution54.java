import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 30/03/2016.
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class Solution54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();

        if(matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        result.addAll(spiral(0, matrix.length - 1, 0, matrix[0].length - 1, matrix));

        return result;
    }

    public static List<Integer> spiral(int rowF, int rowT, int colF, int colT, int[][] matrix) {
        List<Integer> res = new ArrayList();
        if(rowF > rowT || colF > colT) {
            return res;
        }

        if(rowF == rowT) {
            for(int i = colF; i <= colT; i ++) {
                res.add(matrix[rowF][i]);
            }
            return res;
        }

        if(colF == colT) {
            for(int i = rowF; i <= rowT; i ++) {
                res.add(matrix[i][colF]);
            }
            return res;
        }

        for(int i = colF; i < colT; i ++) {
            res.add(matrix[rowF][i]);
        }
        for(int i = rowF; i < rowT; i ++) {
            res.add(matrix[i][colT]);
        }
        for(int i = colT; i > colF; i --) {
            res.add(matrix[rowT][i]);
        }
        for(int i = rowT; i > rowF; i --) {
            res.add(matrix[i][colF]);
        }

        res.addAll(spiral(rowF + 1, rowT - 1, colF + 1, colT - 1, matrix));
        return res;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        List<Integer> result;

        result = spiralOrder(matrix);

        System.out.println(result);
    }
}

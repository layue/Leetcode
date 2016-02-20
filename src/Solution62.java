/**
 * Created by X on 20/02/2016.
 * Unique paths from (1, 1) to (m, n)
 */
public class Solution62 {
    public static int uniquePaths(int m, int n) {
//----------Solution1-----------
//        if(m == 1 || n == 1)
//            return 1;
//        return uniquePaths(m-1, n) + uniquePaths(m, n-1);

//----------Solution2-----------
//        return dfs(1, 1, m, n);
//    }
//    public int dfs(int i, int j, int m, int n) {
//        if(i == m || j == n)
//            return 1;
//        return dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
//    }

//---------Solution3------------
        if(m == 0 || n == 0)
            return 0;
        if(m == 1 || n == 1)
            return 1;

        int [][]dp = new int[m][n];

        for(int i = 0; i < m; i ++)
            dp[i][0] = 1;
        for(int i = 0; i < n; i ++)
            dp[0][i] = 1;

        for(int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String [] args) {
        int m = 3;
        int n = 5;
        System.out.println(uniquePaths(m, n));
    }
}

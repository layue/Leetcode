/**
 * Created by X on 31/03/2016.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class Solution36 {
    public static boolean isValidSudoku(char[][] board) {
        int N = board.length;
        for (char[] aBoard : board) {
            int[] label = new int[N + 1];
            for (int col = 0; col < N; col++) {

                if (aBoard[col] >= '1' && aBoard[col] <= '9') {
                    if (label[aBoard[col] - '0'] == 1) {
                        return false;
                    } else {
                        label[aBoard[col] - '0'] = 1;
                    }
                } else if (aBoard[col] != '.') {
                    System.out.println("**");
                    return false;
                }
            }
        }

        for(int col = 0; col < N; col ++) {
            int [] label = new int[N + 1];
            for (char[] aBoard : board) {
                if (aBoard[col] >= '1' && aBoard[col] <= '9') {
                    if (label[aBoard[col] - '0'] == 1) {
                        return false;
                    } else {
                        label[aBoard[col] - '0'] = 1;
                    }
                } else if (aBoard[col] != '.') {
                    return false;
                }
            }
        }

        int row = 0;
        int col = 0;
        while(row < 9) {
            while(col < 9) {
                int [] label = new int[N + 1];
                for(int i = 0; i < 3; i ++) {
                    for(int j = 0; j < 3; j ++) {
                        if(board[row + i][col + j] >= '1' && board[row + i][col + j] <= '9') {
                            if(label[board[row + i][col + j] - '0'] == 1) {
                                return false;
                            } else {
                                label[board[row + i][col + j] - '0'] = 1;
                            }
                        } else if (board[row + i][col + j] != '.') {
                            return false;
                        }
                    }
                }
                col += 3;
            }
            col = 0;
            row += 3;
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'.','.','.','.','.','.','5','.','.'},
                          {'.','.','.','.','.','.','.','.','.'},
                          {'.','.','.','.','.','.','.','.','.'},
                          {'9','3','.','.','2','.','4','.','.'},
                          {'.','.','7','.','.','.','3','.','.'},
                          {'.','.','.','.','.','.','.','.','.'},
                          {'.','.','.','3','4','.','.','.','.'},
                          {'.','.','.','.','.','3','.','.','.'},
                          {'.','.','.','.','5','2','.','.','.'}};

        System.out.print(isValidSudoku(board));
    }
}

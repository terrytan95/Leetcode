class Solution {
    public boolean exist(char[][] board, String word) {
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                if (exist(board, m, n, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int start) {
        if (start >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(start++)) {
            char tempCell = board[i][j];
            board[i][j] = '*'; // make sure every cell only be used once
            boolean res = exist(board, i + 1, j, word, start) ||
                          exist(board, i - 1, j, word, start) ||
                          exist(board, i, j + 1, word, start) ||
                          exist(board, i, j - 1, word, start);
            board[i][j] = tempCell;
            return res;
        }
        return false;
    }
}

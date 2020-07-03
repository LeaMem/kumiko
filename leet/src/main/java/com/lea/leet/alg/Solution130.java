package com.lea.leet.alg;

public class Solution130 {

    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[i].length - 1);
        }

        for (int j = 0; j < board[0].length; j++) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, int i, int j) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);

    }

    public static void main(String[] args) {

        char[][] board = {};

        Solution130 solution130 = new Solution130();
        solution130.solve(board);
    }

}

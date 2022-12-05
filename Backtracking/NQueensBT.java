// column wise recursion (vertical)

import java.util.*;

public class NQueensBT {
    public static boolean isSafe(int row, int col, char[][] board){

        // horizontal
        for(int i = 0; i<board.length;i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        // vertical
        for(int j = 0; j<board.length;j++){
            if(board[j][col] == 'Q'){
                return false;
            }
        }

        
        // upper left
        int r = row;
        for(int c = col; c >= 0 && r >= 0; c--, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // upper right 
        r = row; 
        for(int c = col; c < board.length && r >= 0; c++, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower left  
        r = row;
        for(int c=col; c>=0 && r<board.length; r++, c--){
        // for(int c = col; c >= 0 && r < board.length; c--, r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower right  
        r = row;
        for(int c = col; c < board.length && r < board.length; c++, r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void saveBoards(char[][] board, List<List<String>> allBoards){

        String row = "";

        List<String> newBoard = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            row = "";
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 'Q'){
                    row += 'Q';
                }else{
                    row += '.';
                }

            }

            newBoard.add(row);
        }

        allBoards.add(newBoard);
    }

    public static void helper(char[][] board, List<List<String>> allBoards, int col){
        if(col == board.length){
            saveBoards(board, allBoards);
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n){

        List<List<String>> allBoards = new ArrayList<>();

        char[][] board = new char[n][n];

        helper(board, allBoards, 0);

        return allBoards;
    }
    public static void main(String args[]) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}

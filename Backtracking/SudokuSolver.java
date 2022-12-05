import java.util.*;

public class SudokuSolver {
    
    public static boolean isSafe(int grid[][], int row, int col, int number) {

        // check row and column 
        for(int i = 0; i < grid.length; i++){
            if(grid[row][i] == number){
                return false;
            }
            if(grid[i][col] == number){
                return false;
            }
        }

        // check grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for(int i = sr; i < sr + 3; i++){
            for(int j = sc; j < sc + 3; j++){
                if(grid[i][j] == number){
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean solveSudoku(int grid[][], int row, int col) {
        if(row == grid.length){
            return true;
        }

        int nrow = 0;
        int ncol = 0;

        if(col == grid.length - 1){
            nrow = row + 1;
            ncol = 0;
        }else{
            nrow = row;
            ncol = col + 1;
        }

        if(grid[row][col] != 0){
            if(solveSudoku(grid, nrow, ncol)){
                return true;
            }
        }else{
            //fill this with 0-9 and check is it safe
            for(int i = 1; i <= 9; i++){
                // add every number and then check the number is safe or not at current position
                if(isSafe(grid, row, col, i)){
                    // add number at current position
                    grid[row][col] = i;
                    // check number is safe or not at current posistion
                    if(solveSudoku(grid, nrow, ncol)){
                        return true;
                    }else{
                        // remove number (position not correct)
                        grid[row][col] = 0;
                    }
                }
            }
        }

        return false;
    }
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);

        int[][] grid = new int[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        boolean res = solveSudoku(grid, 0, 0);

        if(res){
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid.length; j++){
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}

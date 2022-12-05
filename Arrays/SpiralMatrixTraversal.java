import java.util.*;

public class SpiralMatrixTraversal {

    public static int[] reverseSpiralMatrix(int R, int C, int[][] a) {
        int top = 0,bottom=R-1;
        int left = 0,right=C-1;
        int ptr = 0;
        int ans[] = new int[R*C];
        while(top<=bottom && left<=right && ptr<R*C){
            for(int i = left;i<=right;i++){
                ans[ptr++]=a[top][i];
            }
            top++;
            if(top>bottom) break;
            for(int i=top;i<=bottom;i++){
                ans[ptr++]=a[i][right];
            }
            right--;
            if(left>right) break;
            for(int i = right ; i>=left;i--){
                ans[ptr++]=a[bottom][i];
            }
            bottom--;
            for(int i = bottom ;i>=top;i-- ){
                ans[ptr++]=a[i][left];
            }
            left++;
            }
             
            int l = 0,size=R*C-1;
            while(l<size){
                int temp = ans[l];
                ans[l]=ans[size];
                ans[size]=temp;
                l++;
                size--;
        }
        return ans;
    }

    public static int[] spiralMatrix(int R, int C, int[][] a) {
        int top = 0,bottom=R-1;
        int left = 0,right=C-1;
        int ptr = 0;
        int ans[] = new int[R*C];
        while(top<=bottom && left<=right && ptr<R*C){
            for(int i = left;i<=right;i++){
                ans[ptr++]=a[top][i];
            }
            top++;
            if(top>bottom) break;
            for(int i=top;i<=bottom;i++){
                ans[ptr++]=a[i][right];
            }
            right--;
            if(left>right) break;
            for(int i = right ; i>=left;i--){
                ans[ptr++]=a[bottom][i];
            }
            bottom--;
            for(int i = bottom ;i>=top;i-- ){
                ans[ptr++]=a[i][left];
            }
            left++;
            }
             
        //     int l = 0,size=R*C-1;
        //     while(l<size){
        //         int temp = ans[l];
        //         ans[l]=ans[size];
        //         ans[size]=temp;
        //         l++;
        //         size--;
        // }
        return ans;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int matrix[][] = new int[n][m];

        // for input
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        sc.close();

        // my approach
        // int rowStart = 0;
        // int rowEnd = n - 1;
        // int colStart = 0;
        // int colEnd = m - 1;

        // while (rowStart <= rowEnd && colStart <= colEnd) {
        //     for (int i = colStart; i <= colEnd; i++) {
        //         System.out.print(matrix[rowStart][i] + " ");
        //     }f
        //     rowStart++;
        //     for (int i = rowStart; i <= rowEnd; i++) {
        //         System.out.print(matrix[i][colEnd] + " ");
        //     }
        //     colEnd--;
        //     for (int i = colEnd; i >= colStart; i--) {
        //         System.out.print(matrix[rowEnd][i] + " ");
        //     }
        //     rowEnd--;
        //     for (int i = rowEnd; i >= rowStart; i--) {
        //         System.out.print(matrix[i][colStart] + " ");
        //     }
        //     colStart++;
        // }

        int[] res = spiralMatrix(n, m, matrix);

        for(int i=0;i<res.length;i++){
            System.out.print(res[i] +" ");
        }

    }
}

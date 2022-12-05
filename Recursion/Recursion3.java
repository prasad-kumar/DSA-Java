import java.util.*;

public class Recursion3 {
    public static void printPermutaion(String str, String perm) {
        if(str.length() == 0){
            System.out.println(perm);
            return;
        }

        for(int i = 0; i < str.length(); i++){
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPermutaion(newStr, perm + currChar);
        }
    }


    public static int countPaths(int n, int m, int i, int j) {
        // path ends here
        if(i == n - 1 || j == m - 1){
            return 1;
        }

        return countPaths(n, m, i + 1, j) + countPaths(n, m, i, j + 1);
    }


    public static int placeTiles(int n, int m) {
        if(n < m) {
            return 1;
        } else if(n == m) {
            return 2;
        }
  
        return placeTiles(n-1, m) + placeTiles(n-m, m);
    }

    

    public static int pairFriends(int n) {
        if(n <= 1) {
            return 1;
        }
        // pairFriends(n-1) == for single
        // (n-1) * pairFriends(n-2) == for pair
   
         return pairFriends(n-1) + (n-1) * pairFriends(n-2);
     }
  

    // to print elements of arraylist
    public static void printSubset(ArrayList<Integer> subset) {
        for(int i = 0; i < subset.size(); i++){
            System.out.print(subset.get(i)+ " ");
        }
        System.out.println();
    }


    public static void findSubsets(int n, ArrayList<Integer> subset) {
        if(n == 0){
            printSubset(subset);
            return;
        }

        // choose
        subset.add(n);
        findSubsets(n - 1, subset);

        // not choose
        subset.remove(subset.size() - 1);
        findSubsets(n - 1,  subset);




    }

    public static void main(String args[]) {

        // 1. print permutaions of string
        String str= "123";
        printPermutaion(str, "");

        //2. print paths of maze
        // int n = 3;
        // int m = 3;
        // int paths = countPaths(n, m, 0, 0);
        // System.out.println(paths);

        //3. tiling problem
        // int n = 4, m = 2;
        // System.out.println(placeTiles(n, m));

        //4. freinds pairing
        // int n = 4;
        // System.out.println(pairFriends(n));

        // 5. print subset of a set
        // int n = 3;
        // ArrayList<Integer> subset = new ArrayList<>();
        // findSubsets(n, subset);

    }
}

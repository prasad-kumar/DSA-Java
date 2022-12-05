import java.util.HashSet;

public class Recursion2{

    public static String newString = "";
    public static void reverseSting(String str, int idx) {
        if(idx == 0){
            newString += str.charAt(idx);
            System.out.println(newString);
            return;
        }
        
        newString += str.charAt(idx);
        reverseSting(str, idx - 1);
        
    }


    public static int first = -1;
    public static int last = -1;
    public static void getIndices(String str, char element, int idx) {
        if(idx == str.length()){
            return;
        }
        char curChar = str.charAt(idx);
        if(curChar == element){
            if(first == -1){
                first = idx;

            }else{
                last = idx;
            }
        }

        getIndices(str, element, idx + 1);

    }


    public static boolean isSorted(int arr[], int idx) {
        if(idx == arr.length - 1){
            return true;
        }

        if(arr[idx] < arr[idx + 1]){
            return isSorted(arr, idx + 1);
        }else{
            return false;
        }
    }


    public static String newString2 = "";
    public static void moveAll(String str, int idx, int count) {
        if(idx == str.length()){
            for(int i = 1; i <= count; i++){
                newString2 += "x";
            }
            return;
        }

        char curChar = str.charAt(idx);

        if(curChar != 'x'){
            newString2 += curChar;

        }else{
            count += 1;
        }

        moveAll(str, idx + 1, count);
    }

    public static String newString3 = "";
    public static String removeDuplicates(String str, int idx, boolean present[]) {
        if(idx == str.length()){
            return "";
        }

        char curChar = str.charAt(idx);
        if(present[curChar - 'a']){
            return removeDuplicates(str, idx + 1, present);
        }else{
            present[curChar - 'a'] = true;
            return curChar + removeDuplicates(str, idx, present);
        }
    }

    public static void printSubsequences(String str, int idx, String subSeq) {
        if(idx == str.length()){
            System.out.println(subSeq);
            return;
        }

        // choose
        printSubsequences(str, idx+1, subSeq + str.charAt(idx));

        // don't choose
        printSubsequences(str, idx+1, subSeq);
    }
    

    public static void printUniqueSubsequences(String str, int idx, String subSeq, HashSet<String> allSubseq) {
        if(idx == str.length()){
            if(allSubseq.contains(subSeq)){
                return;
            }else{
                allSubseq.add(subSeq);
                System.out.println(subSeq);
                return;
            }
        }

        // choose
        printUniqueSubsequences(str, idx+1, subSeq + str.charAt(idx), allSubseq);

        // don't choose
        printUniqueSubsequences(str, idx+1, subSeq, allSubseq);
    }

    public static String keypad[] = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void printKeypadCombination(String numbers, int idx, String res) {
        if(idx == numbers.length()){
            System.err.println(res);
            return;
        }
        
        for(int i=0; i<keypad[numbers.charAt(idx) - '0'].length(); i++) {
            char curr = keypad[numbers.charAt(idx) - '0'].charAt(i);
            printKeypadCombination(numbers, idx+1, res+curr);
            }
    }

    public static void main(String args[]) {
        // 1. reverse string
        // String str = "abcd";
        // reverseSting(str, str.length() - 1);

        // 2. find first and last occurances of element
        // String str = "tabcdfghijokokakkk";
        // char element = 'a';
        // getIndices(str, element, 0);
        // System.out.println("first occurance :" + first);
        // System.out.println("last occurance :" + last);

        // 3. check if array sorted(strictly increasing)
        // int arr[] = {1,2,3,4,5,5};
        // boolean result = isSorted(arr, 0);
        // System.out.println(result);

        // 4. move all x's to end
        // String str= "xaxbxcxdx";
        // moveAll(str, 0, 0);
        // System.out.println(newString2);

        // 5. remove duplicates from string
        // String str = "aabccdddd";
        // boolean present[] = new boolean[str.length()];
        // System.out.println(removeDuplicates(str, 0, present));

        // 6. print all subSequences
        // String str = "abc";
        // printSubsequences(str, 0, "");


        // 7. print all unique subSequences
        // String str = "aaa";
        // HashSet<String> allSubseq = new HashSet<>();
        // printUniqueSubsequences(str, 0, "", allSubseq);

        // 8. print keypad combinations
        String numbers = "14";
        printKeypadCombination(numbers, 0, "");

    }
}
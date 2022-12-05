import java.util.*;

public class NumberSystem {

    public static int binaryToDecimal(int n) {

        double i = 0;
        double ans = 0;

        while (n != 0) {
            int digit = n % 10;

            if (digit == 1) {
                ans = ans + Math.pow(2, i);
            }

            n = n / 10;
            i++;
        }

        // converting double to int
        int finalAns = (int) ans;
        return finalAns;

    }


    public static int decimalTOBinary( int n) {

        double ans = 0;
        int i = 0;
        while(n!=0){
            int bit = n & 1;

            ans = (bit * (Math.pow(10, i))) + ans;

            n = n >> 1;
            i++;
        }

        // converting double to int
        int finalAns = (int) ans;
        return finalAns;
        
    }

    public static int countOnes(int n) {

        int result = decimalTOBinary(n);

        System.out.println(result);

        // count ones in binary representation of n
        int count = 0;
        
        while(result != 0){
            int digit = result % 10;

            if(digit == 1){
                count += 1;
            }
            result /= 10;
        }

        return count;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = decimalTOBinary(n);
        // int result = binaryToDecimal(n);

        // int result = countOnes(n);

        System.out.println(result);

        sc.close();
    }
}


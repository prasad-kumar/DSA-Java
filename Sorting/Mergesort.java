public class Mergesort {

    public static void conquer(int arr[], int si, int mid, int ei) {

        int merged[] = new int[ei - si + 1]; // ei+1;

        int idx1 = si; //for first divided array
        int idx2 = mid + 1;  // for second divided array
        int x = 0;  // for meged array
 
        while(idx1 <= mid && idx2 <= ei){
            // checking
            if(arr[idx1] <= arr[idx2]){
                merged[x++] = arr[idx1++];

                // merged[x] = arr[idx1];
                // x++;
                // idx1++;
            }else{
                merged[x++] = arr[idx2++];
            }
        }

        // adding rest of array to merged if incase any elements left
        while(idx1 <= mid){
            merged[x++] = arr[idx1++];
        }

        while(idx2 <= ei){
            merged[x++] = arr[idx2++];
        }

        // copying merged array into arr
        for(int i = 0, j = si; i < merged.length; i++, j++ ){
            arr[j] = merged[i];
        }

        
    }

    public static void divide(int arr[], int si, int ei) {
        
        if(si >= ei){
            return;
        }

        int mid = si + (ei - si) / 2;

        divide(arr, si, mid);
        divide(arr, mid + 1, ei);

        conquer(arr, si, mid, ei); 
    }

    public static void main(String args[]) {
        
        int arr[] = {3,2,8,5,9,4,7};
        int n = arr.length;

        divide(arr, 0, n - 1);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }

        // System.out.println();

    }
}

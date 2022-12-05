

public class Sorting {

    public static void main(String args[]){

        int arr[] = {7, 8, 3, 1, 2};   
        
        // bubble sort
        for(int i = 0; i < arr.length - 1; i++){
            
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }

        // insertion sort
        for(int i = 0; i < arr.length - 1; i++){
            int smallest = i;
            for(int j = i +1; j < arr.length; j++){
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }

            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp; 
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}

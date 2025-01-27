public class BubbleSort{    
                       
    // Also known as sinking sort or exchange sort
    // Here i is the counter of no of iterations 
    // At every pass one element compares itself with its next and swap according to condition
    // At last the highest no is at the last index
    // And no of comparisons reduced from behind using (arr.length-i-1)


    public static void bubbleSortIterative(int arr[]){
        boolean swap = false;
        for(int i=0;i<arr.length;i++){     // i -> counter run n-1 times
            swap = false;
            for(int j=1;j<=arr.length-i-1;j++){     //in each step max item will come at last respective index
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swap = true;
                }
            }
            //if no swapping is done in a particular value of i then array is already sorted
            if(!swap){
                break;
            }
        }
    }

    public static void bubbleSortRecursive(int arr[], int r, int c){
        if(r == 0){
            return;
        }
        if(c < r){
            if(arr[c] > arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubbleSortRecursive(arr, r, c+1);
        }
        else{
            bubbleSortRecursive(arr, r-1, 0);
        }
    }

    public static void display(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "     ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int arr[] = {2,4,7,1,5,3};
        bubbleSortRecursive(arr, arr.length-1,0);
        display(arr);
    }
}

package pack;

public class SelectionSort {

    // Assume that first index item is the smallest
    // Take an inner loop from index+1 to end
    // compare the first element with others and find out the smallest 
    // At last swap the smallest item with the first item
    // Do these processes at each index

    public static void selectionSortIterative(int arr[]) {
        for(int i=0;i<arr.length-1;i++) {
            int smallest = i;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            swap(arr, smallest, i);
        }
    }

    public static void selectionSortRecursive(int arr[], int r, int c, int max){
        if(r == 0){
            return;
        }
        if(r > c){
            if(arr[c] > arr[max]){
                selectionSortRecursive(arr, r, c+1, c);
            }
            else{
                selectionSortRecursive(arr, r, c+1, max);
            }
        }
        else{
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;

            selectionSortRecursive(arr, r-1, 0, 0);
        }
    }

    private static void swap(int arr[], int max, int end) {
        int temp = arr[max];
        arr[max] = arr[end];
        arr[end] = temp;
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "     ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 5, 7, 8 };
        selectionSortRecursive(arr,arr.length-1,0,0);
        selectionSortIterative(arr);
        display(arr);
    }
}

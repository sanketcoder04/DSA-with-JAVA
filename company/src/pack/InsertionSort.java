package pack;

public class InsertionSort {
    
    //We will take the second element and compare it with the first element and if it is smaller than the first element then we will swap them.
    //It will continue to the 0 index and the same thing will be repeated from index [1 to arr.length-1]

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "     ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 1, 2, 4, 3, 6 };
        insertionSort(arr);
        display(arr);
    }
}
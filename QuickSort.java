public class QuickSort {

    // Choose any element in the Array as Pivot
    // After first pass all the elements less than pivot will be on the left side of
    // pivot and all the elements greater than pivot will be on the right side of
    // pivot that will continue until the whole array is sorted
    
    // How to put pivot at correct position -> while arr[start] < p
    // start++
    // while arr[end] > p
    // end--

    // Take pivot as last element

    // Recuurrance relation of QuickSort -> T(n) = T(k) + T(n-k-1) + O(n) where k is
    // the size of elements before pivot and n-k-1 is the size of elements after
    // pivot and n is size of array

    // Worst Case when k = 0 T(n) = T(n-1) + O(n)
    // Best Case when k = n/2 T(n) = 2T(n/2) + O(n) Time Complexity -> O(nlogn)

    // Not Stable Algorithm and In Place Sorting

    public static void quickSort(int arr[], int low, int high){
        if(low >= high){
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];

        // also a reason why if its already sorted it will not swap

        while(start <= end){
            while(arr[start] < pivot){
                start++;
            }
            while(arr[end] > pivot){
                end--;
            }
            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        // now my pivot is at correct index, please sort the two halves now
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "     ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 3, 2, 9};
        quickSort(arr, 0, arr.length-1);    
        display(arr);
    }
}

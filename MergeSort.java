import java.util.Arrays;

public class MergeSort {

    // Simply given an Array [5,3,7,1,9]
    // We will divide the array in two parts until we have one element in each part
    // Then we will merge the two parts and sort them and return to the previous step

    // At every level n elements are being merged and total number of levels is logn
    // Therefore total number of comparisons are nlogn
    // So the time complexity is O(nlogn)
    // Space complexity is O(n) as we are creating a new array of size n

    // Hybrid Sort -> Merge Sort + Insertion Sort

    public static int[] mergeSort(int arr[]) {
        if (arr.length == 1) {
            return arr; // We will return the arr when it has single element in it
        }
        int mid = arr.length / 2;
        int left[] = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int right[] = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int first[], int second[]) {
        int result[] = new int[first.length + second.length]; // we will return this array as merged and sorted
        int i = 0;  // for first arr indexing
        int j = 0;  // for second arr indexing
        int k = 0;  // for result arr indexing

        // We will compare the elements of both the arrays and add the smaller element
        // to the mix array to make the mix sorted
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                result[k] = first[i];
                i++;
            } else {
                result[k] = second[j];
                j++;
            }
            k++;
        }
        // It may be possible that one of the array is not completely traversed
        // Hence we will add the remaining elements
        while (i < first.length) {
            result[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            result[k] = second[j];
            j++;
            k++;
        }
        return result;
    }

    // For In-place merge sort we will use the same merge function but we will not
    // create a new array
    // We will pass start and end index of an Array

    public static void mergeSort(int arr[], int start, int end) {
        if (end - start == 1) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int arr[], int start, int mid, int end) {
        int result[] = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;

        // We will compare the elements of both the arrays and add the smaller element
        // to the mix array to make the mix sorted
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                result[k] = arr[i];
                i++;
            } else {
                result[k] = arr[j];
                j++;
            }
            k++;
        }
        // It may be possible that one of the array is not completely traversed
        // Hence we will add the remaining elements
        while (i < mid) {
            result[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            result[k] = arr[j];
            j++;
            k++;
        }

        // Copy Sorted value from mix to original array
        for (int l = 0; l < result.length; l++) {
            arr[start + l] = result[l];
        }
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "     ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 3, 7, 1, 9 };
        arr = mergeSort(arr);
        display(arr);

        mergeSort(arr, 0, arr.length);
        display(arr);
    }
}

package pack;

public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(num, max);
        }

        // Iterate for each digit place value (units, tens, hundreds, etc.)
        int exp = 1;
        while (max / exp > 0) {
            countSort(arr, exp);
            exp *= 10; // Move to the next place value
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // to store the sorted array
        int[] count = new int[10]; // count array of digits

        // Count the occurrences of each digit at the current place value
        for (int i = 0; i < n; i++) {
            int item = (arr[i] / exp) % 10; // find digit at that place
            count[item]++; // increment the value by 1
        }

        // Update count[i] to contain the position of the next occurrence of the digit
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array by placing elements in their correct sorted position
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--; // Decrement the count for that digit
        }
    }

    public static void display(int[] arr) {
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 29, 83, 471, 36, 91, 8 };
        radixSort(arr);
        display(arr);
    }
}

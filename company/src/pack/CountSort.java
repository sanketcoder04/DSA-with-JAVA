package pack;

public class CountSort {

    // Works with smaller numbers  
    // Find out the max item in arr then create a count arr of size n+1 and
    // put frequency of elements at particular index same to that number
    // Then put the item at the desired place according to the frequency from smaller to bigger

    public static void countSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int num : arr) {
            max = Math.max(num, max);
        }
        int[] count = new int[max + 1];
        for(int num : arr) {
            count[num]++;
        }
        int index = 0;  // to track for the input array indexing
        for(int i=0;i<=max;i++) {
            while(count[i] > 0) {
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }

    public static void display(int[] arr) {
        for(int num : arr) {
            System.out.print(num + "\t");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        countSort(arr);
        display(arr);
    }
}

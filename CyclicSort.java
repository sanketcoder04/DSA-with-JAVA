public class CyclicSort {

    // use this sorting algorithm when the array is the range from 1 to n
    // Example : Elements - 1 2 3 4 5
    //           Index  -   0 1 2 3 4
    //In any question if it is given that array is in range [1,n] or [0,n] use Cyclic Sort 

    public static void cyclicSort(int arr[]) {
        int index = 0;
        while (index < arr.length) {
            int correctIndex = arr[index] - 1;
            if (arr[index] != arr[correctIndex]) {
                int temp = arr[index];
                arr[index] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                index++;
            }
        }
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "     ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 3, 4, 2, 1 };
        cyclicSort(arr);
        display(arr);
    }
}

import java.util.Arrays;

class LinearSearch {
    public static int linearSearch(int arr[], int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] linearSearch(int arr[][], int target) {
        int result[] = new int[2];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    result[0] = row;
                    result[1] = col;
                    return result;
                }
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }

    public static void printArrayElements(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "   ");
        }
    }

    public static void main(String[] args) {
        // int nums[] = {2,4,5,1,9};
        // int target = 4;
        // System.out.println(linearSearch(nums,target));

        int nums2[][] = { { 4, 6, 7, 2 }, { 2, 6, 1 }, { 8, 1, 9 } };
        int target2 = 8;
        int search[] = linearSearch(nums2, target2);
        System.out.println(Arrays.toString(search));

    }
}

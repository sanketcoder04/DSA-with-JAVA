package pack;

public class BinarySearch {
    public static int binarySearchIterativeAscending(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // int mid = (start + end)/2; if we use this formula to detrmine mid somehow it
            // can be possible that it get beyond the range of Integer in Java

            int mid = start + (end - start) / 2; // Here mid always lies between Integer range

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursiveAscending(int arr[], int target, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return binarySearchRecursiveAscending(arr, target, start, mid - 1);
            } else {
                return binarySearchRecursiveAscending(arr, target, mid + 1, end);
            }
        }
        return -1;
    }

    public static int binarySearchIterativeDescending(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                start = mid + 1;
            } else {
                end = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursiveDescending(int arr[], int target, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearchRecursiveDescending(arr, target, start, mid - 1);
            } else {
                return binarySearchRecursiveDescending(arr, target, mid + 1, end);
            }
        }
        return -1;
    }

    public static int orderAgnosticBinarySearchIterative(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean ascending = false;
        if (arr[start] < arr[end]) {
            ascending = true;
        } else {
            ascending = false;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (ascending) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int orderAgnosticBinarySearchRecursive(int arr[], int target, int start, int end) {
        boolean ascending = false;
        if (arr[start] < arr[end]) {
            ascending = true;
        } else {
            ascending = false;
        }
        if (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (ascending) {
                if (arr[mid] > target) {
                    return orderAgnosticBinarySearchRecursive(arr, target, start, mid);
                } else {
                    return orderAgnosticBinarySearchRecursive(arr, target, mid + 1, end);
                }
            } else {
                if (arr[mid] < target) {
                    return orderAgnosticBinarySearchRecursive(arr, target, start, mid);
                } else {
                    return orderAgnosticBinarySearchRecursive(arr, target, mid + 1, end);
                }
            }
        }
        return -1;
    }

    public static int[] binarySearch2D(int[][] arr, int target) {
        int row = 0;
        int col = arr.length - 1;

        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                return new int[] { row, col };
            } else if (arr[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void printArrayElements(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "   ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 78, 42, 34, 12, 5, 2 };
        int target = 100;
        int result = orderAgnosticBinarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println(result);

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int target2D = 8;
        int res[] = binarySearch2D(matrix, target2D);
        System.out.println("Element is present at : [" + res[0] + "," + res[1] + "]");
    }
}

package pack;

import java.util.ArrayList;
import java.util.List;

class PrintNumbers {
    public void printNum(int n) {
        if (n == 0) {
            return;
        }
        printNum(n - 1);
        System.out.println(n);
    }

    public void printNumReverse(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumReverse(n - 1);
    }
}

class Factorial {
    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = n * factorial(n - 1);
        return result;
    }
}

class SumAndProduct {
    public int sumOfRange(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = n + sumOfRange(n - 1);
        return sum;
    }

    public int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        int digit = n % 10;
        int sum = digit + sumOfDigits(n / 10);
        return sum;
    }

    public int productOfRange(int n) {
        if (n == 1) {
            return 1;
        }
        int product = n * productOfRange(n - 1);
        return product;
    }

    public int productOfDigits(int n) {
        if (n % 10 == n) { // For single digit numbers, the number itself is its own product of digits
            return n;
        }
        int digit = n % 10;
        int product = digit * productOfDigits(n / 10);
        return product;
    }
}

class Reverse {
    public int sum = 0;

    public void reverse(int n) {
        if (n == 0) { // For single digit numbers, they are their own reversed
            return;
        }
        int digit = n % 10;
        sum = sum * 10 + digit;
        reverse(n / 10);
    }
}

class Palindrome extends Reverse {
    public boolean palindrome(int n) {
        reverse(n);
        if (n == sum) {
            return true;
        } else {
            return false;
        }
    }
}

class Count {
    public int countTarget(int num, int count, int target) {
        if (num == 0 && target == 0) {
            return ++count;
        }
        if (num % 10 == num) {
            return count;
        }
        if (num % 10 == target) {
            count++;
        }
        return countTarget(num / 10, count, target);
    }
}

class FibonacciSeries {
    public static int getFibonacciNumber(int n) {
        if (n < 2) {
            return n;
        }
        return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }

    public static void printFibonacciSeries(int i, int j, int n) {
        if (n == 0) {
            return;
        }
        int sum = i + j;
        System.out.println(sum);
        printFibonacciSeries(j, sum, n - 1);
    }

    public static int sumOfFibonacciSeries(int n, int sum) {
        if (n == 0) {
            return sum;
        }
        sum += getFibonacciNumber(n);
        return sumOfFibonacciSeries(n - 1, sum);
    }
}

class Array {
    public boolean isSorted(int arr[], int index) {
        if (index == arr.length - 2) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return isSorted(arr, index + 1);
    }

    public int findIndex(int arr[], int index, int target) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findIndex(arr, index + 1, target);
    }

    public ArrayList<Integer> findAllIndex(int arr[], int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndex(arr, target, index + 1, list);
    }

    public int rotatedBinarySearch(int arr[], int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[low] <= arr[mid]) {
            if (target >= arr[low] && target <= arr[mid]) {
                return rotatedBinarySearch(arr, target, low, mid - 1);
            } else {
                return rotatedBinarySearch(arr, target, mid + 1, high);
            }
        }
        if (target >= arr[mid] && target <= arr[high]) {
            return rotatedBinarySearch(arr, target, mid + 1, high);
        }
        return rotatedBinarySearch(arr, target, low, mid - 1);
    }
}

class Patterns {
    // print the Pattern
    // ****
    // ***
    // **
    // *
    public void pattern1(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            System.out.print("*");
            pattern1(row, col + 1);
        } else {
            System.out.println();
            pattern1(row - 1, 0);
        }
    }

    // print the Pattern
    // *
    // **
    // ***
    // ****
    public void pattern2(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            pattern2(row, col + 1);
            System.out.print("*");
        } else {
            pattern2(row - 1, 0);
            System.out.println();
        }
    }
}

class Strings {
    // skip all the a's from the string Example - "baccad"
    // Now we will pass the answer string as an argument to the function and we will
    // add the character to the answer string discarding a's

    // We will take the first character from the string and check if it is equal to
    // a or not
    // If it is equal to a then we will call the function again with the string
    // starting from the next character
    // else add the character and then call the function again with the string
    // starting from the next character

    // We will take two strings as arguments
    // processed - string that contains the answer
    // unprocessed - string that contains the characters that are not processed yet

    public void skipCharacter(String processed, String unprocessed, char c) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        if (ch == c) {
            skipCharacter(processed, unprocessed.substring(1), c);
        } else {
            skipCharacter(processed + ch, unprocessed.substring(1), c);
        }
    }

    public String skipCharacter(String unprocessed, char c) {
        if (unprocessed.isEmpty()) {
            return "";
        }
        char ch = unprocessed.charAt(0);
        if (ch == c) {
            return skipCharacter(unprocessed.substring(1), c);
        } else {
            return ch + skipCharacter(unprocessed.substring(1), c);
        }
    }

    // Now if we need to skip an entire substring from an string we will check if
    // the substring is starts with the given substring

    // We will take the actual string and the substring that needs to be removed

    public String skipSubString(String str, String subStr) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith(subStr)) {
            return skipSubString(str.substring(subStr.length()), subStr); // We will remove the substring from the
            // string and then call the function again
        } else {
            return str.charAt(0) + skipSubString(str.substring(1), subStr);
        }
    }

    // Now if the string not contains "apple" then it will skip "app"

    public String skipAppNotApple(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith("app") && !str.startsWith("apple")) {
            return skipAppNotApple(str.substring(3));
        } else {
            return str.charAt(0) + skipAppNotApple(str.substring(1));
        }
    }

    // SubSets -> Permutaions & Combinations
    // Non Adjacent collection of elements -> Ignore some elements and taking some
    // elemets are subset pattern
    // [3, 5, 9] -> null [3] [5] [9] [3, 5] [3, 9] [5, 9] [3, 5, 9]

    // Create all the subsets of a given string

    // Taking to strings processed which is initially empty and other one is
    // unprocessed given string
    // Now we have the choice two ignore or take elements
    // ""|abc
    // / \
    // a|bc ""|bc
    // / \ / \
    // ab|c a|c b|c ""|c
    // / \ / \ / \ / \
    // abc ab ac a bc b c null

    // In the recursion tree each steps one element is added or ignored and at the
    // end when unprocessed becomes null it is the base condition

    public void subsequences(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        subsequences(processed + ch, unprocessed.substring(1)); // taking first character
        subsequences(processed, unprocessed.substring(1)); // ignoring first character
    }

    public ArrayList<String> subSequences(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> left = subSequences(processed + ch, unprocessed.substring(1));
        ArrayList<String> right = subSequences(processed, unprocessed.substring(1));

        left.addAll(right);
        return left;
    }

    // here prints ascii values with subsequences

    public void subsequencesASCII(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        subsequencesASCII(processed + ch, unprocessed.substring(1)); // taking first character
        subsequencesASCII(processed, unprocessed.substring(1)); // ignoring first character
        subsequencesASCII(processed + (ch + 0), unprocessed.substring(1));
    }

    // All possible combinations of a given String

    // For a string "abc" its possible permutations can be
    // ["abc","bca","acb","bac","cab","cba"]
    // we will take a string processed which is initially empty and unprocessed
    // which is initially the given string

    // Now in each recursive call we shall take the first character of unprocessed
    // string and place it in all possible positions in the processed string

    // no of all possible permutations of a String -> (string.length())!

    // If processed = "ab" and unprocessed = "c"
    // c can be placed at => [ab'c'] , [a'c'b] , ['c'ab]

    public void permutations(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);

        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());

            permutations(first + ch + second, unprocessed.substring(1));
        }
    }

    public ArrayList<String> permuTations(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());

            result.addAll(permuTations(first + ch + second, unprocessed.substring(1)));
        }
        return result;
    }

    public int permutationsNumber(String unprocessed, String processed) {
        if (unprocessed.isEmpty()) {
            return 1;
        }
        char ch = unprocessed.charAt(0);
        int count = 0;
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());

            count += permutationsNumber(first + ch + second, unprocessed.substring(1));
        }
        return count;
    }

    // Subsets of an Array [1,2,3] => [[],[1],[2],[3],[1,2],[2,3],[1,3],[1,2,3]]

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num : nums) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
}

class TelePhonePatterns {
    // The basic approach on this problem is we have to take all the possible
    // combinations
    // that can be made by digits

    // Example - digits = "56"
    // Then combinations = [jm,jn,jo,km,kn,ko,lm,ln,lo]

    // We take two Strings processed(empty) and unprocessed(pattern)

    // If we press (1) -> "abc"
    // If we press (2) -> "def"
    // If we press (3) -> "ghi"
    // If we press (4) -> "jkl"
    // If we press (5) -> "mno"
    // If we press (6) -> "pqr"
    // If we press (7) -> "stu"
    // If we press (8) -> "vwx"
    // If we press (9) -> "yz"

    // Possible digit range -> [(digit-1)*3 , digit*3)

    public void letterCombinations(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        int digit = unprocessed.charAt(0) - '0'; // convert char digit into digit

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            letterCombinations(processed + ch, unprocessed.substring(1));
        }
    }

    public ArrayList<String> letterCombinationsList(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> str = new ArrayList<>();
            str.add(processed);
            return str;
        }
        int digit = unprocessed.charAt(0) - '0'; // convert char digit into digit
        ArrayList<String> list = new ArrayList<>();

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            list.addAll(letterCombinationsList(processed + ch, unprocessed.substring(1)));
        }
        return list;
    }
}

class DicePatterns {

    // Giving a target and need to find out the number of possible dice combination
    // to achieve that no

    // Let target = 4 then combinations will be [1111, 112, 13, 22, 4]

    public void diceCombinations(String processed, int target) {
        if (target == 0) {
            System.out.println(processed);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            diceCombinations(processed + i, target - i);
        }
    }
}

class MazeProblems {
    // Maze problem
    // Given a maze of nxn matrix the person wants to go from (0,0) to (n,n) and
    // he/she can only move right and down
    // Return the no of possible paths towards destination

    public int countPaths(int row, int col) {
        if (row == 0 || col == 0) {
            return 1;
        }
        int leftAnswer = countPaths(row - 1, col);
        int rightAnswer = countPaths(row, col - 1);
        return leftAnswer + rightAnswer;
    }

    // Now print all the possible paths in the maze

    // Now if we add Diagonal Paths no of solution and paths will be Different then
    // we should enter an extra path condition
    // For Vertical paths we will give "V" path in the answer

    public void possiblePaths(String processed, int row, int col) {
        if (row == 0 && col == 0) {
            System.out.println(processed);
            return;
        }
        if (row > 0) {
            possiblePaths(processed + "D", row - 1, col);
        }
        if (col > 0) {
            possiblePaths(processed + "R", row, col - 1);
        }
        if (row > 0 && col > 0) {
            possiblePaths(processed + "V", row - 1, col - 1);
        }
    }

    // Paths storing in ArrayList

    public ArrayList<String> possiblePathsReturn(String processed, int row, int col) {
        if (row == 0 && col == 0) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(processed);
            return list;
        }
        ArrayList<String> answers = new ArrayList<>();
        if (row > 0) {
            answers.addAll(possiblePathsReturn(processed + "D", row - 1, col));
        }
        if (col > 0) {
            answers.addAll(possiblePathsReturn(processed + "R", row, col - 1));
        }
        if (row > 0 && col > 0) {
            answers.addAll(possiblePathsReturn(processed + "V", row - 1, col - 1));
        }
        return answers;
    }

    // Now if we add obstacle in the cells then the path

    public void possiblePathWithObstacle(String processed, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }
        if (maze[row][col] == false) {
            return;
        }
        if (row < maze.length - 1) {
            possiblePathWithObstacle(processed + "D", maze, row + 1, col);
        }
        if (col < maze[0].length - 1) {
            possiblePathWithObstacle(processed + "R", maze, row, col + 1);
        }
    }

    public void allPaths(String processed, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }
        if (maze[row][col] == false) {
            return;
        }
        maze[row][col] = false;

        if (row < maze.length - 1) {
            allPaths(processed + "D", maze, row + 1, col);
        }
        if (col < maze[0].length - 1) {
            allPaths(processed + "R", maze, row, col + 1);
        }
        if (col > 0) {
            allPaths(processed + "L", maze, row, col - 1);
        }
        if (row > 0) {
            allPaths(processed + "U", maze, row - 1, col);
        }

        // Here the function will be over now
        // remove the changes made by the function before the function get removed
        maze[row][col] = true;
    }
}

class NQueens {
    public int queensPosition(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;

        // placing Queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            // place the queen if it's safe
            if (isSafe(board, row, col)) {
                board[row][col] = true; // mark as a possible postion
                count += queensPosition(board, row + 1); // recursion
                board[row][col] = false; // backtrack and change the changes made
            }
        }
        return count;
    }

    public void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public boolean isSafe(boolean[][] board, int row, int col) {
        // check for the row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // check for the column
        for (int i = 0; i < col; i++) {
            if (board[row][i]) {
                return false;
            }
        }
        // check for diagonal Left side
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        // check for diagonal Right side
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }
}

class NKnights {
    public void knightsPosition(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }
        if (row == board.length - 1 && col == board.length) {
            return;
        }
        if (col == board.length) {
            knightsPosition(board, row + 1, 0, knights);
            return;
        }
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knightsPosition(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        knightsPosition(board, row, col + 1, knights);
    }

    public boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row + 1, col - 2)) {
            if (board[row + 1][col - 2]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    public void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}

class SudokuSolver {
    public boolean solveSudoku(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (emptyLeft == false) {
                break;
            }
        }
        if (emptyLeft) {
            return true;
        }
        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board)) {
                    display(board);
                    System.out.println();
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public boolean isSafe(int[][] board, int row, int col, int number) {
        // check the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }

        // check for column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }

        // check for subgrid
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class RecursionMain {
    public static void main(String[] args) {
        SudokuSolver sudoku = new SudokuSolver();
        int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        System.out.println(sudoku.solveSudoku(board));

        Count c = new Count();
        System.out.println(c.countTarget(34456, 0, 4));
    }
}

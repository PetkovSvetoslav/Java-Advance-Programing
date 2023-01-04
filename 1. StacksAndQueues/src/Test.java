import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int price[] = {6, 5, 8, 4, 7, 10, 9, 2, 3, 11, 6, 9, 8, 7, 5, 4, 13, 10, 8, 9, 6, 15, 4, 3, 8};
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price, n, S);

        // print the calculated span values
        printArray(S);
    }

    // method to calculate stock span values
    static void calculateSpan(int price[], int n, int S[]) {
        // Span value of first day is always 1
        S[0] = 1;

        // Calculate span value of remaining days by linearly checking
        // previous days
        for (int i = 1; i < n; i++) {
            S[i] = 1; // Initialize span value

            // Traverse left while the next element on left is smaller
            // than price[i]
            for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--)
                S[i]++;
        }
    }

    // A utility function to print elements of array
    static void printArray(int arr[]) {
        System.out.print(Arrays.toString(arr));
    }

    // Driver program to test above functions
}
// This code is contributed by Sumit Ghosh



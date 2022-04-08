import java.util.Arrays;
import java.util.Scanner;

public class MaximumAbsurdity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split("\\s+");
        String[] line2 = sc.nextLine().split("\\s+");
        // 4 1
        // 1 2 2 2

        // String[] line1 = "6 3".split("\\s+");
        // String[] line2 = "15 20 1 15 43 6".split("\\s+");

        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);

        Integer[] absurdities = Arrays.stream(line2).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);
        // System.out.println("ABSURDITIES: ");
        // printArray(absurdities);
        //
        //       x     
        // x     x     x 
        // x     x x   x   
        // x     x x   x   x
        // x x   x x x x   x
        // x x x x x x x x x
        // [   ]|[   ]

        // this is probably DP
        // trying to maximise the two segment sums
        // max subarray on the left + max subarray on the right of a set middle
        // try this for all possible middles
        // instead of recalculating the max on either side as we shift the middle,
        //      we can precompute this.

        // we can precompute this using two sweeps of the array, one from the left,
        //      one from the right
        // going from left to right, can each index i, we store the maximum found so far
        // same for right to left.
        

        // LEFT
        
        long leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += absurdities[i];
        }


        long[] maxLeftSums = new long[n];
        int[] maxLeftSumsIndex = new int[n];
        maxLeftSums[k - 1] = leftSum;
        maxLeftSumsIndex[k - 1] = 0;

        for (int i = k; i < n - k; i++) {
            leftSum += absurdities[i];
            leftSum -= absurdities[i - k];
            
            if (leftSum > maxLeftSums[i - 1]) {
                maxLeftSums[i] = leftSum;
                maxLeftSumsIndex[i] = i - k + 1;
            } else {
                maxLeftSums[i] = maxLeftSums[i - 1];
                maxLeftSumsIndex[i] = maxLeftSumsIndex[i - 1];
            }

            
        }

        // System.out.println("MAXLEFTSUMS: ");
        // printArray(maxLeftSums);
        // System.out.println("MAXLeftSUMSINDEX: ");
        // printArray(maxLeftSumsIndex);
        
        // RIGHT


        long rightSum = 0;
        for (int i = n - 1; i > n - k; i--) {
            rightSum += absurdities[i];
        }

        long[] maxRightSums = new long[n];
        int[] maxRightSumsIndex = new int[n];
        maxRightSums[n - k] = rightSum;
        maxRightSumsIndex[n - k] = n - k;

        for (int i = n - k - 1; i > k - 1; i--) {

            rightSum += absurdities[i];
            rightSum -= absurdities[i + k];

            if (rightSum >= maxRightSums[i + 1]) {
                maxRightSums[i] = rightSum;
                maxRightSumsIndex[i] = i;
            } else {
                maxRightSums[i] = maxRightSums[i + 1];
                maxRightSumsIndex[i] = maxRightSumsIndex[i + 1];
            }

        }

        // System.out.println("MAXRIGHTSUMS: ");
        // printArray(maxRightSums);
        // System.out.println("MAXRIGHTSUMSINDEX: ");
        // printArray(maxRightSumsIndex);

        int maxLeftIndex = -1;
        int maxRightIndex = -1;
        long maxSum = -1;

        for (int i = k; i < n - k + 1; i++) {

            long currSum = maxLeftSums[i - 1] + maxRightSums[i];
            if (maxSum < currSum) {
                maxSum = currSum;
                maxLeftIndex = maxLeftSumsIndex[i - 1];
                maxRightIndex = maxRightSumsIndex[i];
            }

        }

        System.out.print((maxLeftIndex + 1) + " " + (maxRightIndex + 1));

        sc.close();
        //             n
        // a b c d e f
        //


    }

    // public static void printArray(int[] arr) {
    //     for (int i : arr) {
    //         System.out.print(i + " ");
    //     }
    //     System.out.print("\n");
    // }

    // public static void printArray(Integer[] arr) {
    //     for (int i : arr) {
    //         System.out.print(i + " ");
    //     }
    //     System.out.print("\n");
    // }
}

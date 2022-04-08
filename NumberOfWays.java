import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfWays {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int[] nums = fr.nextLineAsIntArray(n);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 3 != 0 || n < 3) {
            System.out.println("0");
            return;
        }

        long targetSubArraySum = sum / 3;

        int[] fromLeftValidSumsCount = new int[n];
        int validSumsCount = 0;

        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            if (currentSum == targetSubArraySum) {
                validSumsCount++;
            }
            fromLeftValidSumsCount[i] = validSumsCount;
            // System.out.print(validSumsCount);
        }

        // System.out.println("validSumsCount end");
        long result = 0;

        
        
        currentSum = 0;
        for (int i = n - 1; i > 1; i--) {
            currentSum += nums[i];
            if (currentSum == targetSubArraySum) {
                result += fromLeftValidSumsCount[i - 2];
            }
        }

        // [a, b, c, d]
        //           i

        

        System.out.println(result);


    }


    /** HELPER */

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        int[] nextLineAsIntArray(int n) {
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                result[i] = nextInt();
            }
            return result;
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
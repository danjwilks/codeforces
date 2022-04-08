import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JustEatIt {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        int ts = fr.nextInt();


        // [a, b, c, d, e, f, g]
        // [a, b] [   ] [     ]

        for (int t = 0; t < ts; t++) {

            int n = fr.nextInt();
            int[] nums = fr.nextLineAsIntArray(n);

            if (solve(nums)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }



    }

    // 

    public static boolean solve(int[] nums) {

        long currSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currSum += nums[i];
            if (currSum <= 0) {
                return false;
            }
        }

        currSum = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            currSum += nums[i];
            if (currSum <= 0) {
                return false;
            }
        }


        return true;
    }

    // public static int calcMaxSubArray(int[] nums, int totalSum) {

        // int[] minToLeft = new int[nums.length];
        // minToLeft[0] = Integer.MAX_VALUE;
        // int sum = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     minToLeft[i] = Math.min(sum, minToLeft[i - 1]);
        //     sum += nums[i];
        // }

        // int[] minToRight = new int[nums.length];
        // minToRight[nums.length - 1] = Integer.MAX_VALUE;
        // sum = nums[nums.length - 1];
        // for (int i = nums.length - 2; i >= 0; i--) {

        //     minToRight[i] = Math.min(sum, minToRight[i + 1]);
        //     sum += nums[i];

        // }

        // 1 2 3 4
        //       r
        // sum: 4
        // min: 4

        // totalSum - (x) > totalSum
        // minimise x
        
        // int minToMinus = Integer.MAX_VALUE;
        // System.out.println("*******");

        

        // for (int i = 0; i < nums.length; i++) {

        //     if (i == 0) {
        //         minToMinus = Math.min(minToMinus, minToRight[i]);
        //     } else if (i == nums.length - 1) {
        //         minToMinus = Math.min(minToMinus, minToLeft[i]);
        //     } else {
        //         minToMinus = Math.min(minToMinus, minToLeft[i] + minToRight[i]);
        //     }

        //     // System.out.println("minLeft: " + minToLeft[i]);
        //     // System.out.println("minRight: " + minToRight[i]);
            
        // }
        // System.out.println("*******");

        // return totalSum - minToMinus;

        



    // }


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

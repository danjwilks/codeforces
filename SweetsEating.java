import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SweetsEating {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        int n = fr.nextInt();
        int dayLimit = fr.nextInt();
        int[] sweets = fr.nextLineAsIntArray(n);

        StringBuilder result = new StringBuilder();
        Arrays.sort(sweets);
        
        // numToEat = 1
        // result = a1 * 1

        // numToEat = 2
        // result = a1 * 1 + a2 * 1

        // numToEat = 3
        // result = a1 * 2 + a2 * 1 + a3 * 1

        // numToEat = 4
        // result = a1 * 2 + a2 * 2 + a3 * 1 + a4 * 1

        // numToEat = 5
        // result = a1 * 3 + a2 * 2 + a3 * 2 + a4 * 1 + a5 * 1

        // numToEat = 6
        // result = a1 * 3 + a2 * 3 + a3 * 2 + a4 * 2 + a5 * 1 + a6 * 1

        // Result6 - Result5 
        // = a1 * 3 + a2 * 3 + a3 * 2 + a4 * 2 + a5 * 1 + a6 * 1
        // - a1 * 3 + a2 * 2 + a3 * 2 + a4 * 1 + a5 * 1
        // = a2 * 1 + a4 * 1 + a6 * 1

        // Result5 - Result4
        // = a1 * 3 + a2 * 2 + a3 * 2 + a4 * 1 + a5 * 1
        // - a1 * 2 + a2 * 2 + a3 * 1 + a4 * 1
        // = a1 * 1 + a3 * 1 + a5 * 1

        // Result4 - Result3
        // = a1 * 2 + a2 * 2 + a3 * 1 + a4 * 1
        // - a1 * 2 + a2 * 1 + a3 * 1
        // = a2 * 1 + a4 * 1

        // looking at the trend, to get from

        // Result1 = a1 * 1           
        // Result2 = Result1 + a2 * 1
        // Result3 = Result2 + a1 * 1 + a3 * 1
        // Result4 = Result3 + a2 * 1 + a4 * 1
        // Result5 = Result4 + a1 * 1 + a3 * 1 + a5 * 1
        // Result6 = Result5 + a2 * 1 + a4 * 1 + a6 * 1

        // 2 3 4 4 6 6 7 8 19

        long[] daySums = new long[dayLimit];
        long sumSugarPenalty = 0;
        for (int latestToEat = 0; latestToEat < n; latestToEat++) {

            if (latestToEat < dayLimit) {
                sumSugarPenalty += sweets[latestToEat];
                daySums[latestToEat] = sweets[latestToEat];
            } else {
                sumSugarPenalty += daySums[latestToEat % dayLimit] + sweets[latestToEat];
                daySums[latestToEat % dayLimit] += sweets[latestToEat];
            }

            result.append(sumSugarPenalty + " ");

        }

        System.out.println(result.toString());

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

        long[] nextLineAsLongArray(int n) {
            long[] result = new long[n];

            for (int i = 0; i < n; i++) {
                result[i] = nextLong();
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

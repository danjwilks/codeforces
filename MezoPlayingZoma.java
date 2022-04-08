import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MezoPlayingZoma {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int n = fr.nextInt();

        System.out.println(n + 1);

        // int lCount = 0;
        // int rCount = 0;

        // for (char c : line.toCharArray()) {
        //     if (c == 'L') {
        //         lCount++;
        //     } else {
        //         rCount++;
        //     }
        // }

        // int result = 0;

        // if (lCount == 0 && rCount == 0) {
            
        // } else if (lCount == 0) {
        //     result = 1 + rCount;
        // } else if (rCount == 0) {
        //     result = 1 + lCount;
        // } else {
        //     result = 1 + rCount + lCount;
        // }

        // System.out.println(result);

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EvenOdds {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        long n = fr.nextLong();
        long k = fr.nextLong();

        // n = 9
        // 1 2 3 4 5 6 7 8 9
        // 1 3 5 7 9 2 4 6 8
        // k = 3
        // 


        // if k == roundDown(n / 2), then is odd

        // if k > n / 2, then answer is an even number
        // else odd


        long halfN = (n + 1)/ 2;

        if (k > halfN) { // even
            k -= halfN;
            System.out.println(k * 2);
        } else { // odd
            System.out.println(k * 2 - 1);
        }

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

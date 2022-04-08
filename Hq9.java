import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Hq9 {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        String s = fr.next();
        Set<Character> printsOut = new HashSet<>(Arrays.asList('H', 'Q', '9'));

        for (int i = 0; i < s.length(); i++) {
            if (printsOut.contains(s.charAt(i))) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Football {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        String line = fr.next();
        int zerosCount = 0;
        int onesCount = 0;

        int r = 0;
        int l = 0;

        // 1010101010
        // 0123456789
        // l      r
        // 

        while (r < line.length()) {
            if (line.charAt(r) == '0') {
                zerosCount++;
            } else {
                onesCount++;
            }
            if (r - l == 7) {
                if (line.charAt(l) == '0') {
                    zerosCount--;
                } else {
                    onesCount--;
                }
                l++;
            }
            r++;
            if (zerosCount == 7 || onesCount == 7) {
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

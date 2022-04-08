
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KitaharaHarukisGift {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] apples = fr.nextIntLine(n);

        // 100 100 100 100 100
        // 200 200 200 200
        
        // can we cancel out the number of 200s?
        // then we will either have 0 and 1 200s.
        // if we have 0 200s, then if we have even 100s, we can solve it
        // if we have 1 200s, then if we have at least x 100s s.t. x >= 2 and x is even

        int smallerCount = 0;
        int largerCount = 0;

        for (int a : apples) {
            if (a == 100) {
                smallerCount++;
            } else {
                largerCount++;
            }
        }

        int modLarger = largerCount % 2;
        int modSmaller = smallerCount % 2;
        if (modLarger == 0 && modSmaller == 0) {
            System.out.println("YES");
        } else if (modLarger == 1 && smallerCount >= 2 && modSmaller == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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

        int[] nextIntLine(int n) {
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

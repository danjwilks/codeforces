import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FadiAndLcm {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int x = fr.nextInt();

        if (x == 1) {
            System.out.println("1 1");
        }

        // LCM(a, b) = x
        // minimise max(a, b)

        // x = p1^a1 * ... * pk^ak
        // x = p1^b1 * ... pk^bk + p1^c1 * ... pk^ck
        //      where 
        //          b1 + c1 = a1
        //          b2 + c2 = a2
        //              * * *
        //          bk + ck = ak
        //
        //      p1^a1 = p1 * p1 * ... * p1  
        //
        // a * k + b * j = x
        // k, j = {1..}
        // find the minimum of max(a,b)
        //
        //
        // LCM(a, b) = minimum x such that a and b are a multiple
        // LCM is either equal to max(a, b) or a multiple 



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

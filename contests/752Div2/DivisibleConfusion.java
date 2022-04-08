import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivisibleConfusion {
    public static void main(String[] args) {
        
        // a b c d e f
        // 1 2 3 4 5 6
        
        StringBuilder sbr = new StringBuilder();
        FastReader fr = new FastReader();
        int ts = fr.nextInt();
        int minDivisible = 2;

        for (int t = 0; t < ts; t++) {

            int n = fr.nextInt();

            boolean isValid = true;

            for (int i = 1; i <= n; i++) {

                int curr = fr.nextInt();
                if (!isValid || i + 1 > 22) {
                    continue;
                }

                int maxDivisor = i + 1;
                
                boolean foundValidDivisor = false;
                for (int d = minDivisible; d <= maxDivisor; d++) {
                    if (curr % d != 0) {
                        foundValidDivisor = true;
                        break;
                    }
                }

                if (!foundValidDivisor) {
                    isValid = false;
                } 

            }
            if (isValid) {
                sbr.append("YES\n");
            } else {
                sbr.append("NO\n");
            }
        }

        System.out.println(sbr.toString());


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
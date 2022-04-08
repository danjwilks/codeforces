import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XORSpeciaLISt {

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int ts = Integer.parseInt(fr.nextLine());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < ts; t++) {

            int n = Integer.parseInt(fr.nextLine());
            if (n % 2 == 0) {
                result.append("YES\n");
                fr.nextLine();
                continue;
            }
            String[] line = fr.nextLine().split("\\s+");
            
            int prev = Integer.parseInt(line[0]);
            boolean found = false;

            for (int i = 1; i < n; i++) {

                int curr = Integer.parseInt(line[i]);
                
                if (prev >= curr) {
                    result.append("YES\n");
                    found = true;
                    break;
                }
                prev = curr;

            }

            if (!found) result.append("NO\n");

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

// odd
// 1 2 3 4 5 6 7
// [    ]
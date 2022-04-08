import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntiLightscellguessing {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        // x x 
        // x Q
        // first choose 1,1
        // dist = 2
        // manhattan distance is equal to the difference in up or down + right or left.
        // so there are only x solutions available.
        // makes sense to always chooose just the left and not the centre?

        // x x x
        // x x x
        // x x x

        // Q x x x
        // x x x x
        // x x x x
        // x x T x
        // 

        // dist = 2 + 4 = 5

        // x x x
        // x x x
        
        // x x
        // x x
        // x x
        // this is the same as the above.

        // manhattan distance = | x2 - x1 | + | y2 - y1 |
        // so for example, if it is diagonally away by 1,

        // is it never 2?

        // we can always triangulate it by using bottom left, and bottom right for example.

        int ts = fr.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < ts; t++) {

            int m = fr.nextInt();
            int n = fr.nextInt();

            if (m == 1 && n == 1) {
                result.append("0\n");
            } else if (m == 1 || n == 1) {
                result.append("1\n");
            } else {
                result.append("2\n");
            }

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EqualOrNotEqual {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        // ENE
        // a1 equal to a2, a2 not equal to a3, a3 can be equal to a1
        // the inconsistency comes when the loop completes, what is the condition?

        // if last is N
        // then there can be no line of Es from 1 to n. There must be a not equal somewhere

        // if last is E
        // there can not be a line of Ns from 1 to n. There must be 


        // a1 == a2, a2 != a3, therefore a3 != a1 which is a contradition to the proposed

        // EEEEEE = fine
        // EEENEE = not fine
        // EEENNE = fine
        // EENNNE = fine

        // there must be either 0, 2 or more Ns, then we are fine

        int ts = fr.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < ts; t++) {

            int NCount = 0;

            String s = fr.nextLine();

            for (char c : s.toCharArray()) {
                if (c == 'N') {
                    NCount++;
                    if (NCount >= 2) {
                        break;
                    }
                }
            }

            result.append(NCount == 1 ? "NO" : "YES");
            result.append("\n");

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class EveryoneIsAWinner {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        int ts = fr.nextInt();
        StringBuilder sbr = new StringBuilder();

        for (int t = 0; t < ts; t++) {
            sbr.append(solve(fr.nextInt()));
        }

        System.out.println(sbr.toString());

    }

    static String solve(int n) {

        // n = 10
        // 0 for 10 < k
        // 1 for 5 < k <= 10
        // 2 for 2 < k <= 5
        // 5 for k == 2
        // 10 for k == 1

        // find the factors of the number, these are the values

        // (n / k) round down
        // find the multiples of n?
        
        // what is the largest number that can be a factor of n

        // n = a * b
        // we know a will increase while b will decrease
        // the largest factor a can be is n, and b == 1
        // then the second is
        //  a == n / 2, b == 2
        // at what point can we stop this?

        // n = 10
        // a = 10, b = 1
        // a = 5, b = 2
        // a = 2 -- seen this already
        // so we can stop when b = n / 2?

        // 
        // 

        // StringBuilder result = new StringBuilder();
        // long i = 1;
        // Set<Long> seen = new HashSet<>();
        // while(i * i <= n) {
        //     seen.add(i);
        //     seen.add(n / i);
        //     i++;
        // }

        // seen.add((long) 0);

        // for (long l : seen) {
        //     result.append(l + " ");
        // }

        TreeSet<Integer> seen = new TreeSet<>();
        seen.add(0);
        for (int i = 1; i * i <= n; i++) {
            seen.add(i);
            seen.add(n / i);
        }

        StringBuilder result = new StringBuilder();
        for (int x : seen) {
            result.append(x + " ");
        }



        return seen.size() + "\n" + result.toString() + "\n";
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

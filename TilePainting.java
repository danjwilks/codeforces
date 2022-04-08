import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TilePainting {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        long n = fr.nextLong();

        // 1 2 3 4 5 6 7
        // _ _ _ _ _ _ _
        // A _ _ _ _ _ _
        // A _ _ _ _ _ _
        // A B _ _ _ _ _
        // A B C D E F G

        // if its prime, then all colors can be used

        // 1 2 3 4 5 6 7 8 9
        // _ _ _ _ _ _ _ _ _
        // A _ _ _ _ _ _ _ _
        // A _ _ _ _ _ _ _ _
        // A B _ _ _ _ _ _ _
        // A B C A

        // it is equal to the smallest prime divisor of n
        
        // what is the proof?
        // well, what if there are other prime divisors?

        // 1 2 3 4 5 6
        // _ _ _ _ _ _
        // A _ _ _ _ _
        // A _ _ _ _ _
        // A B _ _ _ _
        // A A A A A A


        // 1 2 3 4 5 6 7 8 9 10
        // _ _ _ _ _ _ _ _ _ _
        // A _ _ _ _ _ _ _ _ _
        // A _ _ _ _ _ _ _ _ _
        // A B _ _ _ _ _ _ _ _
        // A A A A A A A A A A

        // there are 3 solutions, 1, minimum divisor, n
        // it is 1 when there are two divisors



        Set<Long> primes = getPrimes(n);

        long result = n;
        if (primes.size() == 1) {
            for (long l : primes) {
                result = l;
            }
        } else if (primes.size() > 1) {
            result = 1;
        }

        System.out.println(result);

    }

    static Set<Long> getPrimes(long n) {

        Set<Long> primes = new HashSet<>();
        for (long d = 2; d * d <= n; d++) {
            while (n % d == 0) {
                primes.add(d);
                n /= d;
            }
        }
        if (n > 1) primes.add(n);
        return primes;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class GcdProblem {
    public static void main(String[] args) {
        
        
        // a + b + c = n
        // gcd(a, b) = c
        // greatest common divisor

        // find smallest divisor
        // 

        // DISTINCT

        
        FastReader fr = new FastReader();
        int ts = fr.nextInt();

        List<Long> primes = getPrimes((long) Math.pow(10, 9));

        for (int t = 0; t < ts; t++) {

            long n = fr.nextLong();

        // for (long n = 10; n < Math.pow(10, 9); n++) {

            long a = 1;
            long b = 1;
            long c = 1;

            for (int i = 0; i < primes.size() && primes.get(i) < n - primes.get(i) - 1; i++) {

                long potentialB = n - primes.get(i) - 1;
                if (potentialB % primes.get(i) > 0) {
                    a = primes.get(i);
                    b = potentialB;
                    break;
                }

            }

            // a, n - 3, 1
            // find the first prime that does not divide n - p

            // 1, 1, 1
            // 2, 2, 2
            // 2, 3, 1
            // 3, 3, 3
            // 

            // pj1^j1 * ... * pjk^jk,  pm1^m1 * ... * pmk^mk
            // the overlap has to be equal to c
            // 1, 1, 1
            // get 


            if (a + b + c != n || (a == b || b == c)) {
                System.out.println("WRONG for n: " + n);
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println(a + " " + b + " " + c);
            }

        }

    }

    public static List<Long> getPrimes(long n) {

            List<Long> primes = new ArrayList<>();
            
            HashSet<Long> nonPrimes = new HashSet<>();

            long length = (long) Math.sqrt(n);
    
            for (long number = 2; number <= length; number++) {
    
                if (!nonPrimes.contains(number)) {
                    // is prime

                    for (int i = 0; number * number + i * number < length; i++) {
                        nonPrimes.add(number * number + i * number);
                    }
                }
    
            }
    
            for (long i = 2; i < length; i++) {
                if (!nonPrimes.contains(i)) {
                    primes.add(i);
                }
            }
    
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class ProductOfThreeNumbers {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int ts = fr.nextInt();

        StringBuilder result = new StringBuilder();
        List<Integer> primes = findAllPrimes((int) Math.pow(10, 9));

        for (int t = 0; t < ts; t++) {

            long n = fr.nextInt();

            // n = p1^k1 * ... * pm^km
            
            // find the number of distint primes of n

            // if there is only 1 prime
            //      then there must be at least 5 of those primes

            // if there is only 2 primes
            //      then one of the primes must appear three times
            //      or twice each

            // if there is only 3 primes
            //      then solution works

            boolean foundSolution = false;

            long prime1 = -1;
            long prime2 = -1;
            long number3 = -1;
            
            for (int i = 0; i < primes.size() && i < n; i++) {
                long prime = (long) primes.get(i);
                if (n % prime == 0) {
                    
                    if (prime1 == -1) {

                        prime1 = prime;
                        prime2 = prime * prime;
                        number3 = n / (prime1 * prime2);

                        if (isValid(prime1, prime2, number3, n)) {
                            foundSolution = true;
                            break;
                        } else {
                            prime2 = -1;
                            number3 = -1;
                        }

                    } else if (prime2 == -1) {

                        prime2 = prime;
                        number3 = n / (prime1 * prime2);
                        

                        if (isValid(prime1, prime2, number3, n)) {
                            foundSolution = true;
                            break;
                        }

                        prime2 = -1;
                        number3 = -1;

                    }
                    
                }
            }

            if (foundSolution) {
                result.append("YES\n");
                result.append(prime1 + " " + prime2 + " " + number3);
            } else {
                result.append("NO");
            }

            result.append("\n");

        }
        
        System.out.println(result.toString());

    }

    static boolean isValid(long a, long b, long c, long n) {

        if (a > 1 && b > 1 && c > 1 && a * b * c == n && a != b && a != c && b != c) {
            return true;
        }

        return false;

    }

    static List<Integer> findAllPrimes(long n) {

        List<Integer> primes = new ArrayList<>();
        int length = (int) Math.sqrt(n);
        // why is length sqrt
        // we want all primes up to 10^9
        
        // 10^9 = p1^a1 * ... * pk^ak
        // if there exists a prime that is larger than sqrt(10^9)
        // then the number would have to be larger than 10^9
        
        HashSet<Integer> nonPrimes = new HashSet<>();

        for (int number = 2; number <= length / 2; number++) {

            // why go to length / 2
            // we want to remove all multiples of the current number
            // if the current number is larger than half, then there
            // will be no multiples of the number since multiplying 
            // even just by 2, will make the resulting number out 
            // of range

            // why number <= length / 2
            // 11 / 2 -> we want to visit 5, but not 6
            // 12 / 2 -> we want to visit 6 and 12

            if (!nonPrimes.contains(number)) {
                // is prime
                int mult = number * number;
                while (mult < length) {
                    nonPrimes.add(mult);
                    mult *= number;
                }  
            }

        }

        for (int i = 2; i < length; i++) {
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

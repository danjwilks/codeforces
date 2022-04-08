import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class PaprikaAndPermutation {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        int ts = fr.nextInt();
        StringBuilder result = new StringBuilder();

        // for (int k = 1; k < 15; k++) {

        //     System.out.println("****");
        //     for (int j = k + 1; j >= 1; j--) {

                // we know each number can have a resultant modulus from 0 to n / 2
                // since from n / 2 to n - 1, the modulus is equal to n - k where k is between n / 2 to n - 1

        //     }

        // }

        for (int t = 0; t < ts; t++) {

            int n = fr.nextInt();
            Long[] arr = fr.nextLineAsLongArray(n);

            result.append(solve(arr) + "\n");

        }

        System.out.println(result.toString());

        // 3
        // 1 5 4

        // 5 -> 2 or 3
        // 5 mod 2 = 2 impossible to make into 3
        // 4 mod 

        // what are the conditions to make something into a remainder

        // remainder = x mod k
        // remainder can take values from 0 to min (k - 1, x)
        // 5 can become 5, 0, 1, 2, 1, 0

        // 4 mod 5 = 4
        // 4 mod 4 = 0
        // 4 mod 3 = 1
        // 4 mod 2 = 0
        // 4 mod 1 = 0

        // 5 mod 6 = 5
        // 5 mod 5 = 0
        // 5 mod 4 = 1
        // 5 mod 3 = 2
        // 5 mod 2 = 1
        // 5 mod 1 = 0

        // 6 mod 7 = 6
        // 6 mod 6 = 0
        // 6 mod 5 = 1
        // 6 mod 4 = 2
        // 6 mod 3 = 0
        // 6 mod 2 = 0
        // 6 mod 1 = 0



        // for each x, see what the maximum value we can make it,
        // set the item to the maximum
        // then, sort
        // see if there are any items s.t. it is less than the index

    }

    static long mod(long a, long b) {
        a = a % b;
        if (a < 0) {
            a += b;
        }
        return a;
    }

    static String solve(Long[] arr) {

        // 4 mod 1 = 0
        // 4 mod 2 = 0
        // 4 mod 3 = 1
        // 4 mod 4 = 0

        // 5 mod 1 = 0
        // 5 mod 2 = 1
        // 5 mod 3 = 2
        
        // 6 mod 1 = 0
        // 6 mod 2 = 0
        // 6 mod 3 = 0
        // 6 mod 4 = 2
        // 6 mod 5 = 1
        // 6 mod 6 = 0

        // if even, then can be between 0 to (n / 2) - 1

        Set<Long> seen = new HashSet<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (seen.contains(arr[i]) || arr[i] > arr.length) {

                if (arr[i] == 2) {
                    return "-1";
                }

                if (arr[i] % 2 == 0) {
                    arr[i] = - ((arr[i] / 2) - 1);
                } else {
                    arr[i] = - (arr[i] / 2);
                }
                count++;
            } else {

                seen.add(arr[i]);

            }
            
        }

        Arrays.sort(arr, (a, b) -> Long.compare(Math.abs(a), Math.abs(b)));

        for (int i = 0; i < arr.length; i++) {

            if (Math.abs(arr[i]) < i + 1) {
                return "-1";
            }

        }

        return String.valueOf(count);
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

        Long[] nextLineAsLongArray(int n) {
            Long[] result = new Long[n];

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

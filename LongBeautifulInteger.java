import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongBeautifulInteger {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        int n = fr.nextInt();
        int k = fr.nextInt();

        // if bi == bi+k, for all 1 <= i <= m - k, then 'beaut'

        // find a number y s.t. y >= x and y is 'beaut'

        // n = 3
        // k = 2
        // x = 353

        // y = 353
        
        // n = 4
        // k = 2
        // x = 1234

        // y = 1212 < x
        // y = 1313 > x

        // first check if x fits criteria for y
        // if not, increase the last non 9 number ( from the right) within the first k digits.

        // then add these digits as a cycle
        // if they are all 9, then x fits the criteria for y

        char[] digitsChar = fr.nextLine().toCharArray();
        int[] xDigits = new int[n];
        for (int i = 0; i < n; i++) {
            xDigits[i] = digitsChar[i] - '0';
        }

        int[] yDigits = new int[k];

        for (int i = 0; i < k; i++) {
            yDigits[i] = xDigits[i];
        }

        boolean isValid = true;

        // find first unequal number
        for (int i = 0; i < n; i++) {
            if (yDigits[i % k] < xDigits[i]) {
                isValid = false;
                break;
            }
            if (yDigits[i % k] > xDigits[i]) {
                isValid = true;
                break;
            }
        }

        System.out.println(n);

        if (isValid) {
            for (int i = 0; i < n; i++) {
                System.out.print(yDigits[i % k]);
            }
        } else {
            for (int i = k - 1; i >= 0; i--) {
                if (yDigits[i] != 9) {
                    yDigits[i] = yDigits[i] + 1;
                    break;
                } else {
                    yDigits[i] = 0;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(yDigits[i % k]);
            }
        }

        
    }

    static boolean calcUpdatedXIsSmaller(int[] digits, int k) {
        for (int i = k; i < digits.length; i++) {
            if (digits[i] > digits[i - k]) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(int[] digits, int k) {
        for (int i = 0; i < digits.length - k; i++) {
            if (digits[i] != digits[i + k]) {
                return false;
            }
        }
        return true;
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

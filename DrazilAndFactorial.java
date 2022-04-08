import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DrazilAndFactorial {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int n = fr.nextInt();

        // store digits as a string.

        char[] aDigits = fr.next().toCharArray();

        int[] xDigits = new int[10];

        for (int i = 0; i < n; i++) {
            
            int digit = aDigits[i] - '0';
            if (digit == 4) {
                xDigits[2] += 2;
                xDigits[3] += 1;
            } else if (digit == 6) { 
                xDigits[5] += 1;
                xDigits[3] += 1;
            } else if (digit == 8) {
                xDigits[7] += 1;
                xDigits[2] += 3;
            } else if (digit == 9) {
                xDigits[7] += 1;
                xDigits[2] += 1;
                xDigits[3] += 2;
            } else {
                xDigits[digit] += 1;
            }

        }

        StringBuilder sbr = new StringBuilder();
        for (int i = 9; i > 1; i--) {
            for (int j = 0; j < xDigits[i]; j++) {
                sbr.append(i);
            }
        }

        System.out.println(sbr.toString());


        // find maximal possible integer x s.t. 
        //      x doesn't contain 0 or 1
        //      F(x) == F(a)
        //      where a is given


        // F(x) = a1! * ... * ak! where x = a1 + ... + 10^kak
        // F(a) = b1! * ... * bm! where b = b1 + ... + 10^mam

        // we want the largest numbers to the left so this would be a larger number.
        
        // first, find F(a).
        // 
        // a factorial will never be a decimal
        // 

        // lets say all integers are 9.
        // 9!

        // find f(a),
        // essentially, we are trying to find the largest number x s.t.

        // f(x) = x1! * ... * xm! = a1! * ... * ak! = f(a)
        //      where a = a1 + ... + 10^kak, x = x1 + ... + 10^mxm

        // so, should we try to find the smallest factorials that divide 

        // does it make sense to have a 9?
        // 9!



        // 4! = 2 * 3 * 4
        // 2 * 3 * 2 * 2
        // does not make sense to use 4
        // 3! = 3 * 2
        // if it is a prime, then use it, otherwise, no
        //

        // 1! = 1
        // 2! = 1 * 2
        // 3! = 1 * 2 * 3
        // 4! = 1 * 2 * 3 * 4 => 1 * 2 * 3 * 2 * 2 => 3! * 2! * 2!
        // 5! = 1 * 2 * 3 * 4 * 5 => 1 * 2 * 3 * 2 * 2 * 5
        // 6! = 1 * 2 * 3 * 4 * 5 * 6 => 1 * 2 * 3 * 2 * 2 * 5 * 6
        //                            => 1 * 2 * 3 * 2 * 2 * 5 * 3!
        // 7!
        // 8! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 => 1 * 2 * 3 * 2 * 2 * 5 * 6 * 7 * 2 * 2 * 2
        // 9! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 => 1 * 2 * 3 * 2 * 2 * 5 * 6 * 7 * 8 * 


        // 9 = 3 * 3
        // 8 = 2 * 2 * 2
        // 9 = 3! * 3! * 2




        // but 5 is prime, so can not be broken down. it does not have any factors,
        //  the only way to get 5 is to use a factorial
        // try to use 2 and 3 the most.
        // then put 3 to the left as much as possible.
        // 
        //
        // can we just break down the given digits to their smallest factor?







    }

    public static String f(String x) {

        


        return "";
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

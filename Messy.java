import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Messy {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        StringBuilder result = new StringBuilder();
        
        int ts = fr.nextInt();
        for (int t = 0; t < ts; t++) {

            int n = fr.nextInt();
            int k = fr.nextInt();
            String s = fr.next();


            // ()(())()
            //
            // to make sure that there are only k prefixes that fit the criteria:
            //      what would be the arrangement?
            //      if k is 1, then only the whole s can fit criteria
            //      if k is more than 1, then the whole s and more prefixes can fit criteria
            
            // how can you ensure only 2 fit critiera
            // (((())))()
            // there should be k valid subsequences
            // i.e. (((())))((()))() = 3

            // how do we convert (()()()()))(()) into (((((())))))
            // if )(()))(( -> (((())))
            // 
            // start from the most left, is it correct?
            // we have to be sure that the subsection contains the right amount of openings and closings
            //
            // we can sort all of it into ((((()))))
            // then reverse               ((())(()))

            // step one, make k - 1 ()s at the end or start
            // the rest should be in one (((((())))))
            // say k = 2
            
            // say k = 2
            // we want one closedBrack from 0 to 1.

            result.append(solve(n, k, s.toCharArray()));

// 1
// 8 2
// ()(())()

        }

        System.out.println(result.toString());
    }

    static String solve(int n, int k, char[] s) {

        StringBuilder result = new StringBuilder();
        int m = 0;

        // print(s);

        for (int i = 0; i < k - 1; i++) {
            m += makeOneClosedBracketFrom(s, i * 2, result);
        }
        
        // print(s);

        m += makeBigClosedBracketFrom(s, (k - 1) * 2, result);

        // print(s);

        return m + "\n" + result.toString();
    }

    static int makeOneClosedBracketFrom(char[] s, int i, StringBuilder result) {
        int m = 0;

        if (s[i] == ')') { 
            int j = findNext(s, i + 1, '(');
            int a = i + 1;
            int b = j + 1;
            result.append(a + " " + b + "\n");
            reverse(s, i, j);

            m++;
        } 

        i++;

        if (s[i] == '(') {
            int j = findNext(s, i + 1, ')');
            int a = i + 1;
            int b = j + 1;
            result.append(a + " " + b + "\n");
            reverse(s, i, j);
            m++;


        }

        return m;
    }

    // static void print(char[] s) {
    //     System.out.println("****\n");
    //     for (int i = 0; i < s.length; i++) {
    //         System.out.print(s[i]);
    //     }
    //     System.out.println("\n****\n");
    // }

    static int makeBigClosedBracketFrom(char[] s, int i, StringBuilder result) {

        int m = 0;
        int noOpenings = (s.length - i) / 2;

        while (noOpenings != 0) {
            
            if (s[i] == ')') {
                int j = findNext(s, i + 1, '(');
                int a = i + 1;
                int b = j + 1;
                result.append(a + " " + b + "\n");
                reverse(s, i, j);
                m++;

            }

            noOpenings--;
            i++;
        }

        return m;
    }

    static int findNext(char[] s, int j, char target) {
        while (j < s.length && s[j] != target) {
            j++;
        }
        return j;
    }

    static void reverse(char[] s, int i, int j) {
        while (j - i > 0) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            j--;
            i++;
        }
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

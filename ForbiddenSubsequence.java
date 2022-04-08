import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ForbiddenSubsequence {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        int ts = fr.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < ts; t++) {

            String S = fr.nextLine();
            String T = fr.nextLine();

            result.append(solve(S, T) + "\n");

        }

        System.out.println(result.toString());
    }

    static String solve(String S, String T) {

        // does S contain a, b, c?
        // 
        boolean foundA = false;
        boolean foundB = false;
        boolean foundC = false;
        int cCount = 0;
        int bCount = 0;
        for (char c : S.toCharArray()) {
            if (c == 'a') {
                foundA = true;
            }
            if (c == 'b') {
                foundB = true;
                bCount++;
            }
            if (c == 'c') {
                foundC = true;
                cCount++;
            }
        }
        
        char[] sChars = S.toCharArray();
        Arrays.sort(sChars);
        
        if (foundA && foundB && foundC && T.charAt(0) == 'a' && T.charAt(1) == 'b' && T.charAt(2) == 'c') {

            int firstBIndex = 0;
            while (sChars[firstBIndex] != 'b') {
                firstBIndex++;
            }
             
            int index = firstBIndex;
            while (bCount > 0 || cCount > 0) {

                if (cCount > 0) {
                    sChars[index] = 'c';
                    cCount--;
                } else if (bCount > 0) {
                    sChars[index] = 'b';
                    bCount--;
                }
                index++;
            }

        }

        return String.valueOf(sChars);
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

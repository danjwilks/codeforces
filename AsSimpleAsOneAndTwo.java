import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AsSimpleAsOneAndTwo {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        int ts = fr.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < ts; t++) {
            String s = fr.nextLine();
            result.append(solve(s));
        }

        System.out.println(result.toString());

    }

    static String solve(String s) {
        
        // oneee
        // 
        
        // must always delete the middle character
        //
        // since there will only be one of it
        // and thus, deleting it, will make the word invalid
        // and then either oe or to will be left.
        // this is an issue since to -> oe
        // twone should become twne
        // how to identify when to not use the middle one

        // is it possible to always just delete one of characters from each word?

        // twone -> o
        // twoone -> w,n
        
        // when does deleting a character make a new word with the previous word

        // twoaslkdone
        // twoooooone
        
        // is there more than one scenario other than when there are lots of 'o'
        //
        //
        // onetwo
        // always delete the o?
        // delete the middle character always, except when the o is shared
        //
        // twoone


        
        List<Integer> result = new ArrayList<>();
        
        int i = 0;

        while (i < s.length() - 2) {

            if (s.charAt(i) == 't' && s.charAt(i + 1) == 'w' && s.charAt(i + 2) == 'o') {

                //  twone
                if (i + 4 < s.length() && s.charAt(i + 3) == 'n' && s.charAt(i + 4) == 'e') {
                    result.add(i + 2 + 1);
                    i += 5;
                } else { // two
                    result.add(i + 1 + 1);
                    i += 3;
                } 

            } else if (s.charAt(i) == 'o' && s.charAt(i + 1) == 'n' && s.charAt(i + 2) == 'e') {
                // one
                result.add(i + 1 + 1);
                i += 3;

            } else {
                i++;
            }
        }

        StringBuilder sbr = new StringBuilder();
        sbr.append(result.size() + "\n");
        for (int n : result) {
            sbr.append(n + " ");
        }
        sbr.append("\n");
        return sbr.toString();
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

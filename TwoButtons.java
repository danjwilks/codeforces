
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoButtons {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int current = fr.nextInt();
        int target = fr.nextInt();

        int count = 0;

        while (current != target) {

            if (target - current < 0) {
                count += current - target;
                current = target;   
            } else if (target % 2 != 0) {
                target += 1;
                count += 1;
            } else {    
                target /= 2;
                count += 1;
            }

        }

        System.out.println(count);

        // start = 1
        // target = 10

        // 1, 2, 4, 8, 16, 15, 14, 13, 12, 11, 10
        // 1, 2, 4, 8,  7,  6,  5, 10

        // start = 5
        // target = 11
        
        // 5, 10, 20, 19, 18, 17, ..., 11
        // 5, 4, 3, 6, 12, 11

        // start = 4
        // target = 25
        
        // 4, 8, 16, 32, 31, 30, 29, .., 25
        // 4, 8, 16, 15, 14, 13, 26, 25

        // start = 6
        // target = 25

        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21
        //          x                                                              x
        
        // 6, 12
        // 

        // 25 = 13 * 2 - 1 **** if we did 14 * 2, then we would have to minus 1 more times
        // 13 = 7 * 2 - 1  **** could this be less than the number required before?
        //  7 = 4 * 2 - 1  **** put this into a formula?

        // 25 = 14 * 2 - 3
        // 14 = 7 * 2
        //  7 = 4 * 2 - 1
        
        // 6, 5, 4, 8, 7, 14, 13, 26, 25

        // x = 

        // we know for a fact that we must multiply by 2, to a number larger than 25
        // and then minus at least 1.

        // what is the quiest way to 13?
        // 14 = 

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

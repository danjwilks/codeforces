
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PoloThePenguinAndMatrix {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        int[] line1 = fr.nextIntLine(3);

        int noRows = line1[0];
        int noColumns = line1[1];
        int d = line1[2];

        int noNumbers = noRows * noColumns;

        int[] flattenedMatrix = new int[noNumbers];
        flattenedMatrix[0] = fr.nextInt();
        int expectedRemainderModD = flattenedMatrix[0] % d;

        for (int i = 1; i < noNumbers; i++) {
            flattenedMatrix[i] = fr.nextInt();
            int actualRemainderModD = flattenedMatrix[i] % d;
            
            if (actualRemainderModD != expectedRemainderModD) {
                System.out.println(-1);
                return;
            }
        }

        Arrays.sort(flattenedMatrix);

        // 9 x
        // 8 x
        // 7 x
        // 6 x
        // 5 x 
        // 4 x x
        // 3 x x x
        // 2 x x x x x x x x x
        // 1 x x x x x x x x x

        // lets say I have to bring all to the level of the largest number

        // we can calculate the number we have to change by this

        // minimise( sum 1-N {Math.abs(ai - X)} )
        //
        // sum 1-N {Math.abs(ai - X)} = 

        // something I just discovered was that we want the difference between ai and X to be
        // smallest as possible for as most i as possible.
        //
        // so somewhere in the middle. But what number exactly?

        // we know for a fact that it is between min(ai) and max(ai).
        // 

        // okay so lets break down the above example
        

        // 3 x x
        // 2 x x x x x x x x x
        // 1 x x x x x x x x x
 

        // 3 x x x x
        // 2 x x x x x x x x x
        // 1 x x x x x x x x x

        // general rule - always remove number if there
        // if i < n / 2, then this is not the number to use.
        // but why
        

        // lets look at the extremes.
        // It does not make sense to use the largest number.
        // Using the same logic, it does not make sense to use the smallest number.
        // 


        // if we start at x = 0,
        // moving from 0 to k, decreases the amount of movement of rhs by steps * (n - k) and 

        // it increases the movement from lhs to k - 1

        // the way to solve this, was to look at each individual step,
        //  and to start from a peak, e.g. start from the situation 
        // in which we choose 0. Thus, 0 is a solution.
        //
        //
        // 0 - 1 ( assuming 1 is not the same as 0) 
        //      *** NOTE *** if 0 and 1 are equal, then choose the first non-equal element
        //                   this means that decreasing by 1 at this point means all the
        //                   lhs increase movement by 1 and all rhs decrease by 1.
        // increase lhs by 1 - 0.
        // decreases rhs by n - 1

        // this breaks down when there are multiple ai equal to each other.
        // IT CAN NOT DECREASING ONLY BY 1.
        // INSTEAD, IT IS DECREASING TO THE ACTUAL NUMBER AT THAT INDEX.

        // thus, moving from step 1 to step 2 means
        // lhs movement increases by step1-2 amount.
        // rhs movement decreases by step1-2 amount.

        // thus summing this change change equals to i * stepk - (n - i) * stepk
        // rewriting this, becomes
        // (2i - n) * stepk
        // so this change becomes zero when 2i == n
        // so i is equal to n / 2

        int chosenNumberIndex = noNumbers / 2;
        int chosenNumber = flattenedMatrix[chosenNumberIndex];
        int result = 0;

        for (int n : flattenedMatrix) {
            int diff = Math.abs(chosenNumber - n);
            result += (diff / d);
        }
        
        // 1000 numbers
        // of 10000
        // change could sum up to 10 ^4 * 10^3 = 10^7
        // 2^31

        System.out.println(result);

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

        int[] nextIntLine(int n) {
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

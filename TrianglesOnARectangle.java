import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TrianglesOnARectangle {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();

        // 
        // x x x x x x
        // x         x
        // x         x
        // x         x
        // x         x
        // x         x
        // x         x
        // x         x
        // x x x x x x
        // 


        // maximum is equal to 
        // either
        //  (w - 2) * h
        //  (h - 2) * w

        int ts = fr.nextInt();

        StringBuilder result = new StringBuilder();

        for (int t = 0; t < ts; t++) {

            int w = fr.nextInt();
            int h = fr.nextInt();

            int noSide1Points = fr.nextInt();
            int[] side1Points = new int[noSide1Points];
            for (int i = 0; i < noSide1Points; i++) {
                side1Points[i] = fr.nextInt();
            }

            int noSide2Points = fr.nextInt();
            int[] side2Points = new int[noSide2Points];
            for (int i = 0; i < noSide2Points; i++) {
                side2Points[i] = fr.nextInt();
            }

            int noSide3Points = fr.nextInt();
            int[] side3Points = new int[noSide3Points];
            for (int i = 0; i < noSide3Points; i++) {
                side3Points[i] = fr.nextInt();
            }

            int noSide4Points = fr.nextInt();
            int[] side4Points = new int[noSide4Points];
            for (int i = 0; i < noSide4Points; i++) {
                side4Points[i] = fr.nextInt();
            }

            // find the largest gap between side 1 points and side 2 points

            long sides1And2LargestGap = Math.max(findLargestGap(side1Points), findLargestGap(side2Points));
            long sides3And4LargestGap = Math.max(findLargestGap(side3Points), findLargestGap(side4Points));
            
            long maxArea = Math.max(sides1And2LargestGap * (long) h, sides3And4LargestGap * (long) w);

            result.append(maxArea + "\n");

        }

        System.out.println(result.toString());

        


    }

    static int findLargestGap(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int largest = -1;

        for (int x : arr) {
            smallest = Math.min(x, smallest);
            largest = Math.max(x, largest);
        }

        return largest - smallest;
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

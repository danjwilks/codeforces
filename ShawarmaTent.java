import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShawarmaTent {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        long sx = fr.nextLong();
        long sy = fr.nextLong();

        // . . x . . .
        // . . . . . x
        // . . . . . x
        // . x . . . .
        // . . O . . .
        // . . . . x .

        // there are 4 possible solutions to this.
        // adjacent from the school by 1

        // the shortest path from the school to anywhere on the 
        // left (where left is not on the same y axis of the school)

        // iterate through all houses
        // increase counts for each tent location
        // if an optimal path can be reached from it
        

        int leftCount = 0;
        int upCount = 0;
        int rightCount = 0;
        int downCount = 0;

        for (int i = 0; i < n; i++) {

            int x = fr.nextInt();
            int y = fr.nextInt();

            // left
            if (x < sx) {
                leftCount++;
            }

            // up 
            if (y < sy) {
                upCount++;
            }

            // right
            if (x > sx) {
                rightCount++;
            }

            // down
            if (y > sy) {
                downCount++;
            }

        }
    
        Position[] positions = new Position[]{
            new Position(leftCount, -1, 0),
            new Position(upCount, 0, -1),
            new Position(rightCount, 1, 0),
            new Position(downCount, 0, 1)
        };

        Arrays.sort(positions, (p1, p2) -> p2.count - p1.count);

        System.out.println(positions[0].count);
        long xCoord = sx + positions[0].xDiff;
        long yCoord = sy + positions[0].yDiff;
        System.out.println(xCoord + " " + yCoord);

    }

    static class Position {
        int count;
        long xDiff;
        long yDiff;
        Position(int count, long xDiff, long yDiff) {
            this.count = count;
            this.xDiff = xDiff;
            this.yDiff = yDiff;
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

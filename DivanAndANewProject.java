import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DivanAndANewProject {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int ts = fr.nextInt();

        for (int t = 0; t < ts; t++) {

            int n = fr.nextInt();
            int[][] buildingTimes = new int[n][2];
            
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                buildingTimes[i][0] = fr.nextInt();
                buildingTimes[i][1] = i;
            }

            Arrays.sort(buildingTimes, (a, b) -> b[0] - a[0]);

            long sumDist = 0;

            for (int i = 0; i < n; i++) {
                long numVisits = buildingTimes[i][0];
                int originalIndex = buildingTimes[i][1];


                int dist = (i / 2) + 1;
                int newIndex = dist;
                
                if (i % 2 == 1) {
                    // i = 1, 3, 5 -> -1, -2, -3
                    newIndex = dist * (-1);
                }

                sumDist += ((long) dist) * 2 * numVisits;
                result[originalIndex] = newIndex;

            }

            System.out.println(sumDist);
            System.out.print(0 + " ");
            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }

            System.out.print('\n');
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

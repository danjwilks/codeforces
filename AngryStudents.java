import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AngryStudents {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        int t = fr.nextInt();

        for (int i = 0; i < t; i++) {

            int k = fr.nextInt();
            String students = fr.nextLine();
            
            // we are looking for the largest gap between an angry person 
            // and a non angry person

            int largestGap = 0;
            int lastAngryStudent = -1;
            int currStudent = 0;

            while (currStudent < k) {

                boolean currStudentIsAngry =  students.charAt(currStudent) == 'A';

                // A P P P
                // 0 1 2 3

                if (!currStudentIsAngry && lastAngryStudent != -1) {

                    int currGap = currStudent - lastAngryStudent;
                    largestGap = Math.max(currGap, largestGap);

                } else if (currStudentIsAngry) {
                    
                    if (lastAngryStudent != -1) {
                        int currGap = currStudent - lastAngryStudent - 1;
                        largestGap = Math.max(currGap, largestGap);
                    }

                    lastAngryStudent = currStudent;

                }

                currStudent++;

            }

            System.out.println(largestGap);

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

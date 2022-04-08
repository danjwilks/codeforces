import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exams {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int n = fr.nextInt();

        // 3
        // 5 2
        // 3 1
        // 4 2

        
        
        // 3 1
        // 4 2
        // 5 2
        // 6 1
        // 7 2

        // sort smallest to largest orginal date
        // we know those with smaller original dates must go first 

        // 5 1
        // 5 2
        // 5 3
        // 5 2
        // 5 3


        
        // 3 1
        // 4 2
        // 5 2
        // 6 1

        Exam[] exams = new Exam[n];

        for (int i = 0; i < n; i++) {
            int originalDate = fr.nextInt();
            int earlierDate = fr.nextInt();

            exams[i] = new Exam(originalDate, earlierDate);

        }

        Arrays.sort(exams, (a, b) -> a.originalDate == b.originalDate ? a.earlierDate - b.earlierDate : a.originalDate - b.originalDate);


        int curr = 0;

        for (int i = 0; i < n; i++) {

            if (exams[i].earlierDate >= curr) {
                curr = exams[i].earlierDate;
            } else {
                curr = exams[i].originalDate;
            }

        }

        System.out.println(curr);



    }

    static class Exam {

        int originalDate;
        int earlierDate;
        Exam(int og, int er) {
            this.originalDate = og;
            this.earlierDate = er;
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

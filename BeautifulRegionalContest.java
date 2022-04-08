import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeautifulRegionalContest {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        
        int ts = fr.nextInt();
 
        StringBuilder result = new StringBuilder();
 
        for (int t = 0; t < ts; t++) {
            int n = fr.nextInt();
            result.append(solve(fr.nextLineAsIntArray(n)) + "\n");
 
        }
 
        System.out.println(result.toString());
 
    }

    static String solve(int[] arr) {
 
        if (arr.length < 8) { 
            return "0 0 0";
        }
 
        
        int goldValue = arr[0];
        int i = 0;
        int golds = 0;
        while (i < arr.length && arr[i] == goldValue) { // TODO tighten up i < arr.length
            golds++;
            i++;
        }

        if (i == arr.length) {
            return "0 0 0";
        }
 
        int silvers = 0;
        int silverValue = arr[i];
        while (i < arr.length && (silvers <= golds || arr[i] == silverValue)) { // TODO tighten up i < arr.length
            silverValue = arr[i];
            silvers++;
            i++;
        }
 
        if (golds >= silvers || i == arr.length) {
            return "0 0 0";
        }
 
        // i is now at the first bronze participant
 
        // 10 9 7 7|7 7 7 7
        //      i  | half
        //
 
        // 10 9|8 7 6
        //     | split here
        
        // find the first index before the half
        // even length n -> (n / 2) - 1
        // odd length n -> (n / 2) - 1
 
        int firstIndexAfterHalf = (arr.length / 2) - 1;
        int invalidBronzeValue = arr[firstIndexAfterHalf + 1];

        int r = firstIndexAfterHalf;

        while (r > i && arr[r] == invalidBronzeValue) {
            r--;
        }

        // 10 9 8 7 7 7 7 7 7 7
        //      ir
        // invalid = 7
 
        int bronzes = r - i + 1;
 
        // we should give away the minimum number of golds
        // then fill the rest with silver and bronze
        // should we fill the minimum with silver as well?
        // yes
        // then we should fill the left availble with bronze
        //      only people in the first half and that doesn't
        //      include duplicate numbers into the second half
 
        if (golds >= bronzes || golds >= silvers) {
            return "0 0 0";
        }
 
        return golds + " " + silvers + " " + bronzes;
    }
    

    // public static void main(String[] args) {
        
    //     FastReader fr = new FastReader();
        
    //     int ts = fr.nextInt();

    //     StringBuilder result = new StringBuilder();

    //     for (int t = 0; t < ts; t++) {
    //         int n = fr.nextInt();
    //         result.append(solve(fr.nextLineAsIntArray(n)) + "\n");

    //     }

    //     System.out.println(result.toString());

    // }

    // static String solve(int[] arr) {

    //     String noSolutionResult = "0 0 0";

    //     if (arr.length < 6) { 
    //         return noSolutionResult;
    //     }

    //     // 10 9 8 8 8 8

    //     int medalCutoffIndex = (arr.length / 2) - 1;
    //     int lastGoldIndex = findLastGoldIndex(arr);

    //     if (lastGoldIndex + 2 > medalCutoffIndex) {
    //         return noSolutionResult;
    //     }

    //     int lastSilverIndex = findLastSilverIndex(arr, lastGoldIndex);

    //     if (lastSilverIndex + 1 > medalCutoffIndex) {
    //         return noSolutionResult;
    //     }

    //     int lastBronzeIndex = findLastBronzeIndex(arr, lastSilverIndex);

    //     if (lastBronzeIndex > medalCutoffIndex) {
    //         return noSolutionResult;
    //     }

    //     // 10 9 8
    //     // G  G S
    //     int noGolds = lastGoldIndex + 1;
    //     int noSilvers = lastSilverIndex - lastGoldIndex;
    //     int noBronzes = lastBronzeIndex - lastSilverIndex;

    //     if (noGolds <= noSilvers || noGolds <= noBronzes) {
    //         return noSolutionResult;
    //     }

    //     return noGolds + " " + noSilvers + " " + noBronzes;
    // }

    // static int findLastGoldIndex(int[] arr) {


    // }


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

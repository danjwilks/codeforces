
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KalindromeArray {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        StringBuilder result = new StringBuilder();
        int ts = fr.nextInt();

        for (int t = 0; t < ts; t++) {

            int n = fr.nextInt();
            int[] elements = new int[n];

            for (int i = 0; i < n; i++) {
                elements[i] = fr.nextInt();
            }

            int left = 0;
            int right = n - 1;

            boolean isValid = true;

            while (right - left > 0) {
                if (elements[left] != elements[right]) {

                    if (
                        !isKalindromeWithNo(elements, elements[left])
                        && !isKalindromeWithNo(elements, elements[right]) 
                    ){
                        isValid = false;
                    }

                    break;
                }

                left++;
                right--;
            }

            if (isValid) {
                result.append("YES");
            } else {
                result.append("NO");
            }
            result.append("\n");

        }

        System.out.println(result.toString());

    }

    public static boolean isKalindromeWithNo(int[] elements, int remove) {
         int left = 0;
         int right = elements.length - 1;
         
         while (right - left > 0) {

            if (elements[left] == remove) {
                left++;
            } else if (elements[right] == remove) {
                right--;
            } else if (elements[left] != elements[right]){
                return false;
            } else {
                left++;
                right--;
            }

         }

         return true;
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

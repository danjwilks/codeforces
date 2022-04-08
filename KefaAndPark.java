import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class KefaAndPark {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int numVerticies = fr.nextInt();
        int maxConsecutiveCats = fr.nextInt();

        ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
        Set<Integer> restaurantsCanVisit = new HashSet<>();

        int[] isCat = new int[numVerticies + 1];
        for (int i = 1; i <= numVerticies; i++) {
            isCat[i] = fr.nextInt();
        }

        for (int i = 0; i <= numVerticies; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < numVerticies - 1; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        Set<Integer> visited = new HashSet<>();
        findAllRoutes(tree, visited, restaurantsCanVisit, 1, isCat, maxConsecutiveCats, 0);

        System.out.println(restaurantsCanVisit.size());

    }

    public static void findAllRoutes(ArrayList<ArrayList<Integer>> tree, Set<Integer> visited, Set<Integer> restaurantsCanVisit, int currNode, int[] isCat, int maxConsecutiveCats, int consectutiveCats) {

        visited.add(currNode);

        if (isCat[currNode] == 1) {
            consectutiveCats++;
        } else {
            consectutiveCats = 0;
        }

        if (consectutiveCats > maxConsecutiveCats) {
            return;
        }

        if (currNode != 1 && tree.get(currNode).size() == 1) {
            restaurantsCanVisit.add(currNode);
            return;
        }

        for (int childNode : tree.get(currNode)) {
            if (!visited.contains(childNode)) {
                findAllRoutes(tree, visited, restaurantsCanVisit, childNode, isCat, maxConsecutiveCats, consectutiveCats);
            }
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

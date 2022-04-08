
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KeshiIsThrowingAParty {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        StringBuilder result = new StringBuilder();

        int ts = fr.nextInt();

        for (int t = 0; t < ts; t++) {

            int n = fr.nextInt();

            int[] poorer = new int[n];
            int[] richer = new int[n];



            for (int i = 0; i < n; i++) {
                richer[i] = fr.nextInt();
                poorer[i] = fr.nextInt();
            }

            result.append(solve(richer, poorer));
            result.append("\n");
            

        }
        // System.out.println("\n");
        System.out.println(result.toString());

    }

    public static int solve(int[] richer, int[] poorer) {

        int h = richer.length;
        int l = 1;

        while (h - l > 1) {

            // BS WILL GO ON FOREVER IF It FINDS SOLUTION
            // AND L = M ALREADY

            // l = 2
            // h = 3
            // m = (2 + 3) / 2 = 2
            // finds solution
            // l = m

            // infinite loop

            int targetInvited = l + (h - l) / 2;
            boolean foundSolution = hasSolution(targetInvited, richer, poorer);

            if (foundSolution) {
                l = targetInvited;
            } else {
                h = targetInvited - 1;
            }
        }

        if (l != h) {
            if (hasSolution(h, richer, poorer)) {
                return h;
            } else {
                return l;
            }
        }

        return l;
    }

    public static boolean hasSolution(int targetInvited, int[] richer, int[] poorer) {

        int actualInvited = 0;

        for (int i = 0; i < richer.length; i++) {

            int leftToInvite = targetInvited - actualInvited;

            if (
                richer[i] >= leftToInvite - 1
                && poorer[i] >= actualInvited
            ) {
                actualInvited++;
            } 

            if (actualInvited == targetInvited) {
                return true;
            }
        }

        return false;

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

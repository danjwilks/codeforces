import java.util.Scanner;

public class TPrimes {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int upperLimit = (int) Math.pow(10, 6);
        boolean[] isNotPrime = generatePrimeSqaures(upperLimit);

        StringBuilder sbr = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long j = sc.nextLong();
            double sqrt = Math.sqrt(j);
            if (sqrt % 1 == 0 && !isNotPrime[(int)sqrt]) {
                sbr.append("YES");
                
            } else {
                sbr.append("NO");
            }
            sbr.append("\n");
        }

        System.out.println(sbr.toString());
        sc.close();

    }

    public static boolean[] generatePrimeSqaures(int n) {

        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        //   
        // a1^x1 * ... * ak^xk
        // prime if k == 2,
        // 
        // if we think of a l and right p

        for (int step = 2; step * step <= n; step++) {

            for (int j = step + step; j <= n; j += step) {
                isNotPrime[j] = true;
            }
        }

        return isNotPrime;

    }


}

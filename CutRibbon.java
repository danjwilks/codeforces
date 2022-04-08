import java.util.Scanner;

public class CutRibbon {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] lengths = new int[3];
        for (int i = 0; i < 3; i++) {
            lengths[i] = sc.nextInt();
        }

        // primes
        // n = a1^x1 * ... * ak^xk
        
        // general solution
        // n = k1 * a + k2 * b + k3 * c
        // 

        // n = 5
        // lengths = 2, 3, 5

        // 0, 1, 2, 3, 4, 5
        // 0, 0, 1, 1, 2, 2
        
        int[] cuts = new int[n + 1];
        for (int i = 0; i < n; i++) {

            if (i != 0 && cuts[i] == 0) {
                continue;
            }

            for (int length : lengths) {
                if (i + length <= n) {
                    cuts[i + length] = Math.max(cuts[i] + 1, cuts[i + length]);
                }
            }
        }

        System.out.println(cuts[n]);
        sc.close();
    }
    
}

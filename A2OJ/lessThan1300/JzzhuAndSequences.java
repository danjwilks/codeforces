import java.util.Scanner;

public class JzzhuAndSequences {

    public static int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split("\\s+");
        String line2 = sc.nextLine();

        

        int x = Integer.parseInt(line1[0]);
        int y = Integer.parseInt(line1[1]);

        int n = Integer.parseInt(line2);

        // f1 = x
        // f2 = y = x + f3
        // f3 = f2 + f4 = x + f3 + f4
        // f4 = f3 + f5 = x + f3 + f4 + f5
        // f5 = f4 + f6
        // f6 = f5 + f7
        // f7 = f6 + f8
        

        // f6 = f5 + f7
        // f6 = f4 + f6 + f7
        // 0 = f4 + f7
        // f7 = - f4
        // f7 = - (-x) = x

        // f1 = x
        // f2 = y
        // f3 = y - x
        // f4 = -x
        // f5 = -y
        // f6 = x - y
        // f7 = x

        int bigModN = 1000000007;
        int mod6 = mod(n - 1, 6);

        if (mod6 == 0) {
            System.out.println(mod(x, bigModN));
        } else if (mod6 == 1) {
            System.out.println(mod(y, bigModN));
        } else if (mod6 == 2) {
            System.out.println(mod(y - x, bigModN));
        } else if (mod6 == 3) {
            System.out.println(mod(-x, bigModN));
        } else if (mod6 == 4) {
            System.out.println(mod(-y, bigModN));
        } else if (mod6 == 5) {
            System.out.println(mod(x - y, bigModN));
        }

        sc.close();
    }

    public static int mod(int n, int m) {
        int result = n % m;
        if (result < 0) {
            result += m;
        }
        return result;
    }
    
}

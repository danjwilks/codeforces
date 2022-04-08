import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < k; i++) {

            int[] testCase = parseTestCase(sc.nextLine());
            
            solve(testCase);

        }
        sc.close();
    }

    public static int[] parseTestCase(String s) {

        String[] lineSplit = s.split("\\s+");
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = Integer.parseInt(lineSplit[i]);
        }

        return result;

    }

    public static void solve(int[] tc) {

        int a1 = tc[0];
        int a2 = tc[1];
        int a3 = tc[2];

        int result = a1 + a3 - 2 * a2;
        result = result % 3;
        if (result < 0) {
            result += 3;
        }

        if (result == 0) {
            System.out.println("0");    
        } else {
            System.out.println("1");    
        }       

    }
}
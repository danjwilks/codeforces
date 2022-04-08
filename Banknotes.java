import java.util.Scanner;

public class Banknotes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        while (sc.hasNext()) {
            String[] line1 = sc.nextLine().split("\\s+");
            int n = Integer.parseInt(line1[0]);
            int k = Integer.parseInt(line1[1]);

            String[] line2 = sc.nextLine().split("\\s+");
            int[] ints = new int[line2.length];
            for (int i = 0; i < line2.length; i++){
                ints[i] = Integer.parseInt(line2[i]);
            }

            solve(n, k, ints);

        }
        sc.close();
    }

    public static void solve(int n, int k, int[] ints) {

        // 3 13
        // 0 1 2 -> 1, 10, 20

        // maximum 13 banknotes
        // we know 

        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 1
        
        // 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        //  2,  3,  4,  5,  6,  7,  8,  9, 10,  1
        
        // 21, 22, 23, 24, 25, 26, 27, 28, 29, 30
        //  2,  3,  4,  5,  6,  7,  8,  9, 10,  2

        // 31, 32, 33, 34, 35, 36, 37, 38, 39, 40
        //  3,  4,  5,  6,  7,  8,  9, 10, 11,  3

        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3

        // k is NOT irrelvant
        // 



        // there is a cycle, the number increases until a new denomination is found.
        // so we can cache each result maybe?
        // iterate through?
        // can it be calculated in constant time?


        // we know that 
        // if 
        //  the jump between the first and second denomination is
        //      more than k, then the solution is between the first and second denomination
        //
        // otherwise, 
        //  we must use the second denomination until the the number of notes left available 
        //      is less than k.

        // think about third denominations though.. what happens then?
        //

        // an integer is represented in banknotes as
        //  b1 * 10a1 + b2 * 10a2 + b3 * 10a3 + ... + bj * 10aj
        //
        // we want to minimise (b1 * 10a1 + ... + bj * 10aj) where 
        //      b1 + ... + bj <= k

        //

    }
}
